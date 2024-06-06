package com.Dog_clicker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class popBonus extends AppCompatActivity {



    String GameId = "5582078";
    //String AdsId = "Palkkiovideo";  // palkkiovideo
    String AdsId = "Rewarded_Android"; //

    Boolean TestMode = Boolean.FALSE; // Vaihda Falselle, kun käyttää ihan oikeita mainoksia. True, kun on testaus

  //  MediaPlayer mediaPlayer;
int tietotulee;
    Button Mainos,ajastin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popbonus);


        // Vastaanota tiedot Intentiltä
        Intent intent = getIntent();
        if (intent != null) {
            tietotulee = intent.getIntExtra("extra_int", 0);
        }


/*
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;


// 80% koko ruudusta on pop ikkuna
        getWindow().setLayout((int) (width*.8),(int) (height*.8));

        setTitle("Bonus");


 */



        Mainos=findViewById(R.id.MainokseenID);
        ajastin=findViewById(R.id.ajastimelleID);

        kutsumainos();

        Mainos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                kutsumainos();

            }
        });



        ajastin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(popBonus.this, Aika.class);
                intent.putExtra("extra_int", tietotulee);
                startActivity(intent);

            }
        });














        // Alla on mainos asiaa


        UnityAds.initialize(popBonus.this, GameId, TestMode, new IUnityAdsInitializationListener() {
            @Override
            public void onInitializationComplete() {

                //         Toast.makeText(sivu2.this, "SDK toimii", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onInitializationFailed(UnityAds.UnityAdsInitializationError error, String message) {

                //         Toast.makeText(sivu2.this, "SDK ei toimi", Toast.LENGTH_SHORT).show();

            }
        });

        UnityAds.load(AdsId);    // lisää tietyn mainoksen ID


















    }



    // alle tulee mainos asiaa
    private void kutsumainos() {
        UnityAds.show(popBonus.this, AdsId,new UnityAdsShowOptions(), showListener);
    }




    private void AlustaUusiMainos() {
        UnityAds.load(AdsId);    // lisää tietyn mainoksen ID
        UnityAds.show(popBonus.this, AdsId,new UnityAdsShowOptions(), showListener);
    }




    private IUnityAdsShowListener showListener = new IUnityAdsShowListener() {
        @Override
        public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {
            Log.e("UnityAdsExample", "Unity Ads failed to show ad for " + placementId + " with error: [" + error + "] " + message);
        }

        @Override
        public void onUnityAdsShowStart(String placementId) {
            //mediaPlayer.pause();
            Log.v("UnityAdsExample", "onUnityAdsShowStart: " + placementId);
        }

        @Override
        public void onUnityAdsShowClick(String placementId) {
            Log.v("UnityAdsExample", "onUnityAdsShowClick: " + placementId);
        }

        @Override
        public void onUnityAdsShowComplete(String placementId, UnityAds.UnityAdsShowCompletionState state) {
            Log.v("UnityAdsExample", "onUnityAdsShowComplete: " + placementId);
            if (state.equals(UnityAds.UnityAdsShowCompletionState.COMPLETED)) {
                // Reward the user for watching the ad to completion
      //         mediaPlayer.start();
                tietotulee= tietotulee +5000;


            } else {
                // Do not reward the user for skipping the ad
     //           mediaPlayer.start();
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Luo Intent siirtyäksesi toiselle sivulle

                    Intent intent = new Intent(popBonus.this, sivu2.class);

                    // Lisätään tietoja Intentiin

                    intent.putExtra("extra_int", tietotulee);

                    // Käynnistetään toinen aktiviteetti
                    startActivity(intent);



                    finish(); // Sulje tämä sivu, jotta käyttäjä ei voi palata takaisin
                }
            }, 3000); // 3000 millisekuntia eli 3 sekuntia



        }
    };






}
