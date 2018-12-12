package org.gradle.chronosymple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NoteActivity extends AppCompatActivity {
    Button validate = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note);

        validate = findViewById(R.id.validate);
        validate.setOnClickListener(clickListenerValidate);
    }

    private View.OnClickListener clickListenerValidate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goToHomePage();
        }
    };

    public void goToHomePage() {
        Intent i = new Intent(this, HomePage.class);
        i.putExtra("hide", "stat");
        startActivity(i);
    }

}
