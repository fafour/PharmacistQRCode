package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class EditTime5Activity extends Activity {
    private int pHour1;
    private int pMinute1;
    static final int TIME_DIALOG_ID = 0;
    TextView timeEditQRcode1;


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



        if (SettingSystemActivity.TIME_5 == null   ) {
            timeEditQRcode1.setText("09.30");
        }else if (SettingSystemActivity.TIME_5 != null  ) {
            timeEditQRcode1.setText(SettingSystemActivity.TIME_5);
        }
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
        int icon = R.drawable.aaxc;
        String menuItem = "  ชื่อยา: "+ a[0]+"  ช่วงเวลารับประทาน : "+ a[1]+"   จำนวน : "+ a[3];
        String allTime = "    รับประทาน : "+ a[2]+"  เวลา : "+timeEditQRcode1.getText().toString();

        Uri u =Uri.parse("content://qrcode");
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
