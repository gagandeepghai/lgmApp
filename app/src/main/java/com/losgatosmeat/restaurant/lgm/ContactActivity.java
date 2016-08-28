package com.losgatosmeat.restaurant.lgm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.telephony.PhoneNumberUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by gghai on 8/27/16.
 */
public class ContactActivity extends ActionBarActivity {//FragmentActivity implements OnMapReadyCallback {
    private static final int EDITOR_REQUEST_CODE = 1001;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        TextView contact = UIUtils.findView(this, R.id.contact_text);
        contact.setText("Contact Us");

        TextView address = UIUtils.findView(this, R.id.address);
        address.setText("575 University Avenue\n" +
                "Los Gatos, CA 95032");

        ImageView map = UIUtils.findView(this, R.id.map_location);
        map.setImageResource(R.drawable.map_location_hc);

        ArrayList<String> items = new ArrayList<String>(Arrays.asList("Phone", "Email", "Fax", "M-F", "Sat"));
        ListView contactList = UIUtils.findView(this, R.id.list_contact);
        final ArrayAdapter adapter = new ContactViewArrayAdapter(this, items);
        contactList.setAdapter(adapter);
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//        // Add a marker in Sydney, Australia, and move the camera.
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.home:
                goBackToHome();
                break;
            case R.id.menu:
                openMenu();
                break;
            case R.id.order:
                renderOrdering();
                break;
            case R.id.contact:
                contactInfo();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void goBackToHome() {
        Intent intent = new Intent(ContactActivity.this, MainActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void contactInfo() {
        Intent intent = new Intent(ContactActivity.this, ContactActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void openMenu() {
        Intent intent = new Intent(ContactActivity.this, MenuActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void renderOrdering() {
        Intent intent = new Intent(ContactActivity.this, OrderActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }
}
