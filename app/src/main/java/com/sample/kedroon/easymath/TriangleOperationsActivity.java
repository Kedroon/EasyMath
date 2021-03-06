package com.sample.kedroon.easymath;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class TriangleOperationsActivity extends AppCompatActivity {

    ListView list;


    Integer[] imageId = {
            R.drawable.trianglemenu,
            R.drawable.trianglemenu,
            R.drawable.trianglemenu,
            R.drawable.trianglemenu,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangle_operations);
        final String[] triangleOperations = {
                getString(R.string.base_height),
                getString(R.string.herons_formula),
                getString(R.string.angle),
                getString(R.string.squi),

        };
        ListOfOperations adapter = new ListOfOperations(this, triangleOperations, imageId);
        list = (ListView) findViewById(R.id.triangle_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(),BaseAndHeight.class);
                    startActivity(intent);
                }
                else if(position == 1){
                    Intent intent = new Intent(getApplicationContext(),ThreeSides.class);
                    startActivity(intent);
                }
                else if(position == 2){
                    Intent intent = new Intent(getApplicationContext(),TwoSidesAndAngle.class);
                    startActivity(intent);
                }

                else if(position == 3){
                    Intent intent = new Intent(getApplicationContext(),EquilateralTriangle.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(TriangleOperationsActivity.this, "You Clicked at " + triangleOperations[+position], Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
