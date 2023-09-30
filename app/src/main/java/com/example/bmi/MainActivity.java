package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.bmi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView txtResult;
        EditText edtWeight , edtHeightft, edtHeightIn;
        Button btnCalculate;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightft = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int wt = Integer.parseInt(edtWeight.getText().toString());
               int htf = Integer.parseInt(edtHeightft.getText().toString());
               int hti = Integer.parseInt(edtHeightIn.getText().toString());

               int totalIn = htf*12+hti;

               double totalcm = totalIn*2.53;
               double totalmt = totalcm/100;

               double bmi = wt/(totalmt*totalmt);
               if(bmi>25){
                   txtResult.setText("You Are OverWeight");
               }else if(bmi<18){
                   txtResult.setText("You are Under Weight");
               }
               else {
                   txtResult.setText("You are healthy");
               }

            }
        });
    }
}