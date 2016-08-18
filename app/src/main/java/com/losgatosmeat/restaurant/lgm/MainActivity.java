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
        tv.setText("\nLos Gatos Meat\n");

        InputStream is = null;
        AssetManager manager = getAssets();
        try {
            is = manager.open("animated_smokehouse.gif");
            Bitmap bp = BitmapFactory.decodeStream(is);
            ImageView iv = UIUtils.findView(this, R.id.backgroudImage);
            iv.setImageBitmap(bp);

        } catch (Exception ex) {
            System.out.println("Error Setting Background Image: " +ex.getMessage());
            ex.printStackTrace();
        }
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
                renderOrdering();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeToMenuDisplay(String category) {
        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
        intent.putExtra(DisplayActivity.MENU_ITEM_KEY, category);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void renderOrdering() {
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void displayDummy() {
        System.out.println("In Dummy");
    }

}
