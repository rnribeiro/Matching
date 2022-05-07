package com.example.matching;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Field> {

    public FriendsAdapter(Context context, int resource, List<Field> friendsList) {
        super(context,resource,friendsList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Field field = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.field_cell, parent, false);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.cell_field_name);
        ImageView iv = (ImageView) convertView.findViewById(R.id.cell_field_image);

        tv.setText(field.getName());
        iv.setImageResource(field.getImage());

        return convertView;
    }
}