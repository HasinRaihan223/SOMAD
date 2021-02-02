package com.example.randomnumbergen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {

    int min;
    int max;
    Button button;
    TextView randomNumber;
    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Random randomNum = new Random();

        button = (Button)findViewById(R.id.button);
        final TextView randomNumber = (TextView)findViewById(R.id.randomNumber);
        final TextView error = (TextView)findViewById(R.id.error);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText minimum = (EditText)findViewById(R.id.minimum);
                EditText maximum = (EditText)findViewById(R.id.maximum);
                String minS = minimum.getText().toString();
                String maxS = maximum.getText().toString();
                if(isEmpty(minS) || isEmpty(maxS)){
                    error.setText("Please enter a number in both fields!");
                    randomNumber.setText("");
                }
                else {
                    min = Integer.parseInt(minS);
                    max = Integer.parseInt(maxS);
                    if (min > max) {
                        error.setText("Please make sure the minimum value is lower than the maximum value!");
                        randomNumber.setText("");
                        } else {
                        error.setText("");
                        randomNumber.setText(String.valueOf(randomNum.nextInt(max - min + 1) + min));
                    }
                }
            }
        });
    }
}