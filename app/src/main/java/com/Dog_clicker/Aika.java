package com.Dog_clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Aika extends AppCompatActivity {


    TextView aikaon;

    Button NappiAjalle;

     CountDownTimer countDownTimer;
    long elapsedTime = 0; // Tämä pitää kirjaa kuluneesta ajasta
     boolean isTimerRunning = false;
    float saatuAika;
    CharSequence textFromTextView;
    String stringValueFromTextView;

    int tietotulee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aika);


        // Vastaanota tiedot Intentiltä
        Intent intent = getIntent();
        if (intent != null) {
            tietotulee = intent.getIntExtra("extra_int", 0);
        }



        aikaon = findViewById(R.id.kellonaikaid);
        NappiAjalle = findViewById(R.id.AikaAlkaaNappiID);

        NappiAjalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTimerRunning) {   // käyttäjä painaa toista kertaa, eli pysäyttää ajastimen
                    stopTimer();


                    textFromTextView = aikaon.getText();
                    stringValueFromTextView = textFromTextView.toString();


                  NappiAjalle.setVisibility(View.GONE);
               // saatuAika= Float.parseFloat(String.valueOf(aikaon));

                    if (stringValueFromTextView.equals("10,00")) {
                        // TextViewin sisältö on tasan "10,00"
                    //    System.out.println("TextViewin sisältö on 10,00.");
                        Toast.makeText(Aika.this, "Onneksi olkoon, voitit 500 000", Toast.LENGTH_SHORT).show();
                        tietotulee= tietotulee +500000;
                    } else {
                        // TextViewin sisältö ei ole "10,00"
                     //   System.out.println("TextViewin sisältö ei ole 10,00.");
                        Toast.makeText(Aika.this, "Valitan, ei onnistunut", Toast.LENGTH_SHORT).show();
                    }




                    // Viivästytä siirtymistä toiselle sivulle 5 sekuntia
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Luo Intent siirtyäksesi toiselle sivulle
                            Intent intent = new Intent(Aika.this, sivu2.class);
                            intent.putExtra("extra_int", tietotulee);
                            startActivity(intent);
                            finish(); // Sulje tämä sivu, jotta käyttäjä ei voi palata takaisin
                        }
                    }, 4000); // 3000 millisekuntia eli 3 sekuntia








                } else {    // käyttäjä painaa ekaa kertaa, eli aloittaa ajastimen
                    startTimer();
                }
            }
        });
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(Long.MAX_VALUE, 10) { // 1 sekunnin välein
            @Override
            public void onTick(long millisUntilFinished) {
                elapsedTime += 10; // Lisätään yksi sekunti joka kierroksella
                updateTimerText(elapsedTime);
            }

            @Override
            public void onFinish() {
                // Tapahtuu kun aika päättyy (voit lisätä tarvittavat toiminnot)
            }
        };

        countDownTimer.start();
        NappiAjalle.setText("Pysäytä");
        isTimerRunning = true;
    }

    private void stopTimer() {
        countDownTimer.cancel();
        NappiAjalle.setText("Aloita");
        isTimerRunning = false;
    }

    private void updateTimerText(long elapsedTime) {
        double seconds = elapsedTime / 1000.0;

        // Päivitetty rivi näyttämään sadasosat kahden desimaalin tarkkuudella
        String timeFormatted = String.format("%.2f seconds", seconds);

        aikaon.setText(timeFormatted);
    }
}