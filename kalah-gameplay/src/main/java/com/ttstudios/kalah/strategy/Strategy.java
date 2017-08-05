package com.ttstudios.kalah.strategy;

public abstract class Strategy<T> {

    protected abstract T initialize();

    protected abstract T execute(T world);

}
