package com.sample.kedroon.easymath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class GeometricForms extends AppCompatActivity {

    ListView list;


    Integer[] imageId = {
            R.drawable.trianglemenu,
            R.drawable.quadradomenu,
            R.drawable.rectanglemenu,
            R.drawable.circulomenu,
            R.drawable.losango,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geometric_forms);
        final String[] geometricOperations = {
                getString(R.string.triangle),
                getString(R.string.square),
                getString(R.string.rectangle),
                getString(R.string.circle),
                getString(R.string.diamond),

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
                else if(position==1){
                    Intent intent = new Intent(getApplicationContext(),SquareActivity.class);
                    startActivity(intent);
                }

                else if(position==2){
                    Intent intent = new Intent(getApplicationContext(),RectangleActivity.class);
                    startActivity(intent);
                }
                else if(position==3){
                    Intent intent = new Intent(getApplicationContext(),CircleOperationsActivity.class);
                    startActivity(intent);
                }

                else if(position==4){
                    Intent intent = new Intent(getApplicationContext(),DiamondActivity.class);
                    startActivity(intent);
                }
                else {
                Toast.makeText(GeometricForms.this, "You Clicked at " + geometricOperations[+position], Toast.LENGTH_SHORT).show();
            }}
        });

    }

    }


