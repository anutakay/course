package ru.anutakay;

import ru.anutakay.exception.EmptyException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.SizeException;

/**
 * Created by anutakay@gmail.com on 22.03.2016.
 */
public interface Checkroom {
    String put(Freezable freezable) throws FullException, SizeException;
    Freezable get(String key) throws EmptyException;
    boolean hasFreeSpace();
    int maxCapacity();
    int usedCapacity();
}