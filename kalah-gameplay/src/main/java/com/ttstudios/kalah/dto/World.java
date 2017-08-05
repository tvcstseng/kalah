package com.ttstudios.kalah.dto;

import com.ttstudios.kalah.strategy.InitializeStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class World {

    private List<Container> containers = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private List<Seed> seeds = new ArrayList<>();
    private GameState gameState = new GameState();

    public World() {

    }

    @PostConstruct
    private void initialize() {
        InitializeStrategy strategy = new InitializeStrategy();
    }

    public List<Seed> getSeeds() {
        return seeds;
    }

    public void setSeeds(List<Seed> seeds) {
        this.seeds = seeds;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Container> getContainers() {
        return containers;
    }

    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
