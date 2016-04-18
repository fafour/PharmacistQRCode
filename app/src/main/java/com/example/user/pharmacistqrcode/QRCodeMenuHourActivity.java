package com.example.user.pharmacistqrcode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class QRCodeMenuHourActivity extends Activity implements View.OnClickListener,AdapterView.OnItemClickListener {
    ArrayList<qrcode> itemQRCodeArrayLists = new ArrayList<>();
    ListView listView;
    QRCodeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_menu_hour);

        Uri u =Uri.parse("content://qrcodeHour");
        Cursor c =getContentResolver().query(u, null, null, null, null);
        while (c.moveToNext()){
            itemQRCodeArrayLists.add(new qrcode(c.getInt(1), c.getString(2), c.getString(3)));
        }

        adapter = new QRCodeAdapter(this, itemQRCodeArrayLists);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder adb=new AlertDialog.Builder(QRCodeMenuHourActivity.this);
        adb.setTitle("Select");
        final CharSequence[] items = { "Delete"};
        final int positionToRemove = position;
        adb.setItems(items, new AlertDialog.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                itemQRCodeArrayLists.remove(positionToRemove);
                Uri u = Uri.parse("content://qrcodeHour");

                Cursor c = getContentResolver().query(u, null, null, null, null);
                String ex = "_id =?";
                c.moveToPosition(position);
                String name = c.getString(c.getColumnIndex(QRCodeDB.COL_ID));
                String[] e = new String[]{String.valueOf(name)};
                int row = getContentResolver().delete(u, ex, e);
                ShowMS("Delete");
                listView.setAdapter(adapter);
            }
        });
        adb.show();
    }

    public void ShowMS (String ms){
        Toast.makeText(this, ms, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

    }
    public void ran1 (View view){
        adapter.clear();
        Intent intent = new Intent(getApplicationContext(),QRCodeMenuHourActivity.class);
        startActivity(intent);
        finish();
    }
    public void ran2 (View view){

    }
    public void btnBack(View v) {
        adapter.clear();
        Intent intent = new Intent(getApplicationContext(),HistoryActivity.class);
        startActivity(intent);
        finish();
    }

}
