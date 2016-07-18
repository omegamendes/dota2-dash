package com.omegamendes.dash.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Created by omegamendes on 7/18/16.
 */
public class MatchDetail {
    
    @SerializedName("match_id") private Long id;
    @SerializedName("players")
    private List<Player> players;
    
    @SerializedName("radiant_win") private boolean radiantWinner;
    
    public boolean isRadiantWinner() {
        return radiantWinner;
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
    @Override
    public String toString() {
        return "MatchDetail{" +
                "match_id='" + id + '\'' +
                ", players ='" + Arrays.toString(players.toArray()) + '\'' +
                '}';
    }
}
