package com.example.pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PokemonDetails extends AppCompatActivity {
    int imageUrl, index;
    String pokemonName, type1, type2, hp, atk, def, spAtk, spDef, speed, total;
    ImageView imageViewSprite;
    TextView textViewPokemonname, textViewPokemonDetailsType1, textViewPokemonDetailsType2,
            textViewPokemonDetailsHp, textViewPokemonDetailsAtk, textViewPokemonDetailsDef,
            textViewPokemonDetailsSpAtk, textViewPokemonDetailsSpDef, gtextViewPokemonDetailsSpeed, textViewPokemonDetailsTotal;
    RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);

        // Hide Actionbar
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pokemon_details);
        getSupportActionBar().hide();


        textViewPokemonname = findViewById(R.id.textViewPokemonDetailsPokemonname);
        imageViewSprite = findViewById(R.id.imageViewPokekomenDetailsSprite);
        textViewPokemonDetailsType1 = findViewById(R.id.textViewPokemonDetailsType1);
        textViewPokemonDetailsType2 = findViewById(R.id.textViewPokemonDetailsType2);
        textViewPokemonDetailsHp = findViewById(R.id.textViewPokemonDetailsHp);
        textViewPokemonDetailsAtk = findViewById(R.id.textViewPokemonDetailsAtk);
        textViewPokemonDetailsDef = findViewById(R.id.textViewPokemonDetailsDef);
        textViewPokemonDetailsSpAtk = findViewById(R.id.textViewPokemonDetailsSpAtk);
        textViewPokemonDetailsSpDef = findViewById(R.id.textViewPokemonDetailsSpDef);
        gtextViewPokemonDetailsSpeed = findViewById(R.id.textViewPokemonDetailsSpeed);
        textViewPokemonDetailsTotal = findViewById(R.id.textViewPokemonDetailsTotal);

        // passed intent
        Intent intent = getIntent();
        ExampleItem exampleItem = intent.getParcelableExtra("Example Item");

        // assign passed variables
        imageUrl = exampleItem.getImageUrl();
        index = exampleItem.getIndex();
        pokemonName = exampleItem.getPokemonName();
        type1 = exampleItem.getType1();
        type2 = exampleItem.getType2();
        hp = exampleItem.getHp();
        atk = exampleItem.getAtk();
        spAtk = exampleItem.getSpAtk();
        def = exampleItem.getDef();
        spDef = exampleItem.getSpDef();
        speed = exampleItem.getSpeed();
        total = exampleItem.getTotal();

        mQueue = Volley.newRequestQueue(this);

        textViewPokemonname.setText(pokemonName);
        imageViewSprite.setImageResource(imageUrl);
        textViewPokemonDetailsType1.setText(type1);
        textViewPokemonDetailsType2.setText(type2);
        textViewPokemonDetailsHp.setText(hp);
        textViewPokemonDetailsAtk.setText(atk);
        textViewPokemonDetailsDef.setText(spAtk);
        textViewPokemonDetailsSpAtk.setText(def);
        textViewPokemonDetailsSpDef.setText(spDef);
        gtextViewPokemonDetailsSpeed.setText(speed);
        textViewPokemonDetailsTotal.setText(total);


        //parseJSON(index);

    }

/*
    private void parseJSON(int index){

        String url = "https://pokeapi.co/api/v2/pokemon/"+index;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Pokemon Name
                            pokemonName = response.getString("name");

                            // Index
                            index = response.getInt("id");

                            // Sprite
                            JSONObject sprite = response.getJSONObject("sprites");
                            JSONObject other = sprite.getJSONObject("other");
                            JSONObject officialArtwork = other.getJSONObject("official-artwork");
                            Picasso.get().load(officialArtwork.getString("front_default")).into(imageViewSprite);

                            // Type1
                            JSONArray stats = response.getJSONArray("stats");
                            JSONObject hpObject = stats.getJSONObject(0);
                            String hp = hpObject.getString("base_stat");
                            Toast.makeText(MainActivity2.this, hp, Toast.LENGTH_SHORT).show();





                            // set Views


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity2.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(MainActivity2.this, "Fehler: "+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        mQueue.add(request);
    }
*/


}