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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreeSides extends AppCompatActivity {

    private double result;
    PopUpCustom popupWindow;
    ArrayList<String> legends;
    boolean openedPopup=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_sides);
        initPopUpCustom();
        Button button = (Button) findViewById(R.id.button01);
        final EditText eSide1 = (EditText) findViewById(R.id.side1);
        final EditText eSide2 = (EditText) findViewById(R.id.side2);
        final EditText eSide3 = (EditText) findViewById(R.id.side3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error="";
                boolean isError = false;
                if (TextUtils.isEmpty(eSide1.getText())) {
                    error+=getText(R.string.side01)+", ";
                    isError=true;

                } if (TextUtils.isEmpty(eSide2.getText())) {
                    error+=getText(R.string.side02)+", ";
                    isError=true;

                } if (TextUtils.isEmpty(eSide3.getText())) {
                    error+=getText(R.string.side03)+", ";
                    isError=true;

                }
                if(isError){
                    error+=getText(R.string.missing);
                    Toast.makeText(getApplicationContext(),error,Toast.LENGTH_LONG).show();
                    return;
                }
                float side01 = Float.valueOf(eSide1.getText().toString());
                float side02 = Float.valueOf(eSide2.getText().toString());
                float side03 = Float.valueOf(eSide3.getText().toString());
                float p = (side01+side02+side03)/2;
                result = Math.sqrt(p*(p-side01)*(p-side02)*(p-side03));
                float i = (float)result;
                TextView textView = (TextView) findViewById(R.id.result_01);
                String resultString = Float.toString(i);
                textView.setText(getText(R.string.area_result) + resultString);
            }

        });
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("0390E689DC828F36AC92A8F50F8934F9").build();
        mAdView.loadAd(adRequest);

        AdListener googleAdListener = new AdListener()
        {

            @Override
            public void onAdLoaded()
            {
                super.onAdLoaded();
                try
                {
                    findViewById(R.id.adView).setVisibility(View.VISIBLE);
                }
                catch (Exception e)
                {
                    Logger logger = Logger.getAnonymousLogger();
                    logger.log(Level.SEVERE, "an exception was thrown", e);
                }
            }
        };

        mAdView.setAdListener(googleAdListener);

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
                popupWindow.openPopUp(findViewById(R.id.three_sides));
                popupWindow.popupMessage.dismiss();
                openedPopup=true;
            }
            popupWindow.openPopUp(findViewById(R.id.three_sides));


        }


        return super.onOptionsItemSelected(item);
    }


    private void initStringLegends(){
        legends.add(getText(R.string.semi_perimeter_legend).toString());
        legends.add(getText(R.string.side1_legend).toString());
        legends.add(getText(R.string.side2_legend).toString());
        legends.add(getText(R.string.side3_legend).toString());
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


