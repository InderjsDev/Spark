package com.inderjs.green.space.spark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {

    private ImageView mLeft, mRight;
    private TextView mParkListTv;
    private Button mConfirmBtn;

    private ArrayList newArrayList = null;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);


        mConfirmBtn = (Button)findViewById(R.id.confirmBtn);
        mLeft = (ImageView)findViewById(R.id.left);
        mRight = (ImageView)findViewById(R.id.right);
        mParkListTv = (TextView)findViewById(R.id.mParkSpotTv);


        newArrayList = GetNearbyPlacesData.getArrayList();



        if(!(newArrayList ==null)) {


            mParkListTv.setText(newArrayList.get(i).toString());


        }

        mLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i = i-1;

                mParkListTv.setText(newArrayList.get(i).toString());
            }
        });


        mRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i = i+1;

                mParkListTv.setText(newArrayList.get(i).toString());
            }
        });


        mConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent qrIntent = new Intent(ScheduleActivity.this, QRActivity.class);
                qrIntent.putExtra("STRING",newArrayList.get(i).toString());
                startActivity(qrIntent);

            }
        });

    }
}
