package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EditTime1Activity extends Activity implements AdapterView.OnItemSelectedListener {
    private int pHour1;
    private int pMinute1;
    static final int TIME_DIALOG_ID = 0;
    TextView timeEditQRcode1;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_time1);
        String txt = getIntent().getStringExtra("txt");
        TextView txt0 = (TextView) findViewById(R.id.txtData1);
        TextView txt1 = (TextView) findViewById(R.id.txtData2);
        String a []= txt.split(";");
        txt0.setText("    ชื่อยา: "+ a[0]+"  ช่วงเวลารับประทาน : "+ a[1]);
        txt1.setText("    รับประทาน : "+ a[2]+"  จำนวน : "+ a[3]);


        TextView atTime = (TextView) findViewById(R.id.atTime);
        timeEditQRcode1 = (TextView) findViewById(R.id.timeEditQRcode1);


        if (SettingSystemActivity.TIME_1 == null && a[1].equals("เช้า")  ) {
            timeEditQRcode1.setText("09.30");
        }else if (SettingSystemActivity.TIME_1 != null && a[1].equals("เช้า")  ) {
            timeEditQRcode1.setText(SettingSystemActivity.TIME_1);
        }else if (SettingSystemActivity.TIME_2 == null && a[1].equals("เที่ยง")  ) {
            timeEditQRcode1.setText("13.30");
        }else if (SettingSystemActivity.TIME_2 != null && a[1].equals("เที่ยง")  ) {
            timeEditQRcode1.setText(SettingSystemActivity.TIME_2);
        }else if (SettingSystemActivity.TIME_3 == null && a[1].equals("เย็น")  ) {
            timeEditQRcode1.setText("18.30");
        }else if (SettingSystemActivity.TIME_3 != null && a[1].equals("เย็น")  ) {
            timeEditQRcode1.setText(SettingSystemActivity.TIME_3);
        }else if (SettingSystemActivity.TIME_4 == null && a[1].equals("ก่อนนอน")  ) {
            timeEditQRcode1.setText("22.30");
        }else if (SettingSystemActivity.TIME_4 != null && a[1].equals("ก่อนนอน")  ) {
            timeEditQRcode1.setText(SettingSystemActivity.TIME_4);
        }

        if (a[1].equals("เช้า")){
            atTime.setText("ตอนเช้า");
        }else if (a[1].equals("เที่ยง")){
            atTime.setText("ตอนเที่ยง");
        }else if (a[1].equals("ก่อนนอน")){
            atTime.setText("ก่อนนอน");
        }else if (a[1].equals("เย็น")){
            atTime.setText("ตอนเย็น");
        }

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List categories = new ArrayList();
        categories.add("ไม่มีเสียง");
        categories.add("เสียง1");
        categories.add("เสียง2");
        categories.add("เสียง3");
        categories.add("เสียง4");
        categories.add("เสียง5");
        categories.add("เสียง6");
        categories.add("เสียง7");

        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                if (position==0){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }

                }
                else if (position==1){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.aaa);
                    mediaPlayer.start();

                }
                else if (position==2){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.ddd);
                    mediaPlayer.start();

                }
                else if (position==3){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.fff);
                    mediaPlayer.start();

                }
                else if (position==4){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.ggg);
                    mediaPlayer.start();

                }
                else if (position==5){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.sss);
                    mediaPlayer.start();

                }
                else if (position==6){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.vvv);
                    mediaPlayer.start();

                }
                else if (position==7){
                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(getBaseContext() , R.raw.xxx);
                    mediaPlayer.start();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });



    }
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour1 = hourOfDay;
                    pMinute1 = minute;

                    updateDisplay();
                    displayToast();
                }
            };
    private void updateDisplay() {
        timeEditQRcode1.setText(
                new StringBuilder()
                        .append(pad(pHour1)).append(":")
                        .append(pad(pMinute1)));

    }
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this,
                        mTimeSetListener, pHour1, pMinute1, false);

        }
        return null;
    }
    private void displayToast() {
        Toast.makeText(this, new StringBuilder().append("Update Time ").append(timeEditQRcode1.getText()), Toast.LENGTH_SHORT).show();

    }
    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    public void time1(View view) {
        timeEditQRcode1 = (TextView) findViewById(R.id.timeEditQRcode1);
        showDialog(TIME_DIALOG_ID);

    }
    public void saves(View view){
        String txt = getIntent().getStringExtra("txt");
        String a []= txt.split(";");
        int icon = R.drawable.images;
        String menuItem = "  ชื่อยา: "+ a[0]+"  ช่วงเวลารับประทาน : "+ a[1]+"   จำนวน : "+ a[3];
        String allTime = "    รับประทาน : "+ a[2]+"  เวลา : "+timeEditQRcode1.getText().toString();

        Uri u =Uri.parse("content://qrcode");
        ContentValues cv = new ContentValues();
        cv.put("icon",icon);
        cv.put("productname", menuItem.toString());
        cv.put("timeDate", allTime);
        Uri nari = getContentResolver().insert(u, cv);

        Intent intent = new Intent(getApplicationContext(),QRCodeMenuActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
