package org.gradle.chronosymple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MarketPlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_place);

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
        i.putExtra("hide", "false");
        startActivity(i);
    }
}
