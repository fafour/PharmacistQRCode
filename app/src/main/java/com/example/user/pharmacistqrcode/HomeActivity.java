package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends Activity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void btnClick(View v){
        imageView = (ImageView) findViewById(R.id.imageView);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }


}
