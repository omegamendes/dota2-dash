package com.omegamendes.dash.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by omegamendes on 7/18/16.
 */
public class SteamID {
    
    @SerializedName("steamid") private Long SteamId;
    
    public Long getSteamId() {
        return SteamId;
    }
}
