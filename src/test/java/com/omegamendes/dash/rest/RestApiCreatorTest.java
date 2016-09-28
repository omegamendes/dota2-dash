package com.omegamendes.dash.rest;

import com.omegamendes.dash.api.DashCoreApi;
import com.omegamendes.dash.model.MatchDetail;
import com.omegamendes.dash.model.MatchHistory;
import com.omegamendes.dash.model.Result;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import rx.Observable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by omegamendes on 7/17/16.
 */
public class RestApiCreatorTest {

    private DashCoreApi core = new DashCoreApi();

    @Test
    public void getMatchHistory() throws IOException {
        Dota2API api = RestApiCreator.dota2API();
        Observable<Result<MatchHistory>> payload = api.matchHistory(String.valueOf(core.getSteamId64("Marcelo_SOAD")));


        //Remove to test
//        Observable<MatchDetail> matches = payload.subscribeOn(Schedulers.io())
        Observable<MatchDetail> matches = payload
                .flatMap(result -> Observable.from(result.result.getMatches()))
                .flatMap(match -> api.matchDetail(match.getId()))
                .flatMap(match -> Observable.just(match.result));

        matches.flatMap(match -> Observable.from(
                match.getPlayers()))
                .toList()
                .subscribe(players ->
                        Assert.assertThat("Returned all players", players.size(), CoreMatchers.equalTo(50)));

//        Observable<Player> averages = players.filter(player -> player.getId().equals());
    }
    
    @Test
    public void getSteamID() throws IOException {

        DashCoreApi core = new DashCoreApi();
        Assert.assertThat("Converteu corretamente", core.getSteamId64("omegamendes"), CoreMatchers.equalTo(76561198043220138L));
        Assert.assertThat("Converteu corretamente", core.getSteamId64("Marcelo_SOAD"), CoreMatchers.equalTo(76561198024879872L));
    }

    @Test
    public void getPlayerStats() throws IOException, InterruptedException {

        DashCoreApi core = new DashCoreApi();
        core.getPlayerStats("Marcelo_SOAD");
    }



    @Test
    public void getSteamIDByList() throws IOException {

        List<String> nicks = new ArrayList<>();
        nicks.add("omegamendes");
        nicks.add("Marcelo_SOAD");

        List<Long> steamIds = core.getSteamId64(nicks);

        Assert.assertThat("Converteu corretamente", steamIds, CoreMatchers.hasItem(76561198043220138L));
        Assert.assertThat("Converteu corretamente", steamIds, CoreMatchers.hasItem(76561198024879872L));
    }


}

