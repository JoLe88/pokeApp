package com.example.pokeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;

    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        String pokemonImageUrl = currentItem.getmImageUrl();
        String pokemonName = currentItem.getmPokemonName();
        int pokemonIndex = currentItem.getmIndex();

        holder.mTextViewPokemonName.setText(pokemonName);
        holder.mTextViewPokemonIndex.setText("# " + pokemonIndex);

        //Picasso.get(mContext).load(pokemonImageUrl).fit().centerInside().into(holder.mImageView);
        Picasso.get().load(pokemonImageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewPokemonName;
        public TextView mTextViewPokemonIndex;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewPokemonName = itemView.findViewById(R.id.text_view_pokemonname);
            mTextViewPokemonIndex = itemView.findViewById(R.id.text_view_idex);
        }
    }
}