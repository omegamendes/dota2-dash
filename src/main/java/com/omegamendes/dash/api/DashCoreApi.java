package com.omegamendes.dash.api;

import com.omegamendes.dash.model.*;
import com.omegamendes.dash.rest.Dota2API;
import com.omegamendes.dash.rest.RestApiCreator;
import rx.Observable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mame on 16/08/2016.
 */
public class DashCoreApi {

    private Dota2API api = RestApiCreator.dota2API();

    private Logger logger = Logger.getLogger(DashCoreApi.class.getName());

    public Long getSteamId64(String nickName) {
        try {
            return RestApiCreator.dota2API()
                    .resolveName(nickName).execute().body().response.getSteamId();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Cant get ID");
        }

        return null;
    }

    public Long convertTo32(Long steamId64) {
        return steamId64 - 76561197960265728L;
    }

    public void getPlayerStats(String playerName) {
        Dota2API api = RestApiCreator.dota2API();
        Long playerId = this.getSteamId64(playerName);
        Observable<Result<MatchHistory>> payload = api.matchHistory(String.valueOf(playerId));


        //Remove to test
        //        Observable<MatchDetail> matches = payload.subscribeOn(Schedulers.io())
        Observable<MatchDetail> matches = payload
                .flatMap(result -> Observable.from(result.result.getMatches()))
                .flatMap(match -> api.matchDetail(match.getId()))
                .flatMap(match -> Observable.just(match.result));

        Observable<List<Player>> players = matches.flatMap(match -> Observable.from(
                match.getPlayers()))
                .toList();

        Map<Long, Hero> heroes = new HashMap<>();
        players.flatMap(playerList -> Observable.from(playerList))
                .filter(player -> isEquals(this.convertTo32(playerId), player))
                .map(player -> mapHeroes(player, heroes))
                .subscribe();

        System.out.println(heroes);

    }

    private boolean isEquals(Long playerId, Player player) {
        return player.getId().equals(playerId);
    }

    private Map<Long, Hero> mapHeroes(Player player, Map<Long, Hero> heroes) {
        Hero hero = heroes.get(player.getHeroId());
        if (hero == null) {
            hero = new Hero(player.getHeroId());
            heroes.put(player.getHeroId(), hero);
        }
        hero.incrementTimesPicked();

        return heroes;
    }

    public List<Long> getSteamId64(List<String> nickNames) {

        return Observable.from(nickNames)
                .flatMap(nick -> Observable.just(api.resolveName(nick)))
                .flatMap(result -> {
                    try {
                        return Observable.just(result.execute().body().response.getSteamId());
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, "Cant get ID");
                    }
                    return null;
                }).toList().toBlocking().single();

    }
}
