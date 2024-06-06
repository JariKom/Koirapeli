package com.Dog_clicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class valikko extends AppCompatActivity {

    Button pelaajia1, pelaajia2;
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String KEY_USERNAME = "username";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valikko);

        pelaajia1 = findViewById(R.id.pelaajaNappi1);
        pelaajia2 = findViewById(R.id.pelaajaNappi2);






        // Tarkista, onko käyttäjän nimi jo tallennettu
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String username = prefs.getString(KEY_USERNAME, null);

        // Jos käyttäjänimeä ei ole tallennettu, kysy se
        if (username == null) {
            askForUsername();
        }














        pelaajia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent yksinpeli = new Intent(valikko.this, sivu2.class);

                startActivity(yksinpeli);
            }
        });


        pelaajia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent kaksinpeli = new Intent(valikko.this, sivu1_pelaajia1.class);

                startActivity(kaksinpeli);
            }
        });


        // tämä on demo, että toimii tallentaa muistiin keksien määrä  TOIMII!!!

       // MinunTiedot.TallennaKeksienMaara(getApplicationContext(), 50);





    }

    private void askForUsername() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nimesi pistetaulukkoa varten");
        builder.setMessage("Sopimattomat nimet tullaan poistamaan");

        final EditText input = new EditText(this);

        input.setHint("Pekka");

        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            String username = input.getText().toString();


            // Tallenna käyttäjän nimi
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
            editor.putString(KEY_USERNAME, username);
            editor.apply();
        });

        builder.setCancelable(false); // Käyttäjä ei voi sulkea dialogia painamalla taustaa

        builder.show();

    }
}