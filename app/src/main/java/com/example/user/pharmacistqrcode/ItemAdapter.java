package com.example.user.pharmacistqrcode;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<item> {
    ItemAdapter(Context context, ArrayList<item> ob) {
        super(context, 0,ob);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        item item = getItem(position);
        item.toString();



        if(convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_menu_add, parent,false);
        }


        ImageView icon = (ImageView) convertView.findViewById(R.id.imageView);
        TextView txtName = (TextView) convertView.findViewById(R.id.txtMenu);
        TextView time = (TextView) convertView.findViewById(R.id.dateTime);

        icon.setImageResource(item.getIcon());
        txtName.setText(item.getMenuName().toString());
        time.setText(String.valueOf(item.getTime()).toString());

        return convertView;


    }


}
