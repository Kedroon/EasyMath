package com.sample.kedroon.easymath;


import android.widget.LinearLayout;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by migue on 12/29/2015.
 */
public class PopUpCustom {

    LinearLayout layoutOfPopup;
    PopupWindow popupMessage;
    TextView popupText;
    Context contextCustom;
    Button button;
    ArrayList<String> legends;
    String legendView = "";


    PopUpCustom(Context context, ArrayList<String> legendsCons) {
        contextCustom = context;
        legends = legendsCons;
    }


    public void init() {
        button = new Button(contextCustom);
        popupText = new TextView(contextCustom);
        layoutOfPopup = new LinearLayout(contextCustom);
        for (int i = 0; i < legends.size(); i++) {
            if (i == legends.size() - 1) {
                legendView += legends.get(i);
            } else {
                legendView += legends.get(i) + "\n";
            }
        }
        popupText.setText(legendView);
        popupText.setGravity(Gravity.CENTER);
        popupText.setPadding(30, 5, 30, 0);
        popupText.setTextColor(Color.WHITE);
        popupText.setTextSize(18);
        button.setText(R.string.close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMessage.dismiss();
            }
        });

        layoutOfPopup.setOrientation(LinearLayout.VERTICAL);
        layoutOfPopup.addView(popupText);
        layoutOfPopup.setBackgroundColor(ContextCompat.getColor(contextCustom, R.color.colorPrimaryDark));
        layoutOfPopup.addView(button);
    }

    public void popupInit() {


        popupMessage = new PopupWindow(layoutOfPopup, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupMessage.setContentView(layoutOfPopup);
        popupMessage.setAnimationStyle(R.style.CustomAnimation);


    }


    public void openPopUp(View view) {


        popupMessage.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        popupMessage.setFocusable(true);
    }
}
