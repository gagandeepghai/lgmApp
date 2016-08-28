package com.losgatosmeat.restaurant.lgm;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.io.InputStream;

public class MainActivity extends ActionBarActivity {
    private DatabaseReference mFirebaseDatabaseReference;
    private static final int EDITOR_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = UIUtils.findView(this, R.id.home_text);
        tv.setText("Welcome");

        ImageView logo = UIUtils.findView(this, R.id.logo);
        logo.setImageResource(R.drawable.logo2);

        Button buttonM = UIUtils.findView(this, R.id.button_menu);
        buttonM.setText("Menu");
        buttonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });

        Button buttonO = UIUtils.findView(this, R.id.button_order);
        buttonO.setText("Order Online");
        buttonO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                renderOrdering();
            }
        });

        Button buttonC = UIUtils.findView(this, R.id.button_contact);
        buttonC.setText("Contact Info");
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactInfo();
            }
        });
    }

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

    private void contactInfo() {
        Intent intent = new Intent(MainActivity.this, ContactActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void openMenu() {
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void renderOrdering() {
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }
}
