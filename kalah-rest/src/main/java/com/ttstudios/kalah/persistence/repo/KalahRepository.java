package com.ttstudios.kalah.persistence.repo;

import com.ttstudios.kalah.persistence.model.KalahGame;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KalahRepository extends CrudRepository<KalahGame, Long> {
    List<KalahGame> findByTitle(String title);
}
