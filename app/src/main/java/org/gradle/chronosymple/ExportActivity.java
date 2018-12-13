package org.gradle.chronosymple;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class ExportActivity extends AppCompatActivity {

    String hide;
    String glycémie;
    String glucide;
    String insulineapresrepas;
    String insulineavantrepas;
    String insulineajeun;
    Button medList = null;
    Button modList = null;
    private DrawerLayout mDrawerLayout;
    ActionBar actionbar = null;
    private ActionBarDrawerToggle t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.export);

        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        actionbar.setTitle("Export");
        mDrawerLayout = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.Open, R.string.Close);
        mDrawerLayout.addDrawerListener(t);
        t.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.Add) {
                    mDrawerLayout.closeDrawers();
                    goToMarketPlacePage();
                }
                if (id == R.id.diabete) {
                    mDrawerLayout.closeDrawers();
                    goToHomePage();
                }
                return true;
            }
        });
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        hide = (String) getIntent().getSerializableExtra("hide");
        glycémie = (String) getIntent().getSerializableExtra("glycémie");
        glucide = (String) getIntent().getSerializableExtra("glucide");
        insulineapresrepas = (String) getIntent().getSerializableExtra("insulineapresrepas");
        insulineavantrepas = (String) getIntent().getSerializableExtra("insulineavantrepas");
        insulineajeun = (String) getIntent().getSerializableExtra("insulineajeun");
        final Intent intMed = new Intent().setClass(this, mediList.class);
        medList = (Button) findViewById(R.id.mediList);
        medList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intMed);
            }
        });
        final Intent intMod = new Intent().setClass(this, moduList.class);
        modList = (Button) findViewById(R.id.moduList);
        modList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intMod);
            }
        });
       /* final Intent intMod = new Intent().setClass(this, moduList.class);
        modList = (Button) findViewById(R.id.moduList);
        modList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intMed);
            }
        });*/
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    goToHomePage();
                    return true;
                case R.id.navigation_add_note:
                    goToNoteActivityPage();
                    return true;
                case R.id.navigation_calendar:
                    goToCalendarActivityPage();
                    return true;
                case R.id.navigation_stat:
                    goToStatisticActivityPage();
                    return true;
                case R.id.navigation_export:
                    return true;
            }
            return false;
        }
    };

    public void goToNoteActivityPage() {
        Intent i = new Intent(this, NoteActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        i.putExtra("hide", hide);
        i.putExtra("glycémie", glycémie);
        i.putExtra("glucide", glucide);
        i.putExtra("insulineavantrepas", insulineavantrepas);
        i.putExtra("insulineapresrepas", insulineapresrepas);
        i.putExtra("insulineajeun", insulineajeun);
        startActivity(i);
    }

    public void goToHomePage() {
        Intent i = new Intent(this, HomePage.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        i.putExtra("hide", hide);
        i.putExtra("glycémie", glycémie);
        i.putExtra("glucide", glucide);
        i.putExtra("insulineavantrepas", insulineavantrepas);
        i.putExtra("insulineapresrepas", insulineapresrepas);
        i.putExtra("insulineajeun", insulineajeun);
        startActivity(i);
    }

    public void goToStatisticActivityPage() {
        Intent i = new Intent(this, StatisticActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        i.putExtra("hide", hide);
        i.putExtra("glycémie", glycémie);
        i.putExtra("glucide", glucide);
        i.putExtra("insulineavantrepas", insulineavantrepas);
        i.putExtra("insulineapresrepas", insulineapresrepas);
        i.putExtra("insulineajeun", insulineajeun);
        startActivity(i);
    }

    public void goToCalendarActivityPage() {
        Intent i = new Intent(this, CalendarActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        i.putExtra("hide", hide);
        i.putExtra("glycémie", glycémie);
        i.putExtra("glucide", glucide);
        i.putExtra("insulineavantrepas", insulineavantrepas);
        i.putExtra("insulineapresrepas", insulineapresrepas);
        i.putExtra("insulineajeun", insulineajeun);
        startActivity(i);
    }

    public void goToMarketPlacePage() {
        Intent i = new Intent(this, MarketPlaceActivity.class);
        i.putExtra("hide", hide);
        i.putExtra("glycémie", glycémie);
        i.putExtra("glucide", glucide);
        i.putExtra("insulineavantrepas", insulineavantrepas);
        i.putExtra("insulineapresrepas", insulineapresrepas);
        i.putExtra("insulineajeun", insulineajeun);
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
