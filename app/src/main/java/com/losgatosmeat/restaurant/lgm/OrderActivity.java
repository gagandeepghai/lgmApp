package com.losgatosmeat.restaurant.lgm;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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

        WebView wv = UIUtils.findView(this, R.id.webview);
        wv.loadUrl("http://www.leapset.com/order/restaurant/lpLosGatosMeatsLg");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.about_us:
                break;
            case R.id.specialities_menu:
                changeToMenuDisplay(DisplayActivity.MenuCategory.Specialities.toString());
                break;
            case R.id.fish_menu:
                changeToMenuDisplay(DisplayActivity.MenuCategory.Fish.toString());
                break;
            case R.id.poultry_menu:
                changeToMenuDisplay(DisplayActivity.MenuCategory.Poultry.toString());
                break;
            case R.id.sandwiches_menu:
                changeToMenuDisplay(DisplayActivity.MenuCategory.Sandwiches.toString());
                break;
            case R.id.order_menu:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeToMenuDisplay(String category) {
        Intent intent = new Intent(OrderActivity.this, DisplayActivity.class);
        intent.putExtra(DisplayActivity.MENU_ITEM_KEY, category);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

}
