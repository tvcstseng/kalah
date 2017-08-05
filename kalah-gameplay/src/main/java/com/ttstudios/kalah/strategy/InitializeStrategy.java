package com.ttstudios.kalah.strategy;

import com.ttstudios.kalah.dto.Container;
import com.ttstudios.kalah.dto.House;
import com.ttstudios.kalah.dto.Player;
import com.ttstudios.kalah.dto.Seed;
import com.ttstudios.kalah.dto.Store;
import com.ttstudios.kalah.dto.World;
import org.springframework.stereotype.Component;

import static com.ttstudios.kalah.KalahConstants.CONTAINER_QTY;
import static com.ttstudios.kalah.KalahConstants.DEFAULT_PLAYER_NAME;
import static com.ttstudios.kalah.KalahConstants.INITIAL_SEEDS_PER_HOUSE_QTY;
import static com.ttstudios.kalah.KalahConstants.PLAYER_1_STORE_1;
import static com.ttstudios.kalah.KalahConstants.PLAYER_2_STORE_2;
import static com.ttstudios.kalah.KalahConstants.PLAYER_CONTAINER_QTY;
import static com.ttstudios.kalah.KalahConstants.PLAYER_ID_1;
import static com.ttstudios.kalah.KalahConstants.PLAYER_ID_2;
import static com.ttstudios.kalah.KalahConstants.PLAYER_QTY;

@Component
public class InitializeStrategy extends Strategy<World> {

    @Override
    protected World initialize() {
        return null;
    }

    @Override
    public World execute(World world) {

        // Player init
        for ( int i = 0; i < PLAYER_QTY; i++ ) {
            world.getPlayers().add( initializePlayer( DEFAULT_PLAYER_NAME + " " + (i + 1) ) );
        }

        // Container init
        for (int i = 0; i < CONTAINER_QTY; i++) {
            Player player;
            if (i < PLAYER_CONTAINER_QTY) {
                player = world.getPlayers().get(PLAYER_ID_1);
            }
            else {
                player = world.getPlayers().get(PLAYER_ID_2);
            }
            world.getContainers().add(intitializeContainer(world, i, player));
        }

        return world;
    }

    private Player initializePlayer(String name) {
        Player player = new Player( name ); return player;
    }

    private Container intitializeContainer(World world, int id, Player owner){
        Container result = null;

        switch ( id ) {
            case PLAYER_1_STORE_1:
                result = new Store( id, owner );
                break;
            case PLAYER_2_STORE_2:
                result = new Store( id, owner );
                break;
            default:
                result = new House( id, owner );

                // Seed init
                for (int i = 0; i < INITIAL_SEEDS_PER_HOUSE_QTY; i++)
                    world.getSeeds().add(initializeSeed(result));
                break;
        }

        return result;
    }

    private Seed initializeSeed(Container container){
        return new Seed(container);
    }
}
