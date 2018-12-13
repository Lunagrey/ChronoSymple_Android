package org.gradle.chronosymple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import static android.view.View.VISIBLE;

public class CalendarActivity extends AppCompatActivity {

    String hide;
    String glycémie;
    String glucide;
    String insulineapresrepas;
    String insulineavantrepas;
    String insulineajeun;
    RelativeLayout bloc = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        hide = (String) getIntent().getSerializableExtra("hide");
        glycémie = (String) getIntent().getSerializableExtra("glycémie");
        glucide = (String) getIntent().getSerializableExtra("glucide");
        insulineapresrepas = (String) getIntent().getSerializableExtra("insulineapresrepas");
        insulineavantrepas = (String) getIntent().getSerializableExtra("insulineavantrepas");
        insulineajeun = (String) getIntent().getSerializableExtra("insulineajeun");
        bloc = findViewById(R.id.relativeLayout1);

        if (hide.equals("stat")) {
            bloc.setVisibility(VISIBLE);
        }
        final Intent intent = new Intent().setClass(this, HomePage.class);
        Button dia = (Button) findViewById(R.id.Diabutton);
        dia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getToResume();
            }
        });
    }

    public void getToResume() {
        Intent i = new Intent(this, ResumeActivity.class);
        i.putExtra("hide", hide);
        i.putExtra("glycémie", glycémie);
        i.putExtra("glucide", glucide);
        i.putExtra("insulineavantrepas", insulineavantrepas);
        i.putExtra("insulineapresrepas", insulineapresrepas);
        i.putExtra("insulineajeun", insulineajeun);
        startActivity(i);
    }
}


