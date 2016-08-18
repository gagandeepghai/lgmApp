package com.losgatosmeat.restaurant.lgm;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.util.SparseArray;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

/**
 * Created by gghai on 8/17/16.
 */
public class ExpandableMenuListAdapter extends BaseExpandableListAdapter {

    private final SparseArray<MenuItemGroups> groups;
    public LayoutInflater inflater;
    public Activity activity;

    public ExpandableMenuListAdapter(Activity act, SparseArray<MenuItemGroups> groups) {
        activity = act;
        this.groups = groups;
        inflater = act.getLayoutInflater();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groups.get(groupPosition).children.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final ItemWithPrice children = (ItemWithPrice) getChild(groupPosition, childPosition);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listrow_details, null);
        }
        TextView textName = (TextView) convertView.findViewById(R.id.itemViewName);
        textName.setText(children.name);
        TextView textPrice = (TextView) convertView.findViewById(R.id.itemViewPrice);
        textPrice.setText(children.price);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).children.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listrow_group, null);
        }
        MenuItemGroups group = (MenuItemGroups) getGroup(groupPosition);
        ((CheckedTextView) convertView).setText(group.groupName);
        ((CheckedTextView) convertView).setChecked(isExpanded);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}