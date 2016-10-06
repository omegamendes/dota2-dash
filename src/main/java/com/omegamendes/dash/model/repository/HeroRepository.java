package com.omegamendes.dash.model.repository;

import com.omegamendes.dash.model.entity.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by mame on 06/10/2016.
 */
public interface HeroRepository extends MongoRepository<Hero, String> {

    Hero findByNameId(String nameId);

}
