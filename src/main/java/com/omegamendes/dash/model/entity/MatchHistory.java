package com.omegamendes.dash.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by omegamendes on 7/17/16.
 */
public class MatchHistory {
    
    private Integer status;
    @SerializedName("matches") private List<Match> matches;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
