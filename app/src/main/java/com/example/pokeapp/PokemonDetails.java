package com.example.pokeapp;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class PokemonDetails extends AppCompatActivity {
    int imageUrl, index;
    String pokemonName, type1, type2, hp, atk, def, spAtk, spDef, speed, total;
    ImageView imageViewSprite,
            textViewPokemonDetailsHpBar, textViewPokemonDetailsAtkBar, textViewPokemonDetailsDefBar, textViewPokemonDetailsSpAtkBar,
            textViewPokemonDetailsSpDefBar, textViewPokemonDetailsSpeedBar, textViewPokemonDetailsTotalBar;
    TextView textViewPokemonname, textViewPokemonDetailsType1, textViewPokemonDetailsType2, textViewPokemonDetailsHp, textViewPokemonDetailsAtk, textViewPokemonDetailsDef,  textViewPokemonDetailsSpAtk, textViewPokemonDetailsSpDef, textViewPokemonDetailsSpeed, textViewPokemonDetailsTotal;
    ConstraintLayout constraintLayoutBackgroundTop;
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
        // Stats
        textViewPokemonDetailsHp = findViewById(R.id.textViewPokemonDetailsHp);
        textViewPokemonDetailsAtk = findViewById(R.id.textViewPokemonDetailsAtk);
        textViewPokemonDetailsDef = findViewById(R.id.textViewPokemonDetailsDef);
        textViewPokemonDetailsSpAtk = findViewById(R.id.textViewPokemonDetailsSpAtk);
        textViewPokemonDetailsSpDef = findViewById(R.id.textViewPokemonDetailsSpDef);
        textViewPokemonDetailsSpeed = findViewById(R.id.textViewPokemonDetailsSpeed);
        textViewPokemonDetailsTotal = findViewById(R.id.textViewPokemonDetailsTotal);
        // Stat Bars
        textViewPokemonDetailsHpBar = findViewById(R.id.textViewPokemonDetailsHpBar);
        textViewPokemonDetailsAtkBar = findViewById(R.id.textViewPokemonDetailsAtkBar);
        textViewPokemonDetailsDefBar = findViewById(R.id.textViewPokemonDetailsDefBar);
        textViewPokemonDetailsSpAtkBar = findViewById(R.id.textViewPokemonDetailsSpAtkBar);
        textViewPokemonDetailsSpDefBar = findViewById(R.id.textViewPokemonDetailsSpDefBar);
        textViewPokemonDetailsSpeedBar = findViewById(R.id.textViewPokemonDetailsSpeedBar);
        textViewPokemonDetailsTotalBar = findViewById(R.id.textViewPokemonDetailsTotalBar);

        constraintLayoutBackgroundTop = findViewById(R.id.constraintLayoutBackgroundTop);

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

        ;

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
        textViewPokemonDetailsSpeed.setText(speed);
        textViewPokemonDetailsTotal.setText(total);

        textViewPokemonDetailsHpBar.getLayoutParams().width = ((220/100)*Integer.parseInt(hp));
        textViewPokemonDetailsAtkBar.getLayoutParams().width = ((220/100)*Integer.parseInt(atk));
        textViewPokemonDetailsDefBar.getLayoutParams().width = ((220/100)*Integer.parseInt(spAtk));
        textViewPokemonDetailsSpAtkBar.getLayoutParams().width = ((220/100)*Integer.parseInt(def));
        textViewPokemonDetailsSpDefBar.getLayoutParams().width = ((220/100)*Integer.parseInt(spDef));
        textViewPokemonDetailsSpeedBar.getLayoutParams().width = ((220/100)*Integer.parseInt(speed));
        textViewPokemonDetailsTotalBar.getLayoutParams().width = ((220/200)*Integer.parseInt(total));

        if (type2.isEmpty()){
            textViewPokemonDetailsType2.setVisibility(View.GONE);
        }

        switch(type1) {
            case "Bug":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_bug);
                break;
            case "Dark":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_dark);
                break;
            case "Dragon":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_dragon);
                break;
            case "Electric":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_electric);
                break;
            case "Fairy":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_fairy);
                break;
            case "Fighting":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_fighting);
                break;
            case "Fire":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_fire);
                break;
            case "Flying":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_flying);
                break;
            case "Ghost":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_ghost);
                break;
            case "Grass":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_grass);
                break;
            case "Ground":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_ground);
                break;
            case "Ice":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_ice);
                break;
            case "Normal":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_normal);
                break;
            case "Poison":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_poison);
                break;
            case "Psychic":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_psychic);
                break;
            case "Rock":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_rock);
                break;
            case "Steel":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_steel);
                break;
            case "Water":
                constraintLayoutBackgroundTop.setBackgroundResource(R.color.type_water);
                break;
        }



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