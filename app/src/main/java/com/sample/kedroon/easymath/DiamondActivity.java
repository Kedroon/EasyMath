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

public class DiamondActivity extends AppCompatActivity {


    private float area;
    PopUpCustom popupWindow;
    ArrayList<String> legends;
    boolean openedPopup=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond);
        initPopUpCustom();
        Button button = (Button) findViewById(R.id.button01);
        final EditText eDiagonal1 = (EditText) findViewById(R.id.diagonal_minor);
        final EditText eDiagonal2 = (EditText) findViewById(R.id.diagonal_major);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = "";
                boolean isError = false;
                if (TextUtils.isEmpty(eDiagonal1.getText())) {
                    error += getText(R.string.diagonal_1) + ", ";
                    isError = true;

                }
                if (TextUtils.isEmpty(eDiagonal2.getText())) {
                    error += getText(R.string.diagonal_2) + ", ";
                    isError = true;

                }
                if (isError) {
                    error += getText(R.string.missing);
                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
                    return;
                }
                float diagonal01 = Float.valueOf(eDiagonal1.getText().toString());
                float diagonal02 = Float.valueOf(eDiagonal2.getText().toString());

                area = (diagonal01*diagonal02)/2;
                TextView textView = (TextView) findViewById(R.id.result_01);
                String areaString = Float.toString(area);
                textView.setText(getText(R.string.area_result) + areaString);
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
                popupWindow.openPopUp(findViewById(R.id.diamond));
                popupWindow.popupMessage.dismiss();
                openedPopup=true;
            }

            popupWindow.openPopUp(findViewById(R.id.diamond));
        }


        return super.onOptionsItemSelected(item);
    }


    private void initStringLegends(){

        legends.add(getText(R.string.diagonal1_legend).toString());
        legends.add(getText(R.string.diagonal2_legend).toString());
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


