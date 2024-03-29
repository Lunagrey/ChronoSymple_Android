package org.gradle.chronosymple;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    Button  marketplace = null;
    Button  note = null;
    String  hide;
    String  glycémie;
    String  glucide;
    String  insulineapresrepas;
    String  insulineavantrepas;
    String  insulineajeun;
    LinearLayout add_note;
    LinearLayout calendar;
    LinearLayout stat;
    LinearLayout export;
    private DrawerLayout mDrawerLayout;
    ActionBar actionbar = null;
    private ActionBarDrawerToggle t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hide = (String) getIntent().getSerializableExtra("hide");
        glycémie = (String) getIntent().getSerializableExtra("glycémie");
        glucide = (String) getIntent().getSerializableExtra("glucide");
        insulineapresrepas = (String) getIntent().getSerializableExtra("insulineapresrepas");
        insulineavantrepas = (String) getIntent().getSerializableExtra("insulineavantrepas");
        insulineajeun = (String) getIntent().getSerializableExtra("insulineajeun");

        if (hide.equals("true")) {
            setContentView(R.layout.home_page);
            marketplace = findViewById(R.id.marketplace);
            marketplace.setOnClickListener(clickListenerConnect);
            actionbar = getSupportActionBar();
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionbar.setTitle("Acceuil");
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
                    return true;
                }
            });
        }
        else if (hide.equals("false")) {
            setContentView(R.layout.home_page_with_module);
            BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            note = findViewById(R.id.note);
            note.setOnClickListener(clickListenerNote);
            actionbar = getSupportActionBar();
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionbar.setTitle("Diabète");
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
                    }
                    return true;
                }
            });
        }
        else if (hide.equals("stat")) {
            setContentView(R.layout.home_page_with_notation);
            BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            note = findViewById(R.id.calendar);
            note.setOnClickListener(clickListenerCalendar);
            actionbar = getSupportActionBar();
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionbar.setTitle("Diabète");
            mDrawerLayout = (DrawerLayout)findViewById(R.id.activity_main);
            t = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.Open, R.string.Close);
            mDrawerLayout.addDrawerListener(t);
            t.syncState();
            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.diabete) {
                        mDrawerLayout.closeDrawers();
                    }
                    if (id == R.id.Add) {
                        mDrawerLayout.closeDrawers();
                        goToMarketPlacePage();
                    }
                    return true;
                }
            });
        }
        else {
            setContentView(R.layout.home_final);
            BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            add_note = findViewById(R.id.add_note);
            calendar = findViewById(R.id.calendar);
            stat = findViewById(R.id.stat);
            export = findViewById(R.id.export);
            add_note.setOnClickListener(clickListenerNote);
            calendar.setOnClickListener(clickListenerCalendar);
            stat.setOnClickListener(clickListenerStat);
            export.setOnClickListener(clickListenerExport);
            actionbar = getSupportActionBar();
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionbar.setTitle("Diabète");
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
                    }
                    return true;
                }
            });
        }
    }

    private View.OnClickListener clickListenerConnect = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goToMarketPlacePage();
        }
    };

    private View.OnClickListener clickListenerNote = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goToNoteActivityPage();
        }
    };

    private View.OnClickListener clickListenerExport = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goToExportActivityPage();
        }
    };

    private View.OnClickListener clickListenerStat = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goToStatisticActivityPage();
        }
    };

    private View.OnClickListener clickListenerCalendar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goToCalendarActivityPage();
        }
    };

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

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_add_note:
                    goToNoteActivityPageWhithoutANimation();
                    return false;
                case R.id.navigation_calendar:
                    goToCalendarActivityPageWhithoutAnimation();
                    return true;
                case R.id.navigation_stat:
                    goToStatisticActivityPageAHithoutAnimation();
                    return true;
                case R.id.navigation_export:
                    goToExportActivityPageWhithoutAnimation();
                    return true;
            }
            return false;
        }
    };

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

    public void goToNoteActivityPage() {
        Intent i = new Intent(this, NoteActivity.class);
        i.putExtra("hide", hide);
        i.putExtra("glycémie", glycémie);
        i.putExtra("glucide", glucide);
        i.putExtra("insulineavantrepas", insulineavantrepas);
        i.putExtra("insulineapresrepas", insulineapresrepas);
        i.putExtra("insulineajeun", insulineajeun);
        startActivity(i);
    }

    public void goToNoteActivityPageWhithoutANimation() {
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

    public void goToStatisticActivityPage() {
        Intent i = new Intent(this, StatisticActivity.class);
        i.putExtra("hide", hide);
        i.putExtra("glycémie", glycémie);
        i.putExtra("glucide", glucide);
        i.putExtra("insulineavantrepas", insulineavantrepas);
        i.putExtra("insulineapresrepas", insulineapresrepas);
        i.putExtra("insulineajeun", insulineajeun);
        startActivity(i);
    }

    public void goToStatisticActivityPageAHithoutAnimation() {
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


    public void goToExportActivityPage() {
        Intent i = new Intent(this, ExportActivity.class);
        i.putExtra("hide", hide);
        i.putExtra("glycémie", glycémie);
        i.putExtra("glucide", glucide);
        i.putExtra("insulineavantrepas", insulineavantrepas);
        i.putExtra("insulineapresrepas", insulineapresrepas);
        i.putExtra("insulineajeun", insulineajeun);
        startActivity(i);
    }

    public void goToExportActivityPageWhithoutAnimation() {
        Intent i = new Intent(this, ExportActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        i.putExtra("hide", hide);
        i.putExtra("glycémie", glycémie);
        i.putExtra("glucide", glucide);
        i.putExtra("insulineavantrepas", insulineavantrepas);
        i.putExtra("insulineapresrepas", insulineapresrepas);
        i.putExtra("insulineajeun", insulineajeun);
        startActivity(i);
    }

    public void goToCalendarActivityPageWhithoutAnimation() {
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

    public void goToCalendarActivityPage() {
        Intent i = new Intent(this, CalendarActivity.class);
        i.putExtra("hide", hide);
        i.putExtra("glycémie", glycémie);
        i.putExtra("glucide", glucide);
        i.putExtra("insulineavantrepas", insulineavantrepas);
        i.putExtra("insulineapresrepas", insulineapresrepas);
        i.putExtra("insulineajeun", insulineajeun);
        startActivity(i);
    }
}
