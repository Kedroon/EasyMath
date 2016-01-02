package com.sample.kedroon.easymath;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TwoSidesAndAngle extends AppCompatActivity {

    private double result;
    PopUpCustom popupWindow;
    ArrayList<String> legends;
    boolean openedPopup=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_sides_and_angle);
        initPopUpCustom();
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
                textView.setText(getText(R.string.area_result) + resultString);
            }

        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();


        if (id == R.id.legend) {
            if(!openedPopup) {
                popupWindow.openPopUp(findViewById(R.id.two_sides_and_angle));
                popupWindow.popupMessage.dismiss();
                openedPopup=true;
            }
            popupWindow.openPopUp(findViewById(R.id.two_sides_and_angle));


        }


        return super.onOptionsItemSelected(item);
    }


    private void initStringLegends(){

        legends.add(getText(R.string.area_legend).toString());
        legends.add(getText(R.string.side1_legend).toString());
        legends.add(getText(R.string.side2_legend).toString());
        legends.add(getText(R.string.alpha_legend).toString());

    }

    private void initPopUpCustom(){
        legends = new ArrayList<>();
        initStringLegends();
        popupWindow = new PopUpCustom(this,legends);
        popupWindow.init();
        popupWindow.popupInit();

    }


}


