package ru.anutakay;

/**
 * Created by anutakay@gmail.com on 22.03.2016.
 */
public interface Checkroom {
    String put(Freezable freezable);
    Freezable get(String key);
    boolean hasFreeSpace();
    int maxCapacity();
    int usedCapacity();
}
