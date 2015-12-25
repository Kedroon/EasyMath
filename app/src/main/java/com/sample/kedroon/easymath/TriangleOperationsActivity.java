package com.sample.kedroon.easymath;

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
            R.drawable.skull,
            R.drawable.skull,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangle_operations);
        final String[] triangleOperations = {
                "angulo",
                "lados",

        };
        ListOfOperations adapter = new ListOfOperations(this,triangleOperations,imageId);
        list =(ListView)findViewById(R.id.triangle_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TriangleOperationsActivity.this, "You Clicked at " + triangleOperations[+position], Toast.LENGTH_SHORT).show();
            }
        });

    }

}
