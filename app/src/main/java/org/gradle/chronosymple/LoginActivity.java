package org.gradle.chronosymple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button connect = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        connect = findViewById(R.id.connect);
        connect.setOnClickListener(clickListenerConnect);
    }

    private View.OnClickListener clickListenerConnect = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText mail;
            EditText password;

            mail = findViewById(R.id.EdityouEmail);
            password = findViewById(R.id.Editpassword);
            String mailStr = (String) mail.getText().toString();
            String passwordStr = (String) password.getText().toString();

            if (mailStr.equals("") || passwordStr.equals(""))
                Toast.makeText(LoginActivity.this, "You have to put a email and a password",Toast.LENGTH_SHORT).show();
            else
                getToHomePage();
        }
    };

    public void getToHomePage() {
        Intent i = new Intent(this, HomePage.class);
        startActivity(i);
    }
}