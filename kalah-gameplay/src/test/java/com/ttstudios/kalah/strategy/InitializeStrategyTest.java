package com.ttstudios.kalah.strategy;

import com.ttstudios.kalah.dto.World;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.ttstudios.kalah.KalahConstants.CONTAINER_QTY;
import static com.ttstudios.kalah.KalahConstants.DEFAULT_PLAYER_NAME;
import static com.ttstudios.kalah.KalahConstants.PLAYER_QTY;
import static com.ttstudios.kalah.KalahConstants.SEED_QTY;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitializeStrategyTest {

    @Autowired
    private World world;

    @Autowired
    private InitializeStrategy strategy;

    @Test
    public void initialize() throws Exception {
        World result = strategy.execute(world);

        assertThat(result).isNotNull();
        assertThat(result.getPlayers().size()).isEqualTo(PLAYER_QTY);
        assertThat(result.getContainers().size()).isEqualTo(CONTAINER_QTY);
        assertThat(result.getSeeds().size()).isEqualTo(SEED_QTY);
        int lastSeedIndexPlayer1 = (SEED_QTY / PLAYER_QTY) - 1;
        int firstSeedIndexPlayer2 = SEED_QTY / PLAYER_QTY;
        assertThat(result.getSeeds().get(lastSeedIndexPlayer1).getContainer().getOwner().getName()).isEqualTo(DEFAULT_PLAYER_NAME + " 1");
        assertThat(result.getSeeds().get(firstSeedIndexPlayer2).getContainer().getOwner().getName()).isEqualTo(DEFAULT_PLAYER_NAME + " 2");
    }

}
