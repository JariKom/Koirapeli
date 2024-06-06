package com.Dog_clicker;

import static com.unity3d.services.core.properties.ClientProperties.getApplicationContext;

public class KoirienTekeminen {
    static int vakio= 1 ;
    static float kerroin = 1;
    static int vakio1parannus = 0;
    static int vakio2parannus = 0;
    static int vakio3parannus = 0;
    static int vakio4parannus = 0;
    static int vakio5parannus = 0;
    static int vakio6parannus = 0;
    static int vakio6parannus_1 = 0;
    static int kerroin1parannus = 0;
    static int kerroin2parannus = 0;
    static int kerroin3parannus = 0;
    static int kerroin4parannus = 0;
    static int kerroin5parannus = 0;
    static int kerroin5parannus_1 = 0;







    public static int koiraNappiPainallus(Integer koiriennumero) {



       koiriennumero= (int) (koiriennumero+vakio*kerroin);



        return koiriennumero;

    }


    public static void haeParannuksetMuistiin() {

        vakio=1;
        kerroin=1;

        int[] savedIntArray = MinunTiedot.HaeOstetutAsiat(getApplicationContext());
        int parannus1= savedIntArray[0];
        int parannus2= savedIntArray[1];
        int parannus3= savedIntArray[2];
        int parannus4= savedIntArray[3];
        int parannus5= savedIntArray[4];
        int parannus6= savedIntArray[5];
        int parannus6_1= savedIntArray[6];
        int parannus7= savedIntArray[7];
        int parannus8= savedIntArray[8];
        int parannus9= savedIntArray[9];
        int parannus10= savedIntArray[10];
        int parannus11= savedIntArray[11];
        int parannus11_1= savedIntArray[12];

        if (parannus1==1){
            vakio1parannus=1;
        }

        if (parannus2==1){
            vakio2parannus=2;
        }

        if (parannus3==1){
            vakio3parannus=3;
        }

        if (parannus4==1){
            vakio4parannus=4;
        }

        if (parannus5==1){
            vakio5parannus=5;
        }

        if (parannus6==1){
            vakio6parannus=6;
        }

        if (parannus6_1==1){
            vakio6parannus_1=7;
        }

        if (parannus7==1){
            kerroin1parannus=1;
        }

        if (parannus8==1){
            kerroin2parannus=2;
        }

        if (parannus9==1){
            kerroin3parannus=3;
        }

        if (parannus10==1){
            kerroin4parannus=4;
        }

        if (parannus11==1){
            kerroin5parannus=5;
        }

        if (parannus11_1==1){
            kerroin5parannus_1=6;
        }


        vakio=vakio+vakio1parannus+vakio2parannus+vakio3parannus+vakio4parannus+vakio5parannus+vakio6parannus+vakio6parannus_1;
        kerroin=kerroin+kerroin1parannus+kerroin2parannus+kerroin3parannus+kerroin4parannus+kerroin5parannus+kerroin5parannus_1;

    }
}
