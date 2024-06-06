package com.Dog_clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Pistetaulu extends AppCompatActivity {

    TextView result;
    String koiriennumero;

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String KEY_USERNAME = "username";
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pistetaulu);


        koiriennumero = String.valueOf(MinunTiedot.HaeKeksienMaara(getApplicationContext()));

         result =findViewById(R.id.result);
    LähetäPisteTiedot();

   //   Luepistetiedot();

        // Tarkista, onko käyttäjän nimi jo tallennettu
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
         username = prefs.getString(KEY_USERNAME, null);


    }



    private void LähetäPisteTiedot() {

        String deviceId = Build.ID; // Muista lisätä manifestiin oikeus tälle


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        // String url ="https://kuskix.altervista.org/kuski/create.php";
        String url ="https://kuskix.altervista.org/kuski/create.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                      //  Toast.makeText(Pistetaulu.this, response, Toast.LENGTH_SHORT).show();
                        Luepistetiedot(); // Tämä on kokeilua, onnistuuko kutsua täältä tätä funktiota
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //textView.setText("That didn't work!");
                //       Log.e("error",error.getLocalizedMessage());
                //       Toast.makeText(MainActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                //  paramV.put("id", "1"); // tämä on mahdollista, että teen tässä listan, mitä haluan lähettää.
                 paramV.put("data", koiriennumero);
                 paramV.put("nimi", username);
                paramV.put("id", deviceId);
                return paramV;
            }
        };
        queue.add(stringRequest);



    }


    private void Luepistetiedot() {

        String deviceId = Build.ID; // Muista lisätä manifestiin oikeus tälle


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        // String url ="https://kuskix.altervista.org/kuski/create.php";
        String url ="https://kuskix.altervista.org/kuski/read.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray  = new JSONArray(response);
                            for (int i = 0;i<jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String id = jsonObject.getString("id");
                                String data = jsonObject.getString("data");
                                String nimi = jsonObject.getString("nimi");
                                //result.append("ID = " + id + "Data = " + data + "\n");
                                result.append("Nimi: " + nimi + "          pisteet:   " + data + "\n");


                            }


                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //textView.setText("That didn't work!");
                //       Log.e("error",error.getLocalizedMessage());
                //       Toast.makeText(MainActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                //  paramV.put("id", "1"); // tämä on mahdollista, että teen tässä listan, mitä haluan lähettää.
                // paramV.put("data", data);
                paramV.put("id", deviceId);
                return paramV;
            }
        };
        queue.add(stringRequest);



    }











}



