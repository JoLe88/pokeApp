package com.example.pokeapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>  {
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        //Sprite
        int pokemonImageUrl = currentItem.getImageUrl();
        Picasso.get().load(pokemonImageUrl).fit().centerInside().into(holder.mImageView);
        //Pokemon Details
        int pokemonIndex = currentItem.getIndex();
        String pokemonName = currentItem.getPokemonName();
        String type1 = currentItem.getType1();
        String type2 = currentItem.getType2();

        //assign to layout
        holder.mTextViewPokemonIndex.setText("#" + pokemonIndex);
        holder.mTextViewPokemonName.setText(pokemonName);
        holder.mTextViewType1.setText(type1);
        holder.mTextViewType1_invisible.setText(type1);

        if (type2.isEmpty()){
            holder.type2backgrondShape.setVisibility(View.INVISIBLE);
        }else {
            holder.mTextViewType2.setText(type2);
            holder.mTextViewType2_invisible.setText(type2);
        }


        switch(type1) {
            case "Bug":
                holder.cardLayout.setBackgroundResource(R.drawable.card_bug);
                break;
            case "Dark":
                holder.cardLayout.setBackgroundResource(R.drawable.card_dark);
                break;
            case "Dragon":
                holder.cardLayout.setBackgroundResource(R.drawable.card_dragon);
                break;
            case "Electric":
                holder.cardLayout.setBackgroundResource(R.drawable.card_electric);
                break;
            case "Fairy":
                holder.cardLayout.setBackgroundResource(R.drawable.card_fairy);
                break;
            case "Fighting":
                holder.cardLayout.setBackgroundResource(R.drawable.card_fighting);
                break;
            case "Fire":
                holder.cardLayout.setBackgroundResource(R.drawable.card_fire);
                break;
            case "Flying":
                holder.cardLayout.setBackgroundResource(R.drawable.card_flying);
                break;
            case "Ghost":
                holder.cardLayout.setBackgroundResource(R.drawable.card_ghost);
                break;
            case "Grass":
                holder.cardLayout.setBackgroundResource(R.drawable.card_grass);
                break;
            case "Ground":
                holder.cardLayout.setBackgroundResource(R.drawable.card_ground);
                break;
            case "Ice":
                holder.cardLayout.setBackgroundResource(R.drawable.card_ice);
                break;
            case "Normal":
                holder.cardLayout.setBackgroundResource(R.drawable.card_normal);
                break;
            case "Poison":
                holder.cardLayout.setBackgroundResource(R.drawable.card_poison);
                break;
            case "Psychic":
                holder.cardLayout.setBackgroundResource(R.drawable.card_psychic);
                break;
            case "Rock":
                holder.cardLayout.setBackgroundResource(R.drawable.card_rock);
                break;
            case "Steel":
                holder.cardLayout.setBackgroundResource(R.drawable.card_steel);
                break;
            case "Water":
                holder.cardLayout.setBackgroundResource(R.drawable.card_water);
                break;
        }


    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewPokemonIndex;
        public TextView mTextViewPokemonName;
        public TextView mTextViewType1;
        public TextView mTextViewType2;
        public TextView mTextViewType1_invisible;
        public TextView mTextViewType2_invisible;

        public ConstraintLayout type2backgrondShape;
        public ConstraintLayout cardLayout;


        public ExampleViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewPokemonIndex = itemView.findViewById(R.id.text_view_idex);
            mTextViewPokemonName = itemView.findViewById(R.id.text_view_pokemonname);
            mTextViewType1 = itemView.findViewById(R.id.textViewType1);
            mTextViewType2 = itemView.findViewById(R.id.textViewType2);
            mTextViewType1_invisible = itemView.findViewById(R.id.textViewType1_invisible);
            mTextViewType2_invisible = itemView.findViewById(R.id.textViewType2_invisible);

            type2backgrondShape = itemView.findViewById(R.id.type2backgroudShape);
            cardLayout = itemView.findViewById(R.id.cardLayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}