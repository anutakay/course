package ru.anutakay;

/**
 * Created by akaygorodova@issart.com on 22.03.2016.
 */
public class CheckroomImpl extends PlaceImpl implements Checkroom {

    public CheckroomImpl(Size size, int capacity) {
        super(size);
    }

    @Override
    public String put(Freezable freezable) {
        return null;
    }

    @Override
    public Freezable get(String key) {
        return null;
    }

    @Override
    public boolean hasFreeSpace() {
        return false;
    }

    @Override
    public int maxCapacity() {
        return 0;
    }

    @Override
    public int usedCapacity() {
        return 0;
    }
}
