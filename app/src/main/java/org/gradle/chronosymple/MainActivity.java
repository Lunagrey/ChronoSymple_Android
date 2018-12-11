package org.gradle.chronosymple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout loadingPage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadingPage = findViewById(R.id.loading);

        loadingPage.setOnClickListener(clickListnerPage);
    }

    private View.OnClickListener clickListnerPage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goToLoginPage();
        }
    };

    public void goToLoginPage() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}
