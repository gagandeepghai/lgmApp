package com.losgatosmeat.restaurant.lgm;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gghai on 8/4/16.
 */
public class DisplayActivity extends ActionBarActivity {

    private static final int EDITOR_REQUEST_CODE = 1002;

    public enum MenuCategory {
        Fish,
        Poultry,
        Specialities,
        Sandwiches
    }

    public static final String MENU_ITEM_KEY = "MenuItem";

    private DatabaseReference mFirebaseDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_display);

        renderMenuItem(getIntent().getStringExtra(MENU_ITEM_KEY));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.about_us:
                goBackToHome();
                break;
            case R.id.specialities_menu:
                renderMenuItem(MenuCategory.Specialities.toString());
                break;
            case R.id.fish_menu:
                renderMenuItem(MenuCategory.Fish.toString());
                break;
            case R.id.poultry_menu:
                renderMenuItem(MenuCategory.Poultry.toString());
                break;
            case R.id.sandwiches_menu:
                renderMenuItem(MenuCategory.Sandwiches.toString());
                break;
            case R.id.order_menu:
                renderOrdering();
                break;
            default:
                goBackToHome();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void renderOrdering() {
        Intent intent = new Intent(DisplayActivity.this, OrderActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void goBackToHome() {
        Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void renderMenuItem(String value) {
        System.out.println("Received menu cat: " +value);

        TextView headerTextView = UIUtils.findView(this, R.id.menu_disp_header);
        headerTextView.setText(value);

        final Map<String, List<Pair<String, String>>> menuItems = new HashMap<>();

        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference(value);
        System.out.println("Key: " +mFirebaseDatabaseReference.getKey());
        mFirebaseDatabaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                String category = snapshot.getKey();

                Object itemObj = snapshot.getValue(Object.class);
                List<Object> membersInCategory = (List<Object>)itemObj;

                List<Pair<String, String>> entries = new ArrayList<Pair<String, String>>();
                for (Object o : membersInCategory) {
                    Map<String, String> keyVals = (HashMap<String, String>) o;
                    String name = keyVals.get("name");
                    String cost = keyVals.get("price");
                    entries.add(new Pair<String, String>(name, cost));
                }
                menuItems.put(category, entries);
                populateDisplayList(menuItems);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                //do Nothing
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                //do Nothing
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                //do Nothing
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //do Nothing
            }
        });
    }

    private void populateDisplayList(Map<String, List<Pair<String, String>>> menuItems) {

        SparseArray<MenuItemGroups> groups = new SparseArray<>();
        for (String c : menuItems.keySet()) {
            MenuItemGroups group = new MenuItemGroups(c);
            for (Pair<String, String> p : menuItems.get(c)) {
                group.children.add(new ItemWithPrice(p.first, p.second));
            }
            groups.append(groups.size(), group);
        }

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.list_menu_listing);
        ExpandableMenuListAdapter adapter = new ExpandableMenuListAdapter(this,
                groups);
        listView.setAdapter(adapter);
//        listView.setBackgroundColor(Color.RED);
    }

    private String formatLeftRightAdjust(String left, String right) {
        String formattedLeft = String.format("%-20s", left);
        String formattedRight = String.format("%20s", right);

        return formattedLeft + formattedRight + "\n";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
