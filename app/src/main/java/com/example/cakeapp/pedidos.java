package com.example.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class pedidos extends AppCompatActivity {


     Button bcalcular, bcancelar;
    CheckBox  op1, op2, op3, op4, op5, op6 ;
    RadioButton  sab1, sab2,sab3, sab4,sab5, sab6, tam1, tam2, tam3 ;
     TextView ttotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        op3 = findViewById(R.id.op3);
        op4 = findViewById(R.id.op4);
        op5 = findViewById(R.id.op5);
        op6 = findViewById(R.id.op6);

        tam1 = findViewById(R.id.tam1);
        tam2 = findViewById(R.id.tam2);
        tam3 = findViewById(R.id.tam3);

        sab1 = findViewById(R.id.sab1);
        sab2 = findViewById(R.id.sab2);
        sab3 = findViewById(R.id.sab3);
        sab4 = findViewById(R.id.sab4);
        sab5 = findViewById(R.id.sab5);
        sab6 = findViewById(R.id.sab6);


        ttotal= findViewById(R.id.ttotal);


    }

    public void calcular (View v){

        Double total=0.0;
        if(tam1.isChecked())
            total= total + 150;
        if(tam2.isChecked())
            total= total + 80;
        if(tam3.isChecked())
            total= total + 50;


        if(sab1.isChecked())
            total= total + 30;
        if(sab2.isChecked())
            total= total + 30;
        if(sab3.isChecked())
            total= total + 30;
        if(sab4.isChecked())
            total= total + 10;
        if(sab5.isChecked())
            total= total + 40;
        if(sab6.isChecked())
            total= total + 40;


        if(op1.isChecked())
            total= total + 15;
        if(op2.isChecked())
            total= total + 15;
        if(op3.isChecked())
            total= total + 5;
        if(op4.isChecked())
            total= total + 5;
        if(op5.isChecked())
            total= total + 10;
        if(op6.isChecked())
            total= total + 10;

        ttotal.setText("Total:$"+total);
    }

    public void cancelar(View v){


        op1.setChecked(false);
        op2.setChecked(false);
        op3.setChecked(false);
        op4.setChecked(false);
        op5.setChecked(false);
        op6.setChecked(false);

        tam1.setChecked(false);
        tam2.setChecked(false);
        tam3.setChecked(false);

        sab1.setChecked(false);
        sab2.setChecked(false);
        sab3.setChecked(false);
        sab4.setChecked(false);
        sab5.setChecked(false);
        sab6.setChecked(false);


        ttotal.setText("Total=$0");

    }
}