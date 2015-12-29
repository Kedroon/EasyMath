package com.sample.kedroon.easymath;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BaseAndHeight extends AppCompatActivity {

    private float result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_and_height);
        Button button = (Button) findViewById(R.id.button01);
        final EditText eBase = (EditText) findViewById(R.id.base);
        final EditText eHeight = (EditText) findViewById(R.id.height);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(eBase.getText()) && TextUtils.isEmpty(eHeight.getText())) {
                    Toast.makeText(getApplicationContext(), getText(R.string.error_heightbase), Toast.LENGTH_LONG).show();
                    return;
                } else if (TextUtils.isEmpty(eBase.getText())) {
                    Toast.makeText(getApplicationContext(), getText(R.string.error_base), Toast.LENGTH_LONG).show();
                    return;
                } else if (TextUtils.isEmpty(eHeight.getText())) {
                    Toast.makeText(getApplicationContext(), getText(R.string.error_height), Toast.LENGTH_LONG).show();
                    return;
                }
                float base = Float.valueOf(eBase.getText().toString());
                float height = Float.valueOf(eHeight.getText().toString());
                result = (base * height) / 2;
                TextView textView = (TextView) findViewById(R.id.result_01);
                String resultString = Float.toString(result);
                textView.setText(getText(R.string.area_result) + resultString);
            }

        });

    }

    @Override
     public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.legend) {

        }


        return super.onOptionsItemSelected(item);
    }

}


