package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.EmptyException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.SizeException;

/**
 * Created by anutakay@gmail.com on 22.03.2016.
 */
public interface MultiplePlaceBox {
    String put(IAnimal freezable) throws FullException, SizeException;
    IAnimal get(String key) throws EmptyException;
    boolean hasFreeSpace();
    int maxCapacity();
    int usedCapacity();
}
