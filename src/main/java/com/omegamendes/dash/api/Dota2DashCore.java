package com.omegamendes.dash.api;

import com.omegamendes.dash.model.Result;
import com.omegamendes.dash.model.SteamID;
import com.omegamendes.dash.rest.Dota2API;
import com.omegamendes.dash.rest.RestApiCreator;
import rx.Observable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mame on 16/08/2016.
 */
public class Dota2DashCore {

    Dota2API api = RestApiCreator.dota2API();

    Logger logger = Logger.getLogger(Dota2DashCore.class.getName());

    public Long getSteamId64(String nickName) {
        try {
            return RestApiCreator.dota2API()
                    .resolveName(nickName).execute().body().response.getSteamId();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Cant get ID");
        }

        return null;
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

        //        Long steam64bitId = null;
        //        try {
        //            steam64bitId = RestApiCreator.dota2API().resolveName(nickName).execute().body().response.getSteamId();
        //        } catch (IOException e) {
        //            logger.log(Level.SEVERE, "Cant resolve name");
        //        }
        //        return steam64bitId;
    }
}
