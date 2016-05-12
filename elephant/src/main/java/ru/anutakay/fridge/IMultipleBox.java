package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.BasicException;

/**
 * Created by anutakay@gmail.com on 22.03.2016.
 */
public interface IMultipleBox<A extends IAnimal> {

    String put(A animal) throws BasicException;

    A get(String key) throws BasicException;

    boolean hasFreeSpace();

    int maxCapacity();

    int usedCapacity();
}
