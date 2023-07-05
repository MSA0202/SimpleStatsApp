package com.example.statsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Double> numbers = new ArrayList<Double>();
    private EditText text;
    private TextView viewArr;
    private Button buttonadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editText1);
        viewArr = findViewById(R.id.inputted);
        buttonadd = findViewById(R.id.button);


        // Set the text block to empty once clicked
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
            }
        });

        // Set the text block to empty once clicked
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAdd(v); //add to the array
                display();//then display array
            }
        });

    }

    public void display(){
        viewArr.setText(numbers.toString());
    }

    public void doAdd(View v){
        EditText e = (EditText)findViewById(R.id.editText1);
        String value = text.getText().toString();
        if (value.isEmpty()) {
            Toast.makeText(this, "Please enter a value.", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            Double d = Double.parseDouble(value);
            numbers.add(d);
            e.setText("");
        }
        catch(NumberFormatException ex){
            Toast.makeText(this,"Please enter a number.",Toast.LENGTH_SHORT).show();
        }
    }
    public void doMean(View v){
        TextView o = (TextView) findViewById(R.id.outtext);
        Double meann = Calculator.getMean(numbers);
        String m = Double.toString(meann);
        o.setText(m);

    }

    public void doVariance(View v){
        TextView o = (TextView) findViewById(R.id.outtext);
        Double Vari = Calculator.getVariance(numbers);
        String va = Double.toString(Vari);
        o.setText(va);
    }

    public void doStdDev(View v){
        TextView o = (TextView) findViewById(R.id.outtext);
        Double stddev = Calculator.getStdDev(numbers);
        String s = Double.toString(stddev);
        o.setText(s);
    }


}