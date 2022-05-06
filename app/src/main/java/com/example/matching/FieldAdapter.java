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
        TextView tv = (TextView) convertView.findViewById(R.id.cell_field_name);
        ImageView iv = (ImageView) convertView.findViewById(R.id.cell_field_image);

        tv.setText(field.getName());
        iv.setImageResource(field.getImage());

        return convertView;
    }
}
