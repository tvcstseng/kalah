package com.ttstudios.kalah.strategy;

import com.ttstudios.kalah.dto.World;

public class MoveStrategy{

    protected World execute( World world) {
        // validate that it is users turn
        world.getGameState().getMoveQty() ;

        // validate the player move is valid
        return world;
    }
}
