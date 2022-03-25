package com.example.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registro extends AppCompatActivity {

    Button btn_insert, redireccionar;
    EditText txtName, txtEmail, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btn_insert = (Button) findViewById(R.id.btn_register);
        redireccionar = (Button) findViewById(R.id.btnRedir);
        txtName = (EditText) findViewById(R.id.ednombre);
        pass = (EditText) findViewById(R.id.etcontrasena);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        redireccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(registro.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    private void insertData() {

        final String nombre = txtName.getText().toString().trim();
        final String password = pass.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando...");

        if (nombre.isEmpty()) {


            txtName.setError("complete los campos");
            return;
        } else if (password.isEmpty()) {

            pass.setError("complete los campos");
            return;
        } else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://169.254.110.43/CAKE/insertar.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if (response.equalsIgnoreCase("Datos insertados")) {

                                Toast.makeText(registro.this, "Datos insertados", Toast.LENGTH_SHORT).show();

                                progressDialog.dismiss();

                                Intent intent = new Intent(registro.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(registro.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                Toast.makeText(registro.this, "No se puede insrtar", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(registro.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("nombre", nombre);
                    params.put("password", password);


                    return params;

                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(registro.this);
            requestQueue.add(request);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void login(View v) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}