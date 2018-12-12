package org.gradle.chronosymple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MarketPlaceActivity extends AppCompatActivity {

    String hide;
    String glycémie;
    String glucide;
    String insulineapresrepas;
    String insulineavantrepas;
    String insulineajeun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_place);

        hide = (String) getIntent().getSerializableExtra("hide");
        glycémie = (String) getIntent().getSerializableExtra("glycémie");
        glucide = (String) getIntent().getSerializableExtra("glucide");
        insulineapresrepas = (String) getIntent().getSerializableExtra("insulineapresrepas");
        insulineavantrepas = (String) getIntent().getSerializableExtra("insulineavantrepas");
        insulineajeun = (String) getIntent().getSerializableExtra("insulineajeun");
        final Intent intent = new Intent().setClass(this, HomePage.class);
        Button dia = (Button) findViewById(R.id.Diabutton);
        dia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MarketPlaceActivity.this, "VOus avez ajouter le module du diabète",Toast.LENGTH_SHORT).show();
                getToHomePage();
            }
        });
    }

    public void getToHomePage() {
        Intent i = new Intent(this, HomePage.class);
        if (hide.equals("true"))
            i.putExtra("hide", "false");
        else
            i.putExtra("hide", hide);
        startActivity(i);
    }
}
