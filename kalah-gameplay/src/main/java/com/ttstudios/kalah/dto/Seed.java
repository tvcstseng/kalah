package com.ttstudios.kalah.dto;

public class Seed {

    private Container container;

    public Seed(){}

    public Seed(Container container){
        this.container = container;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
}
