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
        txt1.setText("  ช่วงเวลา : "+ a[1]);
        txt2.setText("  รับประทาน : "+ a[2]);
        txt3.setText("  จำนวน : "+ a[3]);


        if (a[1].equals("Morning   ") ){
            txt1.setText("  ช่วงเวลา : เช้า");
        }else if (a[1].equals(" Lunch  ")){
            txt1.setText("  ช่วงเวลา : เที่ยง");
        }else if ( a[1].equals("   Bed")){
            txt1.setText("  ช่วงเวลา : ก่อนนอน");
        }else if (a[1].equals("  Dinner ")) {
            txt1.setText("  ช่วงเวลา : เย็น");
        }else if (a[1].equals("Morning Lunch Dinner Bed")) {
            txt1.setText("  ช่วงเวลา : เช้า เที่ยง เย็น ก่อนนอน ");
        }else if (a[1].equals("Morning Lunch  ")){
            txt1.setText("  ช่วงเวลา : เช้า เที่ยง");
        }else if (a[1].equals("Morning  Dinner ")){
            txt1.setText("  ช่วงเวลา : เช้า เย็น");
        }else if (a[1].equals("Morning   Bed")){
            txt1.setText("  ช่วงเวลา : เช้า ก่อนนอน");
        }else if (a[1].equals(" Lunch Dinner " )){
            txt1.setText("  ช่วงเวลา : เที่ยง เย็น");
        }else if (a[1].equals(" Lunch  Bed")){
            txt1.setText("  ช่วงเวลา : เที่ยง ก่อนนอน");
        }else if (a[1].equals("  Dinner Bed")){
            txt1.setText("  ช่วงเวลา : เย็น ก่อนนอน");
        }else if (a[1].equals("Morning Lunch Dinner ")){
            txt1.setText("  ช่วงเวลา : เช้า เที่ยง เย็น");
        }else if (a[1].equals("Morning Lunch  Bed")){
            txt1.setText("  ช่วงเวลา : เช้า เที่ยง ก่อนนอน");
        }else if (a[1].equals(" Lunch Dinner Bed")) {
            txt1.setText("  ช่วงเวลา : เที่ยง เย็น ก่อนนอน");
        }else{
            txt1.setText("  ช่วงเวลา :"+ a[1]);
        }


    }
    public void btnBack(View v){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);;
        startActivity(intent);
        finish();

    }
    public void Next(View v){
        String txt = getIntent().getStringExtra("txt");
        String a []= txt.split(";");
        if (a[1].equals("Morning   ") || a[1].equals(" Lunch  ") || a[1].equals("  Dinner ") || a[1].equals("   Bed")){
            Intent intent = new Intent(getApplicationContext(),EditTime1Activity.class);
            intent.putExtra("txt",txt.toString());
            startActivity(intent);
            finish();
        }else if (a[1].equals("Morning Lunch  ") || a[1].equals("Morning  Dinner ") || a[1].equals("Morning   Bed") || a[1].equals(" Lunch Dinner " ) ||
                a[1].equals(" Lunch  Bed") || a[1].equals("  Dinner Bed")){
            Intent intent = new Intent(getApplicationContext(),EditTime2Activity.class);
            intent.putExtra("txt",txt.toString());
            startActivity(intent);
            finish();

        }else if (a[1].equals("Morning Lunch Dinner ") || a[1].equals("Morning Lunch  Bed") || a[1].equals(" Lunch Dinner Bed")) {
            Intent intent = new Intent(getApplicationContext(),EditTime3Activity.class);
            intent.putExtra("txt",txt.toString());
            startActivity(intent);
            finish();

        }else if (a[1].equals("Morning Lunch Dinner Bed")) {
            Intent intent = new Intent(getApplicationContext(),EditTime4Activity.class);
            intent.putExtra("txt",txt.toString());
            startActivity(intent);
            finish();
        }
        else {
            Intent intent = new Intent(getApplicationContext(),EditTime5Activity.class);
            intent.putExtra("txt",txt.toString());
            startActivity(intent);
            finish();
        }

    }



}
