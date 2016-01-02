package com.sample.kedroon.easymath;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;


    Integer[] imageId = {
            R.drawable.geometricforms,
            R.drawable.skull,
            R.drawable.skull,
            R.drawable.skull,
            R.drawable.skull,
            R.drawable.skull,
            R.drawable.skull,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] mainOperations = {
                getString(R.string.geo_forms),
                getString(R.string.place_holder),
                getString(R.string.place_holder),
                getString(R.string.place_holder),
                getString(R.string.place_holder),
                getString(R.string.place_holder),
                getString(R.string.place_holder),
        };
        ListOfOperations adapter = new ListOfOperations(this,mainOperations,imageId);
        list =(ListView)findViewById(R.id.operations_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(getApplicationContext(),GeometricForms.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(MainActivity.this, "You Clicked at " + mainOperations[+position], Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
