package com.ttstudios.kalah.dto;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private List<Move> move = new ArrayList<>();

    public Player(){
    }

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Move> getMove() {
        return move;
    }

    public void setMove(List<Move> move) {
        this.move = move;
    }
}
