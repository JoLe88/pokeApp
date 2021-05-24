package com.example.pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

public class PokedexActivity extends AppCompatActivity {

    private ArrayList<ExampleItem> exampleList;
    private RecyclerView recyclerView;
    private ExampleAdapter exampleAdapter;

    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        // Hide Actionbar
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pokedex);
        getSupportActionBar().hide();

        myDatabaseHelper = new MyDatabaseHelper(this);
        exampleList = new ArrayList<>();

        // passed intent
        int from = 1;
        int to = 151;

        createExampleListArray(from, to);
        buildRecyclerView();



    }



    public void createExampleListArray(int from, int to){
        for (int i = from; i <= to; i++) {
            Cursor cursor = myDatabaseHelper.readFromDatabase(i);

            if(cursor.getCount() == 0){
                Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
            }else {
                while(cursor.moveToNext()){
                    exampleList
                            .add(new ExampleItem(getResources().getIdentifier("sprite"+i, "drawable", getPackageName()),
                                    cursor.getInt(0),
                                    cursor.getString(1),
                                    cursor.getString(2),
                                    cursor.getString(3),
                                    cursor.getString(4),
                                    cursor.getString(5),
                                    cursor.getString(6),
                                    cursor.getString(7),
                                    cursor.getString(8),
                                    cursor.getString(9),
                                    cursor.getString(10)));
                }
            }
        }
    }

    public  void buildRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        exampleAdapter = new ExampleAdapter(this,exampleList);

        //recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(exampleAdapter);

        //Grid settings
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        // OnClickListener
        exampleAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Toast.makeText(PokedexActivity2.this, position+1+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PokedexActivity.this, PokemonDetails.class);
                intent.putExtra("Example Item", exampleList.get(position));

                startActivity(intent);
            }
        });
    }
}