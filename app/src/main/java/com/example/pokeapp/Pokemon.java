package com.example.pokeapp;

import com.google.gson.annotations.SerializedName;

public class Pokemon {
    private String name;
    public int id;

    public Pokemon(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}