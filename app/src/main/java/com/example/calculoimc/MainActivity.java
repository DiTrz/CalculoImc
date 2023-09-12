package com.example.calculoimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText ptPeso, ptAltura;
    Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ptPeso = (EditText)findViewById(R.id.ptPeso);
        EditText ptAltura = (EditText)findViewById(R.id.ptAltura);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso = Double.parseDouble(ptPeso.getText().toString());
                double altura = Double.parseDouble(ptAltura.getText().toString());

                double imc = peso / (altura * altura);
                String result = String.format("%.2f", imc);

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);

                if(imc < 20)
                {
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage("Seu IMC é: " + result + "\nVoce esta abaixo do peso!");
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }
                else if(imc >20 && imc <= 25)
                {
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage("Seu IMC é: {.2f}" + result + "\nPeso Ideal");
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }
                else if(imc >25 && imc <= 30)
                {
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage("Seu IMC é: " + result + "\nSobrepeso");
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }
                else if(imc >30 && imc <= 35)
                {
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage("Seu IMC é: " + result + "\nObesidade Moderada");
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }
                else if(imc >35 && imc <= 40)
                {
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage("Seu IMC é: " + result + "\nObesidade Severa");
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }
                else if(imc >40 && imc <= 50)
                {
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage("Seu IMC é: " + result + "\nObesidade Mórbida");
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }
                else
                {
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage("Seu IMC é: " + result + "\nPerigo Extremo!!!");
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }


            }
        });
    }
}