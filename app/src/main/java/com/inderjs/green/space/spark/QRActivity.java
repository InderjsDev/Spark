package com.inderjs.green.space.spark;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QRActivity extends AppCompatActivity {


    ImageView mQr;
    TextView mSpotInfo;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);


        mAuth = FirebaseAuth.getInstance();

        mEmail = mAuth.getCurrentUser().getEmail();

        mQr = (ImageView)findViewById(R.id.qr);

        mSpotInfo = (TextView)findViewById(R.id.spotTv);

        String s = getIntent().getStringExtra("STRING");

        mSpotInfo.setText(s);


        QRGEncoder qrgEncoder = new QRGEncoder(mEmail+" "+s, null, QRGContents.Type.TEXT, 200);
        try {
            // Getting QR-Code as Bitmap
            Bitmap bitmap = qrgEncoder.encodeAsBitmap();
            // Setting Bitmap to ImageView
            mQr.setImageBitmap(bitmap);
        } catch (WriterException e) {

        }


    }
}
