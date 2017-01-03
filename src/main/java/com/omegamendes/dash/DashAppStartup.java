package com.omegamendes.dash;

import com.omegamendes.dash.api.DashCoreApi;
import com.omegamendes.dash.model.entity.Hero;
import com.omegamendes.dash.model.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import rx.Observable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by mame on 06/10/2016.
 */
@Component
public class DashAppStartup
        implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired private HeroRepository heroRepository;

    @Autowired private DashCoreApi api;

    @Override public void onApplicationEvent(final ApplicationReadyEvent event) {
        List<Hero> heroes = api.getHeroes();
                

    }



}