package ru.anutakay;

import ru.anutakay.exception.DoorStatusException;

public class Fridge extends BoxImpl implements Openable, Named {

    public boolean isOpened = false;

    public Fridge(int length, int width, int height, int weight) {
        super(length, width, height, weight);
    }

    @Override
    public void open() {
        if (isOpened()) {
            throw new DoorStatusException();
        }
        isOpened = true;
    }

    @Override
    public void close() {
        if (!isOpened()) {
            throw new DoorStatusException();
        }
        isOpened = false;
    }

    @Override
    public boolean isOpened() {
        return isOpened;
    }

    @Override
    public void put(Freezable object) {
        if (!isOpened()) {
            throw new DoorStatusException();
        }
        super.put(object);
    }

    @Override
    public boolean isFull() {
        if (!isOpened()) {
            throw new DoorStatusException();
        }
        return super.isFull();
    }

    @Override
    public String toString() {
        return this.getName() + ": " + size.toString() + ", " + weight.toString();
    }

    @Override
    public String getName() {
        return "ХОЛОДИЛЬНИК";
    }
}
