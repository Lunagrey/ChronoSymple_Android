package org.gradle.chronosymple;

import android.app.Activity;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Seth on 12/12/2018.
 */

public class ResumeActivity extends AppCompatActivity {

    String hide;
    String glycémie;
    String glucide;
    String insulineapresrepas;
    String insulineavantrepas;
    String insulineajeun;
    TextView textglycémie;
    TextView textglucide;
    TextView textinsulineapresrepas;
    TextView textinsulineavantrepas;
    TextView textinsulineajeun;
    RelativeLayout bloc = null;
    private DrawerLayout mDrawerLayout;
    ActionBar actionbar = null;
    private ActionBarDrawerToggle t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resume);

        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        actionbar.setTitle("Resumé");
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
        hide = (String) getIntent().getSerializableExtra("hide");
        glycémie = (String) getIntent().getSerializableExtra("glycémie");
        glucide = (String) getIntent().getSerializableExtra("glucide");
        insulineapresrepas = (String) getIntent().getSerializableExtra("insulineapresrepas");
        insulineavantrepas = (String) getIntent().getSerializableExtra("insulineavantrepas");
        insulineajeun = (String) getIntent().getSerializableExtra("insulineajeun");
        bloc = findViewById(R.id.relativeLayout1);

        textglycémie = findViewById(R.id.glycémie);
        textglucide = findViewById(R.id.glucide);
        textinsulineapresrepas = findViewById(R.id.insuaprepas);
        textinsulineavantrepas = findViewById(R.id.insuavrepas);
        textinsulineajeun = findViewById(R.id.insuajeun);

        textglycémie.setText(glycémie);
        textglucide.setText(glucide);
        textinsulineavantrepas.setText(insulineavantrepas);
        textinsulineapresrepas.setText(insulineapresrepas);
        textinsulineajeun.setText(insulineajeun);
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

    public void goToHomePage() {
        Intent i = new Intent(this, HomePage.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        if (hide.equals("stat"))
            i.putExtra("hide", "tamère");
        else
            i.putExtra("hide", hide);
        i.putExtra("glycémie", glycémie);
        i.putExtra("glucide", glucide);
        i.putExtra("insulineavantrepas", insulineavantrepas);
        i.putExtra("insulineapresrepas", insulineapresrepas);
        i.putExtra("insulineajeun", insulineajeun);
        startActivity(i);
    }
}
