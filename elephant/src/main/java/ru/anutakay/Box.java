package ru.anutakay;

import ru.anutakay.exception.*;

public interface Box {

    void put(Freezable object) throws BasicException;

    Freezable get() throws BasicException;

    boolean isFits(Freezable object);

    boolean isFull() throws BasicException;
}
