package com.example.matching;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class FieldAdapter extends ArrayAdapter<Field> {

    public FieldAdapter(Context context, int resource, List<Field> shapeList) {
        super(context,resource,shapeList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Field field = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.field_cell, parent, false);
        }
        TextView cell_field_name = (TextView) convertView.findViewById(R.id.cell_field_name);
        ImageView cell_field_image = (ImageView) convertView.findViewById(R.id.cell_field_image);
        TextView location_cell_text = convertView.findViewById(R.id.location_cell_text);
        TextView time_cell_text = convertView.findViewById(R.id.time_cell_text);
        cell_field_name.setText(field.getName());
        cell_field_image.setImageResource(field.getImage());
        location_cell_text.setText(field.getLocation());
        time_cell_text.setText("Time: 18:00 - 19:00");

        return convertView;
    }
}
