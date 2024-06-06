package com.Dog_clicker;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class popOsta extends AppCompatActivity {


    Button osta1,osta2,osta3,osta4,osta5,osta6,osta6_1,osta7,osta8,osta9,osta10,osta11,osta11_1,osta12;
    ConstraintLayout ostaAlue1,ostaAlue2,ostaAlue3,ostaAlue4,ostaAlue5,ostaAlue6,ostaAlue6_1,ostaAlue7,ostaAlue8,ostaAlue9,ostaAlue10,ostaAlue11,ostaAlue11_1,ostaAlue12;

   TextView PaljonkoKoiria;
    Integer koiriennumerotallella;

   // int[] myIntArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    setContentView(R.layout.popwindow);

        setTitle("Osta");


//        keksejaon.findViewById(R.id.kekseja_raha_ID);



        int[] ostaAlueResIds = {
                R.id.osta_1_alue_id,
                R.id.osta_2_alue_id,
                R.id.osta_3_alue_id,
                R.id.osta_4_alue_id,
                R.id.osta_5_alue_id,
                R.id.osta_6_alue_id,
                R.id.osta_6_1_alue_id,
                R.id.osta_7_alue_id,
                R.id.osta_8_alue_id,
                R.id.osta_9_alue_id,
                R.id.osta_10_alue_id,
                R.id.osta_11_alue_id,
                R.id.osta_11_1_alue_id,
                R.id.osta_12_alue_id
        };



// 0,0,0,1,0,0,0,0
        // Hae tallennettu int-taulukko
        int[] savedIntArray = MinunTiedot.HaeOstetutAsiat(getApplicationContext());

// Käytä tallennettua taulukkoa
        for (int i = 0; i < savedIntArray.length; i++) {
            int resourceId = ostaAlueResIds[i];
            ConstraintLayout ostaAlue = findViewById(resourceId);

            if (savedIntArray[i] == 1) {
                ostaAlue.setVisibility(View.GONE);
            } else {
                ostaAlue.setVisibility(View.VISIBLE);
            }
        }








        PaljonkoKoiria= findViewById(R.id.paljonkoKoiria);


        koiriennumerotallella = MinunTiedot.HaeKeksienMaara(getApplicationContext());

        String KeksienMaaraMuististaEsille = String.valueOf(koiriennumerotallella);
        PaljonkoKoiria.setText(KeksienMaaraMuististaEsille);


//
        Alustatietoja();






        osta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta1.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }

                ostaAlue1.setVisibility(View.GONE);
          //      myIntArray[0] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 0, 1);;

                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-10;
                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

                koiriennumerotallella = luku;
                VoikoOstaa();

            }
        });

        osta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta2.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }

                ostaAlue2.setVisibility(View.GONE);
             //   myIntArray[1] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 1, 1);;

                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-50;
                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

                koiriennumerotallella = luku;
                VoikoOstaa();
            }
        });

        osta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta3.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }

                ostaAlue3.setVisibility(View.GONE);
              //  myIntArray[2] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 2, 1);;

                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-200;
                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

                koiriennumerotallella = luku;
                VoikoOstaa();

            }
        });

        osta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta4.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }

                ostaAlue4.setVisibility(View.GONE);
               // myIntArray[3] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 3, 1);;

                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-1000;
                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

                koiriennumerotallella = luku;
                VoikoOstaa();

            }
        });

        osta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta5.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }

                ostaAlue5.setVisibility(View.GONE);
             //   myIntArray[4] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 4, 1);;

                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-5000;
                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

                koiriennumerotallella = luku;
                VoikoOstaa();


            }
        });

        osta6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta6.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }

                ostaAlue6.setVisibility(View.GONE);
             //   myIntArray[5] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 5, 1);;

                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-100000;
                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

                koiriennumerotallella = luku;
                VoikoOstaa();



            }
        });


        osta6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta6_1.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }

                ostaAlue6_1.setVisibility(View.GONE);
                //   myIntArray[5] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 6, 1);;

                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-300000;
                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

                koiriennumerotallella = luku;
                VoikoOstaa();

            }
        });





        osta7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta7.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }

                ostaAlue7.setVisibility(View.GONE);
             //   myIntArray[6] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 7, 1);;

                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-250;
                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

                koiriennumerotallella = luku;
                VoikoOstaa();

            }
        });

        osta8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta8.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }

                ostaAlue8.setVisibility(View.GONE);
              //  myIntArray[7] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 8, 1);;

                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-8000;
                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

                koiriennumerotallella = luku;
                VoikoOstaa();

            }
        });

        osta9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta9.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }

                ostaAlue9.setVisibility(View.GONE);
             //   myIntArray[8] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 9, 1);;

                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-30000;
                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

                koiriennumerotallella = luku;
                VoikoOstaa();

            }
        });

        osta10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta10.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }

                ostaAlue10.setVisibility(View.GONE);
             //   myIntArray[9] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 10, 1);;


                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-70000;

                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

                koiriennumerotallella = luku;
                VoikoOstaa();


            }
        });

        osta11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta11.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }

                ostaAlue11.setVisibility(View.GONE);
             //   myIntArray[10] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 11, 1);;

                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-250000;
                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

                koiriennumerotallella = luku;
                VoikoOstaa();

            }
        });







        osta11_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta11_1.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }


                ostaAlue11_1.setVisibility(View.GONE);
                //   myIntArray[10] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 12, 1);;

                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-500000;
                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

                koiriennumerotallella = luku;
                VoikoOstaa();

            }
        });



        osta12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!osta12.isClickable()) {
                    return; // Estä toiminta, jos nappi ei ole klikattavissa
                }

                ostaAlue12.setVisibility(View.GONE);


                String teksti = PaljonkoKoiria.getText().toString();
                int luku = Integer.parseInt(teksti);
                luku=luku-1000000;
                teksti=String.valueOf(luku);
                PaljonkoKoiria.setText(teksti);

            //    myIntArray[11] = 1;
                MinunTiedot.Osta_Asiat(getApplicationContext(), 13, 1);;
                Toast.makeText(popOsta.this, "Onneksi olkoon, voitit pelin", Toast.LENGTH_LONG).show();




            }
        });





    }

    private void Alustatietoja() {

        osta1=findViewById(R.id.osta_1_ID);
        ostaAlue1=findViewById(R.id.osta_1_alue_id);
        osta2=findViewById(R.id.osta_2_ID);
        ostaAlue2=findViewById(R.id.osta_2_alue_id);
        osta3=findViewById(R.id.osta_3_ID);
        ostaAlue3=findViewById(R.id.osta_3_alue_id);
        osta4=findViewById(R.id.osta_4_ID);
        ostaAlue4=findViewById(R.id.osta_4_alue_id);
        osta5=findViewById(R.id.osta_5_ID);
        ostaAlue5=findViewById(R.id.osta_5_alue_id);
        osta6=findViewById(R.id.osta_6_ID);
        ostaAlue6=findViewById(R.id.osta_6_alue_id);
        osta6_1=findViewById(R.id.osta_6_1_ID);
        ostaAlue6_1=findViewById(R.id.osta_6_1_alue_id);
        osta7=findViewById(R.id.osta_7_ID);
        ostaAlue7=findViewById(R.id.osta_7_alue_id);
        osta8=findViewById(R.id.osta_8_ID);
        ostaAlue8=findViewById(R.id.osta_8_alue_id);
        osta9=findViewById(R.id.osta_9_ID);
        ostaAlue9=findViewById(R.id.osta_9_alue_id);
        osta10=findViewById(R.id.osta_10_ID);
        ostaAlue10=findViewById(R.id.osta_10_alue_id);
        osta11=findViewById(R.id.osta_11_ID);
        ostaAlue11=findViewById(R.id.osta_11_alue_id);
        osta11_1=findViewById(R.id.osta_11_1_ID);
        ostaAlue11_1=findViewById(R.id.osta_11_1_alue_id);
        osta12=findViewById(R.id.osta_12_ID);
        ostaAlue12=findViewById(R.id.osta_12_alue_id);



VoikoOstaa();

    }

    private void VoikoOstaa() {
        if (koiriennumerotallella>=10){
            osta1.setClickable(true);
            osta1.setBackgroundColor(Color.BLUE);
        }else {
            osta1.setClickable(false);
            osta1.setBackgroundColor(Color.GRAY);
        }


        if (koiriennumerotallella>=50){
            osta2.setClickable(true);
            osta2.setBackgroundColor(Color.BLUE);
        }else {
            osta2.setClickable(false);
            osta2.setBackgroundColor(Color.GRAY);
        }


        if (koiriennumerotallella>=200){
            osta3.setClickable(true);
            osta3.setBackgroundColor(Color.BLUE);
        }else {
            osta3.setClickable(false);
            osta3.setBackgroundColor(Color.GRAY);
        }


        if (koiriennumerotallella>=1000){
            osta4.setClickable(true);
            osta4.setBackgroundColor(Color.BLUE);
        }else {
            osta4.setClickable(false);
            osta4.setBackgroundColor(Color.GRAY);
        }

        if (koiriennumerotallella>=5000){
            osta5.setClickable(true);
            osta5.setBackgroundColor(Color.BLUE);
        }else {
            osta5.setClickable(false);
            osta5.setBackgroundColor(Color.GRAY);
        }


        if (koiriennumerotallella>=100000){
            osta6.setClickable(true);
            osta6.setBackgroundColor(Color.BLUE);
        }else {
            osta6.setClickable(false);
            osta6.setBackgroundColor(Color.GRAY);
        }


        if (koiriennumerotallella>=300000){
            osta6_1.setClickable(true);
            osta6_1.setBackgroundColor(Color.BLUE);
        }else {
            osta6_1.setClickable(false);
            osta6_1.setBackgroundColor(Color.GRAY);
        }


        if (koiriennumerotallella>=250){
            osta7.setClickable(true);
            osta7.setBackgroundColor(Color.BLUE);
        }else {
            osta7.setClickable(false);
            osta7.setBackgroundColor(Color.GRAY);
        }


        if (koiriennumerotallella>=8000){
            osta8.setClickable(true);
            osta8.setBackgroundColor(Color.BLUE);
        }else {
            osta8.setClickable(false);
            osta8.setBackgroundColor(Color.GRAY);
        }

        if (koiriennumerotallella>=30000){
            osta9.setClickable(true);
            osta9.setBackgroundColor(Color.BLUE);
        }else {
            osta9.setClickable(false);
            osta9.setBackgroundColor(Color.GRAY);
        }


        if (koiriennumerotallella>=70000){
            osta10.setClickable(true);
            osta10.setBackgroundColor(Color.BLUE);
        }else {
            osta10.setClickable(false);
            osta10.setBackgroundColor(Color.GRAY);
        }


        if (koiriennumerotallella>=250000){
            osta11.setClickable(true);
            osta11.setBackgroundColor(Color.BLUE);
        }else {
            osta11.setClickable(false);
            osta11.setBackgroundColor(Color.GRAY);
        }


        if (koiriennumerotallella>=500000){
            osta11_1.setClickable(true);
            osta11_1.setBackgroundColor(Color.BLUE);
        }else {
            osta11_1.setClickable(false);
            osta11_1.setBackgroundColor(Color.GRAY);
        }


        if (koiriennumerotallella>=1000000){
            osta12.setClickable(true);
            osta12.setBackgroundColor(Color.BLUE);
        }else {
            osta12.setClickable(false);
            osta12.setBackgroundColor(Color.GRAY);
        }

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("oston pause","nyt tuli oston pause ja keksejä on:" + koiriennumerotallella);
        MinunTiedot.TallennaKeksienMaara(getApplicationContext(), koiriennumerotallella);

    }


}
