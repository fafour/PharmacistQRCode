package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HistoryActivity extends Activity {
    ImageButton qrCode , addData;
    Button qrCodes,addDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

    }
    public void btnQRCodes (View v){
        qrCode = (ImageButton) findViewById(R.id.oqCodes);
        qrCodes = (Button) findViewById(R.id.btqrcodes);

        Intent intent = new Intent(getApplicationContext(),QRCodeMenuActivity.class);
        startActivity(intent);
        finish();
    }
    public void btnAdd (View v){
        addData = (ImageButton) findViewById(R.id.imbAdd);
        addDatas = (Button) findViewById(R.id.btAdd);

        Intent intent = new Intent(getApplicationContext(),AddDataMenuActivity.class);
        startActivity(intent);
        finish();
    }
    public void btnBack(View v) {
        finish();
    }

}
