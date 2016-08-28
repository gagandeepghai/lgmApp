package com.losgatosmeat.restaurant.lgm;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.io.InputStream;

public class OrderActivity extends ActionBarActivity {
    private DatabaseReference mFirebaseDatabaseReference;
    private static final int EDITOR_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        WebView browser = UIUtils.findView(this, R.id.webview);
        browser.setInitialScale(100);
        browser.loadUrl("http://www.leapset.com/order/restaurant/lpLosGatosMeatsLg");
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
        Intent intent = new Intent(OrderActivity.this, MainActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void contactInfo() {
        Intent intent = new Intent(OrderActivity.this, ContactActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void openMenu() {
        Intent intent = new Intent(OrderActivity.this, MenuActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void renderOrdering() {
        Intent intent = new Intent(OrderActivity.this, OrderActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }
}
