package com.example.pokeapp;

class ExampleItem {
    private String mImageUrl;
    private String mPokemonName;
    private int mIndex;

    public ExampleItem(String mImageUrl, String mPokemonName, int mIndex) {
        this.mImageUrl = mImageUrl;
        this.mPokemonName = mPokemonName;
        this.mIndex = mIndex;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmPokemonName() {
        return mPokemonName;
    }

    public int getmIndex() {
        return mIndex;
    }
}