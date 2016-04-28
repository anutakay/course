package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.*;

public interface SingleBox<A extends IAnimal> {

    void put(A object) throws BasicException;

    A get() throws BasicException;

    boolean isFull() throws BasicException;

}
