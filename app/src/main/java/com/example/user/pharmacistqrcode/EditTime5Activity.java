package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditTime5Activity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_time5);
        String txt = getIntent().getStringExtra("txt");
        TextView txt0 = (TextView) findViewById(R.id.txtData1);
        TextView txt1 = (TextView) findViewById(R.id.txtData2);
        String a []= txt.split(";");
        txt0.setText("    ชื่อยา: " + a[0] + "  ช่วงเวลารับประทาน : " + a[1]);
        txt1.setText("    รับประทาน : " + a[2] + "  จำนวน : " + a[3]);

    }



    public void saves(View view){
        String txt = getIntent().getStringExtra("txt");
        String a []= txt.split(";");
        int icon = R.drawable.aaxc;
        String menuItem = "  ชื่อยา: "+ a[0]+"  ช่วงเวลารับประทาน : "+ a[1]+"   จำนวน : "+ a[3];
        String allTime = "    รับประทาน : ";

        Uri u =Uri.parse("content://qrcodeHour");
        ContentValues cv = new ContentValues();
        cv.put("icon", icon);
        cv.put("productname", menuItem.toString());
        cv.put("timeDate", allTime);
        Uri nari = getContentResolver().insert(u, cv);

        Intent intent = new Intent(getApplicationContext(),QRCodeMenuActivity.class);
        startActivity(intent);
        finish();

    }


}
