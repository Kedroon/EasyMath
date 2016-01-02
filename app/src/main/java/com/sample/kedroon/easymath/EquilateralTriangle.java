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

public class EquilateralTriangle extends AppCompatActivity {

    private double height;
    private double area;
    PopUpCustom popupWindow;
    ArrayList<String> legends;
    boolean openedPopup=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equilateral_triangle);
        initPopUpCustom();
        Button button = (Button) findViewById(R.id.button01);
        final EditText eSide1 = (EditText) findViewById(R.id.side1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = "";
                boolean isError = false;
                if (TextUtils.isEmpty(eSide1.getText())) {
                    error += getText(R.string.side_of_equi) + ", ";
                    isError = true;

                }

                if (isError) {
                    error += getText(R.string.missing);
                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
                    return;
                }
                float side01 = Float.valueOf(eSide1.getText().toString());
                height = (side01*Math.sqrt(3))/2;
                area = (Math.pow(side01,2)*Math.sqrt(3))/4;
                float i = (float) height;
                float j = (float) area;
                TextView textView = (TextView) findViewById(R.id.result_01);
                TextView textView1 = (TextView) findViewById(R.id.result_02);
                String heightString = Float.toString(i);
                String areaString = Float.toString(j);
                textView.setText(getText(R.string.height_result) + heightString);
                textView1.setText(getText(R.string.area_result) + areaString);
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
            if(!openedPopup) {
                popupWindow.openPopUp(findViewById(R.id.equilateral_triangle));
                popupWindow.popupMessage.dismiss();
                openedPopup=true;
            }

            popupWindow.openPopUp(findViewById(R.id.equilateral_triangle));
        }


        return super.onOptionsItemSelected(item);
    }


    private void initStringLegends(){

        legends.add(getText(R.string.height_legend).toString());
        legends.add(getText(R.string.side_legend).toString());
        legends.add(getText(R.string.area_legend).toString());


    }

    private void initPopUpCustom(){
        legends = new ArrayList<>();
        initStringLegends();
        popupWindow = new PopUpCustom(this,legends);
        popupWindow.init();
        popupWindow.popupInit();

    }

}


