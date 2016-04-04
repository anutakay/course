package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.BasicException;

/**
 * Created by anutakay@gmail.com on 22.03.2016.
 */
public interface MultipleBox {

    String put(IAnimal animal) throws BasicException;

    IAnimal get(String key) throws BasicException;

    boolean hasFreeSpace() throws BasicException;

    int maxCapacity();

    int usedCapacity();
}
