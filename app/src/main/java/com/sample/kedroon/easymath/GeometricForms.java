package com.sample.kedroon.easymath;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class GeometricForms extends AppCompatActivity {

    ListView list;


    Integer[] imageId = {
            R.drawable.skull,
            R.drawable.skull,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geometric_forms);
        final String[] geometricOperations = {
                getString(R.string.triangle),
                getString(R.string.square),

        };
        ListOfOperations adapter = new ListOfOperations(this,geometricOperations,imageId);
        list =(ListView)findViewById(R.id.geometric_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(getApplicationContext(),TriangleOperationsActivity.class);
                    startActivity(intent);

                }
                else {
                Toast.makeText(GeometricForms.this, "You Clicked at " + geometricOperations[+position], Toast.LENGTH_SHORT).show();
            }}
        });

    }

    }


