package ru.anutakay;

import ru.anutakay.exception.EmptyException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.SizeException;
import ru.anutakay.exception.WeightException;

public class BoxImpl implements Box {

    protected Size size;

    protected Weight weight;

    private Freezable object;

    public BoxImpl(int length, int width, int height, int weight) {
        this.size = new Size(length, width, height);
        this.weight = new Weight(weight);
    }

    @Override
    public void put(Freezable object) {
        if (object == null) {
            throw new NullPointerException();
        }
        if (isFull()) {
            throw new FullException();
        }
        if (object.getSize().greaterThan(size)) {
            throw new SizeException();
        }
        if (object.getWeight().greaterThan(weight)) {
            throw new WeightException();
        }
        this.object = object;
    }

    @Override
    public Freezable get() {
        if (!isFull()) {
            throw new EmptyException();
        }
        Freezable result = object;
        this.object = null;
        return result;
    }

    @Override
    public boolean isFits(Freezable object) {
        Size tmpSize = object.getSize();
        Weight tmpWeight = object.getWeight();
        if (tmpSize.greaterThan(size)) {
            return false;
        }
        if (tmpWeight.greaterThan(weight)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isFull() {
        if (object == null) {
            return false;
        } else {
            return true;
        }
    }
}
