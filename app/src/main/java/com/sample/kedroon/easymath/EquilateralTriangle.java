package com.sample.kedroon.easymath;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EquilateralTriangle extends AppCompatActivity {

    private double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equilateral_triangle);
        Button button = (Button) findViewById(R.id.button01);
        final EditText eSide1 = (EditText) findViewById(R.id.side1);
        final EditText eSide2 = (EditText) findViewById(R.id.side2);
        final EditText eAngle = (EditText) findViewById(R.id.angle);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = "";
                boolean isError = false;
                if (TextUtils.isEmpty(eSide1.getText())) {
                    error += getText(R.string.side01) + ", ";
                    isError = true;

                }
                if (TextUtils.isEmpty(eSide2.getText())) {
                    error += getText(R.string.side02) + ", ";
                    isError = true;

                }
                if (TextUtils.isEmpty(eAngle.getText())) {
                    error += getText(R.string.angleactivity) + ", ";
                    isError = true;

                }
                if (isError) {
                    error += getText(R.string.missing);
                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
                    return;
                }
                float side01 = Float.valueOf(eSide1.getText().toString());
                float side02 = Float.valueOf(eSide2.getText().toString());
                float angle = Float.valueOf(eAngle.getText().toString());
                result = (side01*side02*Math.sin(Math.toRadians(angle)))/2;
                float i = (float) result;
                TextView textView = (TextView) findViewById(R.id.result_01);
                String resultString = Float.toString(i);
                textView.setText(getText(R.string.result) + resultString);
            }

        });

    }

}


