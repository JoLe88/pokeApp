package com.example.pokeapp;

class ExampleItem {
    private int imageUrl;
    private int index;
    private String pokemonName;
    private String type1;
    private String type2;

    public ExampleItem(int imageUrl, int index, String pokemonName, String type1, String type2) {
        this.imageUrl = imageUrl;
        this.index = index;
        this.pokemonName = pokemonName;
        this.type1 = type1;
        this.type2 = type2;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public int getIndex() {
        return index;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }
}