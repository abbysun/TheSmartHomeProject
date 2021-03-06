package com.sun.abby.cst2335_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * This class contains a listview, which displays all the kitchen appliances.
 * Clicking the appliance will take users to the control activity for that appliance.
 * This java file contains behavioural implementation for the views in activity_kitchen.xml
 * @author Abby
 */
public class KitchenActivity extends AppCompatActivity {
    private String [] appliance = {"Microwave", "Fridge", "Smart Lighting"};
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        //find ListView and populate it
        ArrayAdapter adapter = new ArrayAdapter<String> (this, R.layout.kitchen_listview_layout, appliance);
        listView = (ListView) findViewById(R.id.kitchen_list_view);
        listView.setAdapter(adapter);

        //set click listerner function to ListView items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent microwaveIntent = new Intent(getApplicationContext(), MicrowaveActivity.class);
                        startActivity(microwaveIntent);
                        break;

                    case 1:
                        Intent fridgeIntent = new Intent(getApplicationContext(), FridgeActivity.class);
                        startActivity(fridgeIntent);
                        break;

                    case 2:
                        Intent lightIntent = new Intent(getApplicationContext(), KitchenLightActivity.class);
                        startActivity(lightIntent);
                        break;
                }
            }
        });
    }
}
