package com.ttstudios.kalah.web;

import com.ttstudios.kalah.persistence.model.KalahGame;
import com.ttstudios.kalah.persistence.repo.KalahRepository;
import com.ttstudios.kalah.web.exception.KalahGameIdMismatchException;
import com.ttstudios.kalah.web.exception.KalahGameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/kalah-games")
public class GameController {

    @Autowired
    private KalahRepository repository;

    @GetMapping
    public Iterable<KalahGame> findAll() {
        return repository.findAll();
    }

    @GetMapping("/title/{gameTitle}")
    public List<KalahGame> findByTitle(@PathVariable String gameTitle) {
        return repository.findByTitle(gameTitle);
    }

    @GetMapping("/{id}")
    public KalahGame findOne(@PathVariable Long id) {
        final KalahGame game = repository.findOne(id);
        if (game == null) {
            throw new KalahGameNotFoundException();
        }
        return game;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public KalahGame create(@RequestBody KalahGame game) {

        return repository.save(game);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        final KalahGame game = repository.findOne(id);
        if (game == null) {
            throw new KalahGameNotFoundException();
        }
        repository.delete(id);
    }

    @PutMapping("/{id}")
    public KalahGame updateKalahGame(@RequestBody KalahGame game, @PathVariable Long id) {
        if (game.getId() != id) {
            throw new KalahGameIdMismatchException();
        }
        final KalahGame old = repository.findOne(id);
        if (old == null) {
            throw new KalahGameNotFoundException();
        }
        return repository.save(game);
    }

}

