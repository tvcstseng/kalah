package com.ttstudios.kalah.dto;

public class GameState {

    private int moveQty;

    private int currentPlayer;

    public int getMoveQty() {
        return moveQty;
    }

    public void setMoveQty(int moveQty) {
        this.moveQty = moveQty;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
