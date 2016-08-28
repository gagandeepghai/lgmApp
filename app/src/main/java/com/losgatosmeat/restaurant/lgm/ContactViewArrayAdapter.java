package com.losgatosmeat.restaurant.lgm;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
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
public class ContactViewArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> values;

    public ContactViewArrayAdapter(Context context, List<String> values) {
        super(context, R.layout.menu_row_layout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.contact_row_layout, parent, false);

        TextView key = (TextView) rowView.findViewById(R.id.key);
        TextView value = (TextView) rowView.findViewById(R.id.value);
        String val = values.get(position);
        key.setText(val);

        if ("Phone".equals(val)) {
            value.setText(PhoneNumberUtils.formatNumber("4083547055", "US"));
        } else if ("Fax".equals(val)) {
            value.setText(PhoneNumberUtils.formatNumber("4083993320", "US"));
        } else if ("Email".equals(val)) {
            value.setText("owner@lgm.com");
        } else if ("M-F".equals(val)) {
            value.setText("9:00am - 6:00pm");
        } else if ("Sat".equals(val)) {
            value.setText("9am - 4:30pm");
        }

        return rowView;
    }
}