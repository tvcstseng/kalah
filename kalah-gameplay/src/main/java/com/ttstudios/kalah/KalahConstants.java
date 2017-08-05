package com.ttstudios.kalah;

public interface KalahConstants {

    String DEFAULT_PLAYER_NAME = "Player";

    int INITIAL_SEEDS_PER_HOUSE_QTY = 4;
    int PLAYER_CONTAINER_QTY = 7;

    int PLAYER_QTY = 2;
    int STORE_QTY = PLAYER_QTY;
    int CONTAINER_QTY = PLAYER_CONTAINER_QTY * PLAYER_QTY;
    int HOUSE_QTY = CONTAINER_QTY - STORE_QTY;
    int SEED_QTY = HOUSE_QTY * INITIAL_SEEDS_PER_HOUSE_QTY;

    // ID's
    int PLAYER_ID_1 = 0;
    int PLAYER_ID_2 = 1;

    int PLAYER_1_CONTAINER_1 = 0;
    int PLAYER_1_CONTAINER_2 = 1;
    int PLAYER_1_CONTAINER_3 = 2;
    int PLAYER_1_CONTAINER_4 = 3;
    int PLAYER_1_CONTAINER_5 = 4;
    int PLAYER_1_CONTAINER_6 = 5;
    int PLAYER_1_STORE_1 = 6;

    int PLAYER_2_CONTAINER_1 = 7;
    int PLAYER_2_CONTAINER_2 = 8;
    int PLAYER_2_CONTAINER_3 = 9;
    int PLAYER_2_CONTAINER_4 = 10;
    int PLAYER_2_CONTAINER_5 = 11;
    int PLAYER_2_CONTAINER_6 = 12;
    int PLAYER_2_STORE_2 = 13;

}
