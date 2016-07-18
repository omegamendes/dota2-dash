package com.omegamendes.dash.rest;

import com.omegamendes.dash.model.Result;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by omegamendes on 7/17/16.
 */
public interface Dota2API {
    
    String URL = "https://api.steampowered.com/";
    
    
    @GET("IDOTA2Match_570/GetMatchHistory/V001")
    Observable<Result> matchHistory(@Query("account_id") String accountId);
    
    @GET("https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/V001")
    Observable<Result> matchDetail(@Query("match_id") String matchId);
}
