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
        int from, to;
        switch (v.getId()){
            case R.id.generation1:
                from = 1;
                to = 151;
                intent.putExtra("from", from);
                intent.putExtra("to", to);
                startActivity(intent);
                break;

            case R.id.generation2:
                from = 152;
                to = 251;
                intent.putExtra("from", from);
                intent.putExtra("to", to);
                startActivity(intent);
                break;

            case R.id.generation3:
                from = 252;
                to = 386;
                intent.putExtra("from", from);
                intent.putExtra("to", to);
                startActivity(intent);
                break;

            case R.id.generation4:
                from = 387;
                to = 493;
                intent.putExtra("from", from);
                intent.putExtra("to", to);
                startActivity(intent);
                break;

            case R.id.generation5:
                from = 494;
                to = 649;
                intent.putExtra("from", from);
                intent.putExtra("to", to);
                startActivity(intent);
                break;

            case R.id.generation6:
                from = 650;
                to = 721;
                intent.putExtra("from", from);
                intent.putExtra("to", to);
                startActivity(intent);
                break;

            case R.id.generation7:
                from = 722;
                to = 810;
                intent.putExtra("from", from);
                intent.putExtra("to", to);
                startActivity(intent);
                break;

            case R.id.generation8:
                from = 811;
                to = 898;
                intent.putExtra("from", from);
                intent.putExtra("to", to);
                startActivity(intent);
                break;

        }
    }
}