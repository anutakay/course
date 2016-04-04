package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.*;

public interface OnePlaceBox {

    void put(IAnimal object) throws BasicException;

    IAnimal get() throws BasicException;

    boolean isFull() throws BasicException;

}
