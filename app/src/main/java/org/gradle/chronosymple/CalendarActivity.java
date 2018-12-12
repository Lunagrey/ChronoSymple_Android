package org.gradle.chronosymple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {

    String hide;
    String glycémie;
    String glucide;
    String insulineapresrepas;
    String insulineavantrepas;
    String insulineajeun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        hide = (String) getIntent().getSerializableExtra("uiojp");
        glycémie = (String) getIntent().getSerializableExtra("glycémie");
        glucide = (String) getIntent().getSerializableExtra("glucide");
        insulineapresrepas = (String) getIntent().getSerializableExtra("insulineapresrepas");
        insulineavantrepas = (String) getIntent().getSerializableExtra("insulineavantrepas");
        insulineajeun = (String) getIntent().getSerializableExtra("insulineajeun");
    }
}
