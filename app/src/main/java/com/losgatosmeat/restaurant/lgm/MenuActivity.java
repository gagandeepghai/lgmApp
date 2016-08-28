package com.losgatosmeat.restaurant.lgm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by gghai on 8/26/16.
 */
public class MenuActivity extends ActionBarActivity {
    private static final int EDITOR_REQUEST_CODE = 1001;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView tv = UIUtils.findView(this, R.id.menu_text);
        tv.setText("Menu");

        ArrayList<String> menuItems = new ArrayList<String>(Arrays.asList(DisplayActivity.MenuCategory.Fish.toString(), DisplayActivity.MenuCategory.Sandwiches.toString(),DisplayActivity.MenuCategory.Specialities.toString(),DisplayActivity.MenuCategory.Poultry.toString()));
        ListView menuList = UIUtils.findView(this, R.id.list);
        final ArrayAdapter adapter = new ListViewArrayAdapter(this, menuItems);
        menuList.setAdapter(adapter);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                changeToMenuDisplay(DisplayActivity.getCategoryString(position));
            }
        });
    }


    private void changeToMenuDisplay(String category) {
        Intent intent = new Intent(MenuActivity.this, DisplayActivity.class);
        intent.putExtra(DisplayActivity.MENU_ITEM_KEY, category);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
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
        Intent intent = new Intent(MenuActivity.this, MainActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void contactInfo() {
        Intent intent = new Intent(MenuActivity.this, ContactActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void openMenu() {
        Intent intent = new Intent(MenuActivity.this, MenuActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    private void renderOrdering() {
        Intent intent = new Intent(MenuActivity.this, OrderActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }
}
