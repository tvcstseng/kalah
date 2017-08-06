package com.ttstudios.kalah.persistence.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by Timothy Tseng on 10-6-2017.
 */
@Configuration
@ComponentScan({ "com.ttstudios.kalah.persistence" })
public class SimpleMongoConfig {
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "Kalah");
    }
}
