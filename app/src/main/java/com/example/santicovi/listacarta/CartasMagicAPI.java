package com.example.santicovi.listacarta;

import android.graphics.Movie;
import android.net.Uri;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by SantiCovi on 04/12/2017.
 */

public class CartasMagicAPI {
    private final String BASE_URL = "https://api.magicthegathering.io/v1/cards";

    ArrayList<Carta> getLast100Cartas(){
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .build();
        String url = builtUri.toString();
        try {
            String jsonResponse = HttpUtils.get(url);
            return processJson(jsonResponse);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Carta> processJson(String jsonResponse) {
        ArrayList<Carta> cartas = new ArrayList<>();
        try {
            JSONObject data = new JSONObject(jsonResponse);
            JSONArray jsonCartas = data.getJSONArray("cards");
            for (int i = 0; i < jsonCartas.length(); i++) {
                JSONObject jsonCarta = jsonCartas.getJSONObject(i);

                Carta carta = new Carta();
                carta.setName(jsonCarta.getString("name"));
                carta.setManaCost(jsonCarta.getString("manaCost"));
                carta.setCmc(jsonCarta.getInt("cmc"));
                carta.setType(jsonCarta.getString("type"));
                carta.setRarity(jsonCarta.getString("rarity"));
                if(jsonCarta.has("power"))carta.setPower(jsonCarta.getString("power"));
                if(jsonCarta.has("toughness"))carta.setToughness(jsonCarta.getString("toughness"));
                carta.setImagen(jsonCarta.getString("imageUrl"));
                cartas.add(carta);
                Log.d("DEBUG", "Carta añadida");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cartas;
    }

}
