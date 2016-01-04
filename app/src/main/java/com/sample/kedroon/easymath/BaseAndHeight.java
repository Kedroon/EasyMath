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


public class BaseAndHeight extends AppCompatActivity{

    private float result;
    PopUpCustom popupWindow;
    ArrayList<String> legends;
    boolean openedPopup=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_and_height);
        initPopUpCustom();
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
                popupWindow.openPopUp(findViewById(R.id.base_and_height));
                popupWindow.popupMessage.dismiss();
                openedPopup=true;
            }
            popupWindow.openPopUp(findViewById(R.id.base_and_height));


        }


        return super.onOptionsItemSelected(item);
    }


    private void initStringLegends(){

        legends.add(getText(R.string.area_legend).toString());
        legends.add(getText(R.string.base_legend).toString());
        legends.add(getText(R.string.height_legend).toString());


    }

    private void initPopUpCustom(){
        legends = new ArrayList<>();
        initStringLegends();
        popupWindow = new PopUpCustom(this,legends);
        popupWindow.init();
        popupWindow.popupInit();

    }






}


