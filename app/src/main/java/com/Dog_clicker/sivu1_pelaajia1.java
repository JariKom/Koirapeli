package com.Dog_clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sivu1_pelaajia1 extends AppCompatActivity {





Button PeliAlusta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sivu2);



PeliAlusta = findViewById(R.id.aloita_peli_alusta);

PeliAlusta.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        // nollaa keksien määrä
        MinunTiedot.TallennaKeksienMaara(getApplicationContext(), 0);

        // nollaa kaikki parannukset
        MinunTiedot.Osta_Asiat(getApplicationContext(), 1, 0);
        MinunTiedot.Osta_Asiat(getApplicationContext(), 2, 0);
        MinunTiedot.Osta_Asiat(getApplicationContext(), 3, 0);
        MinunTiedot.Osta_Asiat(getApplicationContext(), 4, 0);
        MinunTiedot.Osta_Asiat(getApplicationContext(), 5, 0);
        MinunTiedot.Osta_Asiat(getApplicationContext(), 6, 0);
        MinunTiedot.Osta_Asiat(getApplicationContext(), 7, 0);
        MinunTiedot.Osta_Asiat(getApplicationContext(), 8, 0);
        MinunTiedot.Osta_Asiat(getApplicationContext(), 9, 0);
        MinunTiedot.Osta_Asiat(getApplicationContext(), 10, 0);
        MinunTiedot.Osta_Asiat(getApplicationContext(), 11, 0);
        MinunTiedot.Osta_Asiat(getApplicationContext(), 12, 0);
        MinunTiedot.Osta_Asiat(getApplicationContext(), 13, 0);

    }
});






    }





}



