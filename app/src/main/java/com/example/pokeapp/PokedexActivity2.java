package com.example.pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

public class PokedexActivity2 extends AppCompatActivity {

    private ArrayList<ExampleItem> exampleList;
    private RecyclerView recyclerView;
    private ExampleAdapter exampleAdapter;

    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pokedex);
        getSupportActionBar().hide();

        myDatabaseHelper = new MyDatabaseHelper(this);
        exampleList = new ArrayList<>();





        createExampleListArray();
        buldRecyclerView();


    }



    public void createExampleListArray(){
        for (int i = 1; i <= 800; i++) {
            Cursor cursor = myDatabaseHelper.readFromDatabase(i);

            Log.d("exampleList: ", exampleList.toString());

            if(cursor.getCount() == 0){
                Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
            }else {
                while(cursor.moveToNext()){
                    exampleList
                            .add(new ExampleItem(getResources().getIdentifier("sprite"+i, "drawable", getPackageName()),
                                    cursor.getInt(0),
                                    cursor.getString(1),
                                    cursor.getString(2),
                                    cursor.getString(3)));
                }
            }
        }
    }

    public  void buldRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        exampleAdapter = new ExampleAdapter(this,exampleList);

        //recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(exampleAdapter);

        //Grid settings
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

    }
}