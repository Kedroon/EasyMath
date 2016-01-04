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

public class CircleDiameterArea extends AppCompatActivity {

    private double diameter;
    private double area;
    PopUpCustom popupWindow;
    ArrayList<String> legends;
    boolean openedPopup=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_diameter_area);
        initPopUpCustom();
        Button button = (Button) findViewById(R.id.button01);
        final EditText eRadius = (EditText) findViewById(R.id.radius);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = "";
                boolean isError = false;
                if (TextUtils.isEmpty(eRadius.getText())) {
                    error += getText(R.string.radius) + ", ";
                    isError = true;

                }

                if (isError) {
                    error += getText(R.string.missing);
                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
                    return;
                }
                float radius = Float.valueOf(eRadius.getText().toString());
                diameter = 2*Math.PI*radius;
                area = Math.PI * Math.pow(radius,2);
                float i = (float) diameter;
                float j = (float) area;
                TextView textView = (TextView) findViewById(R.id.result_01);
                TextView textView1 = (TextView) findViewById(R.id.result_02);
                String diameterString = Float.toString(i);
                String areaString = Float.toString(j);
                textView.setText(getText(R.string.diameter_result) + diameterString);
                textView1.setText(getText(R.string.area_result) + areaString);
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
                popupWindow.openPopUp(findViewById(R.id.diameter_area_circle));
                popupWindow.popupMessage.dismiss();
                openedPopup=true;
            }

            popupWindow.openPopUp(findViewById(R.id.diameter_area_circle));
        }


        return super.onOptionsItemSelected(item);
    }


    private void initStringLegends(){

        legends.add(getText(R.string.diameter_legend).toString());
        legends.add(getText(R.string.radius_legend).toString());
        legends.add(getText(R.string.pi_legend).toString());
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


