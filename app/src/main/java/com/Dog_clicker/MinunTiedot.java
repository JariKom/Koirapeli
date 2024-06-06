package com.Dog_clicker;

import android.content.Context;
import android.content.SharedPreferences;

public class MinunTiedot {

    private static final String PREFERENCES_NAME = "MyPrefs";
    private static final String KeksienMaara = "firstValue";
    private static final String KEY_INT_ARRAY = "intArray";

    public static void TallennaKeksienMaara(Context context, int firstValue) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(KeksienMaara, firstValue);
      //  editor.apply();   // Tämä on google playn versiossa. Nyt osto ei vaikuta keksien määrään
        editor.commit();
    }

    public static int HaeKeksienMaara(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(KeksienMaara, 0); // Oletusarvo voi olla mikä tahansa sopiva arvo
    }

    public static void Osta_Asiat(Context context, int position, int value) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        String key = KEY_INT_ARRAY + "_" + position;
        editor.putInt(key, value);

        editor.apply();
        //editor.commit();
    }

    public static int[] HaeOstetutAsiat(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        //int[] intArray = new int[13]; // google playssa on tämä. Nyt ei katoa voitit pelin osto-kenttä
        int[] intArray = new int[14];

        for (int i = 0; i < intArray.length; i++) {
            String key = KEY_INT_ARRAY + "_" + i;
            intArray[i] = preferences.getInt(key, 0); // Oletusarvo voi olla mikä tahansa sopiva arvo
        }

        return intArray;

    }




}
