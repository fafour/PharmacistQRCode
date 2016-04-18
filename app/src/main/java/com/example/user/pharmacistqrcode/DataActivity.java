package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DataActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        String txt = getIntent().getStringExtra("txt");
        TextView txt0 = (TextView) findViewById(R.id.txt0);
        TextView txt1 = (TextView) findViewById(R.id.txt1);
        TextView txt2 = (TextView) findViewById(R.id.txt2);
        TextView txt3 = (TextView) findViewById(R.id.txt3);

        String a []= txt.split(";");
        txt0.setText("  ชื่อยา: "+ a[0]);
        txt1.setText("  ช่วงเวลารับประทาน : "+ a[1]);
        txt2.setText("  รับประทาน : "+ a[2]);
        txt3.setText("  จำนวน : "+ a[3]);

    }
    public void btnBack(View v){
        finish();

    }
    public void Next(View v){
        String txt = getIntent().getStringExtra("txt");
        String a []= txt.split(";");
        if (a[1].equals("เช้า") || a[1].equals("เที่ยง") || a[1].equals("เย็น") || a[1].equals("ก่อนนอน")){
            Intent intent = new Intent(getApplicationContext(),EditTime1Activity.class);
            intent.putExtra("txt",txt.toString());
            startActivity(intent);
            finish();
        }else if (a[1].equals("เช้า-เที่ยง") || a[1].equals("เช้า-เย็น") || a[1].equals("เช้า-ก่อนนอน") || a[1].equals("เที่ยง-เย็น") ||
                a[1].equals("เที่ยง-ก่อนนอน") || a[1].equals("เย็น-ก่อนนอน")){
            Intent intent = new Intent(getApplicationContext(),EditTime2Activity.class);;
            startActivity(intent);
            finish();

        }else if (a[1].equals("เช้า-เที่ยง-เย็น") || a[1].equals("เช้า-เที่ยง-ก่อนนอน") || a[1].equals("เที่ยง-เย็น-ก่อนนอน")) {
            Intent intent = new Intent(getApplicationContext(),EditTime3Activity.class);
            intent.putExtra("txt",txt.toString());
            startActivity(intent);
            finish();

        }else if (a[1].equals("เช้า-เที่ยง-เย็น-ก่อนนอน")) {
            Intent intent = new Intent(getApplicationContext(),EditTime4Activity.class);;
            startActivity(intent);
            finish();
        }else {
            Intent intent = new Intent(getApplicationContext(),EditTime5Activity.class);;
            startActivity(intent);
            finish();
        }

    }



}
