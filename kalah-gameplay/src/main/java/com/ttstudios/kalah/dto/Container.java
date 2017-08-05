package com.ttstudios.kalah.dto;

public abstract class Container {

    private int id;

    private Player owner;

    public Container(int id, Player owner) {
        this.id = id;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
