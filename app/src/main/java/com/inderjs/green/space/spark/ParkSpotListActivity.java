package com.inderjs.green.space.spark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ParkSpotListActivity extends AppCompatActivity {

    ListView mList;

    private ArrayList newArrayList = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_spot_list);

        mList = (ListView)findViewById(R.id.spotList);

        newArrayList = GetNearbyPlacesData.getArrayList();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, newArrayList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the current item from ListView
                View view = super.getView(position,convertView,parent);

                // Get the Layout Parameters for ListView Current Item View
                ViewGroup.LayoutParams params = view.getLayoutParams();

                // Set the height of the Item View
                params.height = 250;
                view.setLayoutParams(params);

                return view;
            }
        };

        // DataBind ListView with items from ArrayAdapter
        mList.setAdapter(arrayAdapter);


        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = mList.getItemAtPosition(position);
                String str = (String) o; //As you are using Default String Adapter

                Intent qrIntent = new Intent(ParkSpotListActivity.this, QRActivity.class);
                qrIntent.putExtra("STRING",str);
                startActivity(qrIntent);
            }
        });


    }
}
