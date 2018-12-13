package org.gradle.chronosymple;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Seth on 12/12/2018.
 */

public class ResumeActivity extends Activity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resume);

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


}
