package com.omegamendes.dash.rest;

import com.omegamendes.dash.model.MatchDetail;
import com.omegamendes.dash.model.MatchHistory;
import com.omegamendes.dash.model.Player;
import com.omegamendes.dash.model.Result;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.io.IOException;

/**
 * Created by omegamendes on 7/17/16.
 */
public class RestApiCreatorTest {
    @Test
    public void getMatchHistory() throws IOException {
        Dota2API api = RestApiCreator.dota2API();
        Observable<Result<MatchHistory>> payload = api.matchHistory("76561198043220138");
    
        Observable<MatchDetail> matches = payload.subscribeOn(Schedulers.io())
                .flatMap(result1 -> Observable.just(result1.result))
                .flatMap(result -> Observable.from(result.getMatches()))
                .flatMap(match -> api.matchDetail(match.getId()))
                .flatMap(match -> Observable.just(match.result));
        
        Observable<Player> players = matches.flatMap(match -> Observable.from(match.getPlayers()));
        
//        Observable<Player> averages = players.filter(player -> player.getId().equals());
    
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void getSteamID() throws IOException {
        Long steam64bitId = RestApiCreator.dota2API().resolveName("omegamendes").execute().body().response.getSteamId();
        Assert.assertThat("Id retornou corretamente", steam64bitId, CoreMatchers.equalTo(76561198043220138L));
        Long steam32bitId = steam64bitId - Dota2API.STEAM_ID_32;
        Assert.assertThat("Converteu corretamente", steam32bitId, CoreMatchers.equalTo(82954410L));
    }
}
