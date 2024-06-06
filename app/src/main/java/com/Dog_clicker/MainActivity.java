package com.Dog_clicker;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.Task;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




//Tarkista onko internettiä, jos on, niin pakota päivitys, jos ei ole, niin mene toiselle sivulle.


        // Tarkista Internet-yhteys
        if (isInternetAvailable()) {
            // Internet-yhteys on käytettävissä
            // Voit suorittaa tarvittavat toiminnot tässä
                   paivita();
        } else {
            // Internet-yhteys ei ole käytettävissä
            // Voit esimerkiksi näyttää käyttäjälle ilmoituksen
            toinenSivu();
        }




 //       toinenSivu();


    }

    private void toinenSivu() {

        // Viivästytä siirtymistä toiselle sivulle 3 sekuntia
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Luo Intent siirtyäksesi toiselle sivulle
                Intent intent = new Intent(MainActivity.this, valikko.class);
                startActivity(intent);
                finish(); // Sulje tämä sivu, jotta käyttäjä ei voi palata takaisin
            }
        }, 1000); // 3000 millisekuntia eli 3 sekuntia



    }

    private void paivita() {
        AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(this);
        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
        // Checks that the platform will allow the specified type of update.
        appUpdateInfoTask.addOnSuccessListener(result -> {

            if (result.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
//                requestUpdate(result);

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Päivitä sovellus");


                builder.setPositiveButton("Päivitä", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try{
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id="+getPackageName())));
                        }
                        catch (ActivityNotFoundException e){
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                        }

                    }
                });

                builder.setCancelable(false); // Estä dialogin sulkeminen taustalle painamalla

                AlertDialog alertDialog = builder.create();
                alertDialog.show();





            } else {

                // käytössä on uusin versio, voi jatkaa eteenpäin.
                toinenSivu();

            }
        });


    }




    private boolean isInternetAvailable() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }

        return false;
    }




/*
    private IUnityAdsShowListener showListener = new IUnityAdsShowListener() {
        @Override
        public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {
            Log.e("UnityAdsExample", "Unity Ads failed to show ad for " + placementId + " with error: [" + error + "] " + message);
        }

        @Override
        public void onUnityAdsShowStart(String placementId) {
            mediaPlayer.pause();
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
                mediaPlayer.start();
            } else {
                // Do not reward the user for skipping the ad
                mediaPlayer.start();
            }

        }
    };



 */


}