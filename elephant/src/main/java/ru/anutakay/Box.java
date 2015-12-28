package ru.anutakay;

public interface Box {

    void put(Freezable object);

    Freezable get();

    boolean isFits(Freezable object);

    boolean isFull();
}
