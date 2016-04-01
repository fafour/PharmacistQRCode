package com.example.user.pharmacistqrcode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 24/3/2559.
 */
public class QRCodeAdapter extends ArrayAdapter<qrcode> {
    QRCodeAdapter(Context context, ArrayList<qrcode> ob) {
        super(context, 0, ob);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        qrcode qrcodes = getItem(position);
        qrcodes.toString();

        if(convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_menu_qrcode, parent,false);
        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.imageView);
        TextView txtName = (TextView) convertView.findViewById(R.id.txtMenu);
        TextView time = (TextView) convertView.findViewById(R.id.dateTime);

        icon.setImageResource(qrcodes.getIcon());
        txtName.setText(qrcodes.getMenuName().toString());
        time.setText(String.valueOf(qrcodes.getTime()).toString());
        return convertView;


    }



}
