package org.gradle.chronosymple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {
    Button validate = null;
    String hide;
    String glycémie;
    String glucide;
    String insulineapresrepas;
    String insulineavantrepas;
    String insulineajeun;
    EditText editglycémie;
    EditText editglucide;
    EditText editinsulineavantrepas;
    EditText editinsulineapèsrepas;
    EditText editinsulineajeun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note);

        hide = (String) getIntent().getSerializableExtra("hide");
        glycémie = (String) getIntent().getSerializableExtra("glycémie");
        glucide = (String) getIntent().getSerializableExtra("glucide");
        insulineapresrepas = (String) getIntent().getSerializableExtra("insulineapresrepas");
        insulineavantrepas = (String) getIntent().getSerializableExtra("insulineavantrepas");
        insulineajeun = (String) getIntent().getSerializableExtra("insulineajeun");

        validate = findViewById(R.id.validate);
        editglycémie = findViewById(R.id.editglycémie);
        editglucide = findViewById(R.id.editglucide);
        editinsulineapèsrepas = findViewById(R.id.editinsulineapresrepas);
        editinsulineavantrepas = findViewById(R.id.editinsulineavantrepas);
        editinsulineajeun = findViewById(R.id.editinsulineAjeun);
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
        if (hide.equals("false"))
            i.putExtra("hide", "stat");
        else
            i.putExtra("hide", hide);
        i.putExtra("glycémie", editglycémie.getText().toString());
        i.putExtra("glucide", editglucide.getText().toString());
        i.putExtra("insulineavantrepas", editinsulineavantrepas.getText().toString());
        i.putExtra("insulineapresrepas", editinsulineapèsrepas.getText().toString());
        i.putExtra("insulineajeun", editinsulineajeun.getText().toString());
        startActivity(i);
    }

}
