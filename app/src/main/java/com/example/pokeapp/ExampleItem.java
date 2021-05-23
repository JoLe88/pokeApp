package com.example.pokeapp;

import android.os.Parcel;
import android.os.Parcelable;

class ExampleItem implements Parcelable {
    private int imageUrl, index;
    private String pokemonName, type1, type2, hp, atk, def, spAtk, spDef, speed, total;


    public ExampleItem(int imageUrl, int index, String pokemonName, String type1, String type2, String hp, String atk, String def, String spAtk, String spDef, String speed, String total) {
        this.imageUrl = imageUrl;
        this.index = index;
        this.pokemonName = pokemonName;
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

    protected ExampleItem(Parcel in) {
        imageUrl = in.readInt();
        index = in.readInt();
        pokemonName = in.readString();
        type1 = in.readString();
        type2 = in.readString();
        hp = in.readString();
        atk = in.readString();
        def = in.readString();
        spAtk = in.readString();
        spDef = in.readString();
        speed = in.readString();
        total = in.readString();
    }

    public static final Creator<ExampleItem> CREATOR = new Creator<ExampleItem>() {
        @Override
        public ExampleItem createFromParcel(Parcel in) {
            return new ExampleItem(in);
        }

        @Override
        public ExampleItem[] newArray(int size) {
            return new ExampleItem[size];
        }
    };

    public int getImageUrl() {
        return imageUrl;
    }

    public int getIndex() {
        return index;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getHp() {
        return hp;
    }

    public String getAtk() {
        return atk;
    }

    public String getDef() {
        return def;
    }

    public String getSpAtk() {
        return spAtk;
    }

    public String getSpDef() {
        return spDef;
    }

    public String getSpeed() {
        return speed;
    }

    public String getTotal() {
        return total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageUrl);
        dest.writeInt(index);
        dest.writeString(pokemonName);
        dest.writeString(type1);
        dest.writeString(type2);
        dest.writeString(hp);
        dest.writeString(atk);
        dest.writeString(def);
        dest.writeString(spAtk);
        dest.writeString(spDef);
        dest.writeString(speed);
        dest.writeString(total);
    }
}