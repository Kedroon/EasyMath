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


public class RectangleActivity extends AppCompatActivity{

    private float result;
    PopUpCustom popupWindow;
    ArrayList<String> legends;
    boolean openedPopup=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);
        initPopUpCustom();
        Button button = (Button) findViewById(R.id.button01);
        final EditText eLength = (EditText) findViewById(R.id.length);
        final EditText eWidth = (EditText) findViewById(R.id.width);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String error="";
                boolean isError = false;
                if (TextUtils.isEmpty(eLength.getText())) {
                    error += getText(R.string.length) + ", ";
                    isError = true;
                }
                if (TextUtils.isEmpty(eWidth.getText())) {
                    error += getText(R.string.width) + ", ";
                    isError = true;
                }

                if(isError){
                    error+=getText(R.string.missing);
                    Toast.makeText(getApplicationContext(),error,Toast.LENGTH_LONG).show();
                    return;
                }
                float length = Float.valueOf(eLength.getText().toString());
                float width = Float.valueOf(eWidth.getText().toString());
                result = length*width;
                TextView textView = (TextView) findViewById(R.id.result_01);
                String resultString = Float.toString(result);
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
                popupWindow.openPopUp(findViewById(R.id.rectangle));
                popupWindow.popupMessage.dismiss();
                openedPopup=true;
            }
            popupWindow.openPopUp(findViewById(R.id.rectangle));


        }


        return super.onOptionsItemSelected(item);
    }


    private void initStringLegends(){

        legends.add(getText(R.string.area_legend).toString());
        legends.add(getText(R.string.length_legend).toString());
        legends.add(getText(R.string.width_legend).toString());



    }

    private void initPopUpCustom(){
        legends = new ArrayList<>();
        initStringLegends();
        popupWindow = new PopUpCustom(this,legends);
        popupWindow.init();
        popupWindow.popupInit();

    }






}


