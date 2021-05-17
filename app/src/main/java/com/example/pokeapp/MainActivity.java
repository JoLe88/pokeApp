package com.example.pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper myDatabaseHelper;
    ArrayList<String> id, name, type1, type2, hp, atk, def, spAtk, spDef, speed, total;
    CustomAdapter customAdapter;

    final String databaseName = "POKEMON.db";
    final String databaseTableName = "pokedex";

    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;
    private CardView mCardView;

    String pokemonName = "test";
    int index = 1;
    String spriteUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCardView = findViewById(R.id.imageView_cardLayoutId);

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);

        //getAllPokemon();



        myDatabaseHelper = new MyDatabaseHelper(MainActivity.this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        type1 = new ArrayList<>();
        type2 = new ArrayList<>();
        hp = new ArrayList<>();
        atk = new ArrayList<>();
        def = new ArrayList<>();
        spAtk = new ArrayList<>();
        spDef = new ArrayList<>();
        speed = new ArrayList<>();
        total = new ArrayList<>();

        //storeDataInArrays();

        for (int i = 1; i <= 151; i++) {
            storeDataInArrays(i);
            customAdapter = new CustomAdapter(MainActivity.this, id, name, type1, type2, hp, atk, def, spAtk,spDef,speed, total);
            mRecyclerView.setAdapter(customAdapter);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    private void getAllPokemon() {
        for (int i = 1; i <= 151; i++) {
            String allInfos = "https://pokeapi.co/api/v2/pokemon/"+i;

            final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, allInfos, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                pokemonName = response.getString("name");
                                pokemonName = pokemonName.substring(0, 1).toUpperCase() + pokemonName.substring(1);
                                index = response.getInt("id");

                                JSONObject sprite = response.getJSONObject("sprites");
                                JSONObject other = sprite.getJSONObject("other");
                                JSONObject officialArtwork = other.getJSONObject("official-artwork");

                                spriteUrl = officialArtwork.getString("front_default");

                                mExampleList.add(new ExampleItem(spriteUrl,pokemonName,index));
                                mExampleAdapter = new ExampleAdapter(MainActivity.this, mExampleList);
                                mRecyclerView.setAdapter(mExampleAdapter);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    });
            mRequestQueue.add(request);
        }
    }

    private void parseJSON(){

        String url = "https://pokeapi.co/api/v2/pokemon/1";

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String pokemonName = response.getString("name");
                            int index = response.getInt("id");

                            JSONObject sprite = response.getJSONObject("sprites");
                            JSONObject other = sprite.getJSONObject("other");
                            JSONObject officialArtwork = other.getJSONObject("official-artwork");

                            String spriteUrl = officialArtwork.getString("front_default");

                            mExampleList.add(new ExampleItem(spriteUrl, pokemonName, index));

                            mExampleAdapter = new ExampleAdapter(MainActivity.this, mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        mRequestQueue.add(request);
    }

    private void storeDataInArrays(int index){
        Cursor cursor = myDatabaseHelper.readFromDatabase(index);

        if(cursor.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else {
            while(cursor.moveToNext()){
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                type1.add(cursor.getString(2));
                type2.add(cursor.getString(3));
            }
        }
    }


}