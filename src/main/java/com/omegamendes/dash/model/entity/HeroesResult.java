package com.omegamendes.dash.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mame on 28/09/2016.
 */
public class HeroesResult {

    @SerializedName("heroes") private List<Hero> heroes;
    @SerializedName("count") private Integer quantity;

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
