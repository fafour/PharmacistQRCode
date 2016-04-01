package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends Activity {
    ImageButton scanQRCode, alert, history, add;
    Button qrCode, setting, menu, addItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //-----------------------------------------------------------------------------------------------------------------------------


    public void btnQRCode(View v) {
        scanQRCode  = (ImageButton) findViewById(R.id.imbScanQRCode);
        qrCode = (Button) findViewById(R.id.btqrcode);
        Intent intent = new Intent(getApplicationContext(), DecoderActivity.class);
        startActivity(intent);

        }


    //--------------------------------------------------------------------------------------------------------------------------------------------
    public void btnSetting(View v) {
        alert = (ImageButton) findViewById(R.id.imbSetting);
        setting = (Button) findViewById(R.id.btSitting);

        Intent intent = new Intent(getApplicationContext(), SettingSystemActivity.class);
        startActivity(intent);
    }

    public void btnHistory(View v) {
        history = (ImageButton) findViewById(R.id.imbHistory);
        menu = (Button) findViewById(R.id.btHistory);

        Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
        startActivity(intent);
    }

    public void btnAdd(View v) {
        add = (ImageButton) findViewById(R.id.imbAdd);
        addItem = (Button) findViewById(R.id.btAdd);

        Intent intent = new Intent(getApplicationContext(), AddActivity.class);
        startActivity(intent);
    }


}