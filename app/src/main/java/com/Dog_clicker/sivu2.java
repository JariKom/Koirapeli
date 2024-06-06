package com.Dog_clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class sivu2 extends AppCompatActivity {


    MediaPlayer mediaPlayer;

    //   ProgressBar kotikeittiobar,teollisuushallibar,keksitehdasbar,pilvilinnabar,taikurinkeittiobar,labrabar;
    Button   bonus, osta, pistetaululle;
    ImageButton koira;
    TextView koirienmaara;
    Integer koiriennumero;

    String koirienmaarakenttaan="";



    // suoraan ChatGPT:stä
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sivu1_pelaajia1);








        musiikkipaalle();





        AlustaNapitJaTekstit();
        Nappientoiminnat();


/*  Muutan tämän OnResumeen. Jos tämä vain täällä, niin ei tule uudestaan myöhemmin pelissä
// Hae tallennettu käyttäjien lukumäärä
        koiriennumero = MinunTiedot.HaeKeksienMaara(getApplicationContext());

        String KeksienMaaraMuististaEsille = String.valueOf(koiriennumero);
        koirienmaara.setText(KeksienMaaraMuististaEsille);



 */


    }

    @Override
    protected void onStart() {
        super.onStart();


        Intent intent = getIntent();
        // Tarkista, onko avain ("extra_int") olemassa ennen sen hakemista
        if (intent != null && intent.hasExtra("extra_int")) {
            // Avain on olemassa, hae int-arvo
            koiriennumero = intent.getIntExtra("extra_int", 0);
            String stringValue = String.valueOf(koiriennumero);
            koirienmaara.setText(stringValue);
        } else {
            // Avainta ei ole, käsittele tilanne täällä
            // Esimerkiksi voit asettaa jonkin oletusarvon tai näyttää virheilmoituksen
            //  koirienmaara.setText("Tietoja ei saatavilla");
        }

    }




    private void Nappientoiminnat() {
        koira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                koiriennumero=KoirienTekeminen.koiraNappiPainallus(koiriennumero);
                koirienmaarakenttaan = Integer.toString(koiriennumero);
                koirienmaara.setText(koirienmaarakenttaan);

            }
        });


        osta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  startActivity(new Intent(sivu2.this, popOsta.class));

                Intent intent = new Intent(sivu2.this, popOsta.class);

                // Käynnistetään toinen aktiviteetti
                startActivity(intent);



            }
        });




        pistetaululle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(sivu2.this, Pistetaulu.class);
                // Käynnistetään toinen aktiviteetti
                startActivity(intent);


            }
        });






        bonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(sivu2.this, popBonus.class);

                String stringValue = koirienmaara.getText().toString();
                int intValue = Integer.parseInt(stringValue);

                // Lisätään tietoja Intentiin

                intent.putExtra("extra_int", intValue);

                // Käynnistetään toinen aktiviteetti
                startActivity(intent);

              //  startActivity(new Intent(sivu2.this,popBonus.class));


            }
        });
    }








    private void musiikkipaalle() {
        mediaPlayer = MediaPlayer.create(sivu2.this,R.raw.musiikki_2);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });


        mediaPlayer.start();







    }












    private void AlustaNapitJaTekstit() {
//napit

        pistetaululle= findViewById(R.id.pistetaulu_id);

koira= findViewById(R.id.koirakuva_id);

        osta= findViewById(R.id.osta_id);

        bonus= findViewById(R.id.bonus_id);
//progressbarit
koirienmaara= findViewById(R.id.Koirienmaara_id);



        koiriennumero = MinunTiedot.HaeKeksienMaara(getApplicationContext());

//koiriennumero = 0;
koirienmaarakenttaan = Integer.toString(koiriennumero);
koirienmaara.setText(koirienmaarakenttaan);



    }


    @Override
    protected void onResume() {
        super.onResume();


        // Hae tallennettu koirien lukumäärä
        koiriennumero = MinunTiedot.HaeKeksienMaara(getApplicationContext());

        String KeksienMaaraMuististaEsille = String.valueOf(koiriennumero);
        koirienmaara.setText(KeksienMaaraMuististaEsille);



        KoirienTekeminen.haeParannuksetMuistiin();
    }


    @Override
    protected void onPause() {
        super.onPause();

        MinunTiedot.TallennaKeksienMaara(getApplicationContext(), koiriennumero);

    }

}

