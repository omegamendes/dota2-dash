package com.omegamendes.dash.model.entity;

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

    @SerializedName("duration") private Integer duration;

    @SerializedName("lobby_type") private Integer lobby;

    @SerializedName("cluster") private Integer cluster;
    
    public boolean isRadiantWinner() {
        return radiantWinner;
    }
    
    public List<Player> getPlayers() {
        return players;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getLobby() {
        return lobby;
    }

    public void setLobby(Integer lobby) {
        this.lobby = lobby;
    }

    public Integer getCluster() {
        return cluster;
    }

    public void setCluster(Integer cluster) {
        this.cluster = cluster;
    }

    @Override
    public String toString() {
        return "MatchDetail{" +
                "match_id='" + id + '\'' +
                ", players ='" + Arrays.toString(players.toArray()) + '\'' +
                '}';
    }
}
