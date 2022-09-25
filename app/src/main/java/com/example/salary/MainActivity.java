package com.example.salary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private RadioButton forthPercent, fortyFivePercent, fifthPercent;
    private EditText salaryInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.resultText);
        forthPercent = findViewById(R.id.forthPercent);
        fortyFivePercent = findViewById(R.id.fortyFivePercent);
        fifthPercent = findViewById(R.id.fifthPercent);
        salaryInput = findViewById(R.id.salaryInput);


    }

    public void handleCalc(View view) {

        double valorSalario = Double.parseDouble(salaryInput.getText().toString());
        DecimalFormat form = new DecimalFormat("R$: 0.00");

        AlertDialog.Builder cxMsg = new AlertDialog.Builder(this);
        cxMsg.setTitle("Erro");
        cxMsg.setMessage("Digite um valor válido e um percentual");
        cxMsg.setNeutralButton("OK", null);


        if (forthPercent.isChecked() && valorSalario > 0){

            double novoSalario = valorSalario * 1.40;
            resultText.setText(form.format(novoSalario));

        }else if (fortyFivePercent.isChecked() && valorSalario > 0){

            double novoSalario = valorSalario * 1.45;
            resultText.setText(form.format(novoSalario));

        }else if (fifthPercent.isChecked() && valorSalario > 0){

            double novoSalario = valorSalario * 1.50;
            resultText.setText(form.format(novoSalario));

        }else if (!forthPercent.isChecked() && !fortyFivePercent.isChecked() && !fifthPercent.isChecked()){
            cxMsg.show();

        }





    }
}