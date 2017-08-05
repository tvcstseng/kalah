package com.ttstudios.kalah.strategy;

import com.ttstudios.kalah.dto.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GamePlayStrategy extends Strategy<World> {

    @Autowired
    private World world;

    @Override
    protected World initialize() {
        return null;
    }

    @Override
    protected World execute(World world) {
        return world;
    }
}
