package com.example.pokeapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id, name, type1, type2, hp, atk, def, spAtk, spDef, speed, total;

    public CustomAdapter(Context context, ArrayList id, ArrayList name, ArrayList type1, ArrayList type2, ArrayList hp, ArrayList atk, ArrayList def, ArrayList spAtk, ArrayList spDef, ArrayList speed, ArrayList total) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
        this.total = total;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.example_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.name.setText(String.valueOf(name.get(position)));
        holder.type1.setText(String.valueOf(type1.get(position)));
        holder.type2.setText(String.valueOf(type2.get(position)));

        //Picasso.get().load(R.drawable.charizard).fit().centerInside().into(holder.mImageView);
        //Picasso.get().load(context.getApplicationContext().getResources().getIdentifier("sprite"+id, "drawable", context.getPackageName())).fit().centerInside().into(holder.mImageView);

        //Sprites einsetzen
        String pokeSprite = "sprite"+id.get(position);
        int spriteID = context.getResources().getIdentifier(pokeSprite, "drawable", context.getPackageName());
        holder.mImageView.setImageResource(spriteID);

    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView id, name, type1, type2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            id = itemView.findViewById(R.id.text_view_idex);
            name = itemView.findViewById(R.id.text_view_pokemonname);
            type1 = itemView.findViewById(R.id.textViewType1);
            type2 = itemView.findViewById(R.id.textViewType2);
        }
    }
}