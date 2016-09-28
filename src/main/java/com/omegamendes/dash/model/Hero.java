package com.omegamendes.dash.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mame on 28/09/2016.
 */
public class Hero {

    @SerializedName("name") private String nameId;
    @SerializedName("id") private Long id;
    @SerializedName("localized_name") private String name;
    private Long timesPicked;

    public Hero(Long id) {
        this.timesPicked = 0L;
        this.id = id;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTimesPicked() {
        return timesPicked;
    }

    public void incrementTimesPicked() {
        this.timesPicked = timesPicked+1;
    }

    @Override public String toString() {
        return this.name +" "+ this.timesPicked;
    }
}
