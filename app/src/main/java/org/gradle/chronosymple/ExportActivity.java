package org.gradle.chronosymple;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.export);
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
}
