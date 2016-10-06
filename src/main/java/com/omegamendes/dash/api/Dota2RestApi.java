package com.omegamendes.dash.api;

import com.omegamendes.dash.model.entity.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by omegamendes on 7/17/16.
 */
public interface Dota2RestApi {
    
    String URL = "https://api.steampowered.com/";
    Long STEAM_ID_32 = 76561197960265728L;
    
    @GET("http://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/")
    Call<Result<SteamID>> resolveName(@Query("vanityurl") String steamName);
    
    @GET("https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001")
    Observable<Result<MatchHistory>> matchHistory(@Query("account_id") String accountId);
    
    @GET("https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/V001")
    Observable<Result<MatchDetail>> matchDetail(@Query("match_id") Long matchId);

    @GET("http://api.steampowered.com/IEconDOTA2_570/GetHeroes/v1?&language=eng")
    Observable<Result<HeroesResult>> getHeroes();


}
