package com.example.pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class GenerationsActivity extends AppCompatActivity implements View.OnClickListener {

    CardView generation1, generation2, generation3, generation4, generation5, generation6, generation7, generation8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generations);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_generations);
        getSupportActionBar().hide();


        generation1 = findViewById(R.id.generation1);
        generation2 = findViewById(R.id.generation2);
        generation3 = findViewById(R.id.generation3);
        generation4 = findViewById(R.id.generation4);
        generation5 = findViewById(R.id.generation5);
        generation6 = findViewById(R.id.generation6);
        generation7 = findViewById(R.id.generation7);
        generation8 = findViewById(R.id.generation8);

        generation1.setOnClickListener(this);
        generation2.setOnClickListener(this);
        generation3.setOnClickListener(this);
        generation4.setOnClickListener(this);
        generation5.setOnClickListener(this);
        generation6.setOnClickListener(this);
        generation7.setOnClickListener(this);
        generation8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(GenerationsActivity.this, PokedexActivity.class);
        switch (v.getId()){
            case R.id.generation1:
                intent.putExtra("from", 1);
                intent.putExtra("to", 151);
                startActivity(intent);
                break;

            case R.id.generation2:
                intent.putExtra("from", 152);
                intent.putExtra("to", 251);
                startActivity(intent);
                break;

            case R.id.generation3:
                intent.putExtra("from", 252);
                intent.putExtra("to", 386);
                startActivity(intent);
                break;

            case R.id.generation4:
                intent.putExtra("from", 387);
                intent.putExtra("to", 493);
                startActivity(intent);
                break;

            case R.id.generation5:
                intent.putExtra("from", 494);
                intent.putExtra("to", 649);
                startActivity(intent);
                break;

            case R.id.generation6:
                intent.putExtra("from", 650);
                intent.putExtra("to", 721);
                startActivity(intent);
                break;

            case R.id.generation7:
                intent.putExtra("from", 722);
                intent.putExtra("to", 810);
                startActivity(intent);
                break;

            case R.id.generation8:
                intent.putExtra("from", 1);
                intent.putExtra("to", 151);
                startActivity(intent);
                break;

        }
    }
}