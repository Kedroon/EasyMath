package com.sample.kedroon.easymath;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BaseAndHeight extends AppCompatActivity {

    private float result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_and_height);
        Button button = (Button)findViewById(R.id.button01);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText eBase = (EditText) findViewById(R.id.base);
                EditText eHeight = (EditText) findViewById(R.id.height);
                float base = Float.valueOf(eBase.getText().toString());
                float height = Float.valueOf(eHeight.getText().toString());
                result = (base*height)/2;
                TextView textView = (TextView)findViewById(R.id.result_01);
                String resultString=Float.toString(result);
                textView.setText(getText(R.string.result)+resultString);

            }
        });

    }



}
