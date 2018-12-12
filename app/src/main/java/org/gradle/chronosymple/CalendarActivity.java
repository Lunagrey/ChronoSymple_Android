package org.gradle.chronosymple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CalendarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
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
        i.putExtra("hide", "false");
        startActivity(i);
    }
    }


