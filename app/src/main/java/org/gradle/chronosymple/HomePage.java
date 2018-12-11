package org.gradle.chronosymple;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    Button  marketplace = null;
    String  hide;
    private DrawerLayout mDrawerLayout;
    ActionBar actionbar = null;
    private ActionBarDrawerToggle t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hide = (String) getIntent().getSerializableExtra("hide");

        if (hide.equals("true")) {
            setContentView(R.layout.home_page);
            marketplace = findViewById(R.id.marketplace);
            marketplace.setOnClickListener(clickListenerConnect);
        }
        else {
            setContentView(R.layout.home_page_with_module);
            marketplace = findViewById(R.id.note);
            marketplace.setOnClickListener(clickListenerNote);
        }

        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.Open, R.string.Close);
        mDrawerLayout.addDrawerListener(t);
        t.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id != R.id.home) {
                    mDrawerLayout.closeDrawers();
                    Toast.makeText(HomePage.this, "You have to connect first",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    private View.OnClickListener clickListenerConnect = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goToMarketPlacePage();
        }
    };

    public void goToMarketPlacePage() {
        Intent i = new Intent(this, MarketPlaceActivity.class);
        startActivity(i);
    }

    private View.OnClickListener clickListenerNote = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goToNoteActivityPage();
        }
    };

    public void goToNoteActivityPage() {
        Intent i = new Intent(this, StatisticActivity.class);
        startActivity(i);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            if (!mDrawerLayout.isDrawerOpen(GravityCompat.START))
                mDrawerLayout.openDrawer(GravityCompat.START);
            else
                mDrawerLayout.closeDrawers();
        }
        return super.onOptionsItemSelected(item);
    }

}
