package org.gradle.chronosymple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class HomePage extends AppCompatActivity {
    Button  marketplace = null;
    String  hide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hide = (String) getIntent().getSerializableExtra("hide");
        if (hide.equals("true")) {
            setContentView(R.layout.home_page);
            marketplace = findViewById(R.id.marketplace);
            marketplace.setOnClickListener(clickListenerConnect);
        }
        else {
            setContentView(R.layout.home_page_with_module);
            marketplace = findViewById(R.id.note);
            marketplace.setOnClickListener(clickListenerNote);
        }
    }

    private View.OnClickListener clickListenerConnect = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goToMarketPlacePage();
        }
    };

    public void goToMarketPlacePage() {
        Intent i = new Intent(this, MarketPlaceActivity.class);
        startActivity(i);
    }

    private View.OnClickListener clickListenerNote = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goToNoteActivityPage();
        }
    };

    public void goToNoteActivityPage() {
        Intent i = new Intent(this, NoteActivity.class);
        startActivity(i);
    }
}
