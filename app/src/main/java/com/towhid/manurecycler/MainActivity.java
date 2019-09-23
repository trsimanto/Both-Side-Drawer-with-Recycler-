package com.towhid.manurecycler;


import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;

    private RecyclerViewAdapterListener listener;
    private RecyclerView recyclerViewR;
    private MenuAdapter menuAdapterR;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerViewR = (RecyclerView) findViewById(R.id.listR);
        //Data
        ArrayList<MenuItems> nav_item= new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            nav_item.add(new MenuItems("Solaiman",R.drawable.ic_star));
            nav_item.add(new MenuItems("Towhid",R.drawable.ic_star));
            nav_item.add(new MenuItems("Gk",R.drawable.ic_star));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuAdapter = new MenuAdapter(this, nav_item);
        recyclerView.setAdapter(menuAdapter);
        menuAdapter.setRecyclerViewAdapterListener(new RecyclerViewAdapterListener() {
            @Override
            public void ItemPosition(String text) {
                Toast.makeText(MainActivity.this, "Left "+text, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerViewR.setLayoutManager(new LinearLayoutManager(this));
        menuAdapterR = new MenuAdapter(this, nav_item);
        recyclerViewR.setAdapter(menuAdapterR);
        menuAdapterR.setRecyclerViewAdapterListener(new RecyclerViewAdapterListener() {
            @Override
            public void ItemPosition(String text) {
                Toast.makeText(MainActivity.this, "Right "+text, Toast.LENGTH_SHORT).show();

            }
        });





        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (drawer.isDrawerOpen(GravityCompat.END)) {  /*Closes the Appropriate Drawer*/
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
            System.exit(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_openRight) {
            drawer.openDrawer(GravityCompat.END);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
