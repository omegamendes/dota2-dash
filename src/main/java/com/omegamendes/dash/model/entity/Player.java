package com.omegamendes.dash.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by omegamendes on 7/17/16.
 */
public class Player {
    
    @SerializedName("account_id") private Long id;
    @SerializedName("player_slot") private Integer slot;
    @SerializedName("hero_id") private Long heroId;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getSlot() {
        return slot;
    }
    
    public void setSlot(Integer slot) {
        this.slot = slot;
    }
    
    public Long getHeroId() {
        return heroId;
    }
    
    public void setHeroId(Long heroId) {
        this.heroId = heroId;
    }
    
    @Override
    public String toString() {
        return "Player{" +
                "account_id='" + id + '\'' +
                ", hero_id ='" + heroId + '\'' +
                '}';
    }
}
