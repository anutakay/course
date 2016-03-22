package ru.anutakay;

import ru.anutakay.exception.*;

public interface Box extends Place {

    void put(Freezable object) throws BasicException;

    Freezable get() throws BasicException;

    boolean isFull() throws BasicException;

}
