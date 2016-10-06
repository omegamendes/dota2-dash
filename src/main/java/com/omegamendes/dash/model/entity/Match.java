package com.omegamendes.dash.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by omegamendes on 7/17/16.
 */
public class Match {
    
    @SerializedName("match_id") private Long id;
    @SerializedName("lobby_type") private Integer lobbyType;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getLobbyType() {
        return lobbyType;
    }
    
    public void setLobbyType(Integer lobbyType) {
        this.lobbyType = lobbyType;
    }
    
    @Override
    public String toString() {
        return "Match{" +
                "match_id='" + id + '\'' +
                ", lobby_type='" + lobbyType + '\'' +
                '}';
    }
}
