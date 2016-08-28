package com.losgatosmeat.restaurant.lgm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gghai on 8/26/16.
 */
public class ListViewArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> values;

    public ListViewArrayAdapter(Context context, List<String> values) {
        super(context, R.layout.menu_row_layout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.menu_row_layout, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.menu_name);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.menu_image);
        imageView.setBackgroundResource(R.drawable.image_icon);
        textView.setText(values.get(position));
        String val = values.get(position);

        if ((DisplayActivity.MenuCategory.Fish.toString()).equals(val)) {
            imageView.setImageResource(R.drawable.fish_image);
        } else if ((DisplayActivity.MenuCategory.Poultry.toString()).equals(val)) {
            imageView.setImageResource(R.drawable.chicken);
        } else if ((DisplayActivity.MenuCategory.Specialities.toString()).equals(val)) {
            imageView.setImageResource(R.drawable.speciality);
        } else if ((DisplayActivity.MenuCategory.Sandwiches.toString()).equals(val)) {
            imageView.setImageResource(R.drawable.sandwich);
        }

        return rowView;
    }
}