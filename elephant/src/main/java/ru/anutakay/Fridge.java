package ru.anutakay;

import ru.anutakay.exception.*;

public class Fridge extends BoxImpl implements Openable, Named {

    public boolean isOpened = false;

    public Fridge(Size size) {
        super(size);
    }

    @Override
    public void open() throws DoorStatusException {
        if (isOpened()) {
            throw new OpenDoorException();
        }
        isOpened = true;
    }

    @Override
    public void close() throws DoorStatusException {
        if (!isOpened()) {
            throw new ClosedDoorException();
        }
        isOpened = false;
    }

    @Override
    public boolean isOpened() {
        return isOpened;
    }

    @Override
    public void put(Freezable object) throws BasicException {
        if (!isOpened()) {
            BasicException e = new ClosedDoorException();
            throw e;
        }
        super.put(object);
    }

    @Override
    public Freezable get() throws BasicException {
        if (!isOpened()) {
            BasicException e = new ClosedDoorException();
            throw e;
        }
       return super.get();
    }

    @Override
    public boolean isFull() throws BasicException {
        if (!isOpened()) {
            BasicException e = new ClosedDoorException();
            throw e;
        }
        return super.isFull();
    }

    @Override
    public String toString() {
        return this.getName() + ": " + size.toString();
    }

    @Override
    public String getName() {
        return "ХОЛОДИЛЬНИК";
    }
}
