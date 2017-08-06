package com.ttstudios.kalah.persistence.repo;

import com.ttstudios.kalah.persistence.model.KalahGame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KalahRepository extends MongoRepository<KalahGame, String> {
    List<KalahGame> findByTitle(String title);
}
