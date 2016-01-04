package com.sample.kedroon.easymath;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CircleOperationsActivity extends AppCompatActivity {

    ListView list;


    Integer[] imageId = {
            R.drawable.circulomenu,
            R.drawable.circulomenu,


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_operations);
        final String[] circleOperations = {
                getString(R.string.diameter_area_circle),
                getString(R.string.sector_circle),

        };
        ListOfOperations adapter = new ListOfOperations(this, circleOperations, imageId);
        list = (ListView) findViewById(R.id.circle_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(getApplicationContext(),CircleDiameterArea.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(CircleOperationsActivity.this, "You Clicked at " + circleOperations[+position], Toast.LENGTH_SHORT).show();
                }



            }
        });

    }

}