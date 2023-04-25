package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText num, num1, num2;
    Button compute, add1, add2, enter, clear;
    TextView disp, disp1, disp2, sf1;

    int size;

    ArrayList<Integer> arr1 = new ArrayList<>();
    ArrayList<Integer> arr2 = new ArrayList<>();
    ArrayList<Float> avg = new ArrayList<>();
    ArrayList<Float> normalizedArray = new ArrayList<>();

    String a1 = "";
    String a2 = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = findViewById(R.id.n);
        num1 = findViewById(R.id.n1);
        num2 = findViewById(R.id.n2);
        disp = findViewById(R.id.disp);
        sf1 = findViewById(R.id.sf);
        disp1 = findViewById(R.id.disp_1);
        disp2 = findViewById(R.id.disp_2);

        enter = findViewById(R.id.enter);
        enter.setOnClickListener(this);

        add1 = findViewById(R.id.add_1);
        add1.setOnClickListener(this);

        add2 = findViewById(R.id.add_2);
        add2.setOnClickListener(this);

        compute = findViewById(R.id.compute);
        compute.setOnClickListener(this);

        clear = findViewById(R.id.clear);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.equals(enter))
        {
            size = Integer.parseInt(num.getText().toString());
            Toast.makeText(this, "Array size : " + size, Toast.LENGTH_SHORT).show();
        }

        if(v.equals(add1)) {
            if(arr1.size()<size)
            {

                int a = Integer.parseInt(num1.getText().toString());
                if (a>=0 && a<= 255) {
                    arr1.add(a);
                    a1 = a1  + "   "+ a ;
                    disp1.setText("[" + a1 + "  ]");
                }
                else {
                    Toast.makeText(this, "Please Enter number between 0 to 255", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(this, "Array size limit exceeded", Toast.LENGTH_SHORT).show();
            }
            num1.getText().clear();
        }

        if(v.equals(add2)) {
            if(arr2.size()<size)
            {

                int b = Integer.parseInt(num2.getText().toString());
                if (b>=0 && b<= 255) {
                    arr2.add(b);
                    a2 = a2 + "   " + b ;
                    disp2.setText("[" + a2  + "  ]");
                }
                else {
                    Toast.makeText(this, "Please Enter number between 0 to 255", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(this, "Array size limit exceeded", Toast.LENGTH_SHORT).show();
            }
            num2.getText().clear();
        }
        if (v.equals(compute))
        {
            for (int i = 0; i<size; i++)
            {
                avg.add((float) ((arr1.get(i) + arr2.get(i))/2));
            }

            float sf = 255/Collections.max(avg);

            for(int i = 0; i<size; i++)
            {
                normalizedArray.add(avg.get(i) * sf);
            }
            String norm = "";
            for(int i = 0; i<size; i++)
            {
                norm = norm + "   " +normalizedArray.get(i);
                disp.setText("[" + norm + "  ]");
            }
            sf1.setText(""+sf);
        }
        if (v.equals(clear))
        {
            Intent it = new Intent(this, MainActivity.class);
            startActivity(it);
        }
    }
}