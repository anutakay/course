package ru.anutakay;

import ru.anutakay.exception.*;

public class BoxImpl implements Box {

    protected Size size;

    private Freezable object;

    public BoxImpl(Size size) {
        this.size = size;
    }

    @Override
    public void put(Freezable object) throws BasicException {
        if (object == null) {
            throw new NullPointerException();
        }
        if (isFull()) {
            throw new FullException();
        }
        if (object.getSize().greaterThan(size)) {
            throw new SizeException();
        }
        this.object = object;
    }

    @Override
    public Freezable get() throws BasicException {
        if (!isFull()) {
            BasicException e = new EmptyException();
            throw e;
        }
        Freezable result = object;
        this.object = null;
        return result;
    }

    @Override
    public boolean isFits(Freezable object) {
        Size tmpSize = object.getSize();
        if (tmpSize.greaterThan(size)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isFull() throws BasicException {
        if (object == null) {
            return false;
        } else {
            return true;
        }
    }
}
