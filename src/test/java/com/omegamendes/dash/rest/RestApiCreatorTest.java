package com.omegamendes.dash.rest;

import com.omegamendes.dash.model.Result;
import org.junit.Test;
import rx.Observable;
import rx.functions.Func1;

import java.io.IOException;

/**
 * Created by omegamendes on 7/17/16.
 */
public class RestApiCreatorTest {
    @Test
    public void getMatchHistory() throws IOException {
        Observable<Result> payload = RestApiCreator.dota2API().matchHistory("76561198043220138");
    
        payload.flatMap(result1 -> Observable.just(result1.result))
                .flatMap(result -> Observable.from(result.getMatches()))
                .subscribe(System.out::println);
    }
}
