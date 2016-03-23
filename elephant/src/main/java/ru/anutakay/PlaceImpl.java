package ru.anutakay;

/**
 * Created by akaygorodova@issart.com on 22.03.2016.
 */
public class PlaceImpl implements Place {

    private Size size;

    public PlaceImpl(Size size) {
        if(size == null) {
            throw new NullPointerException();
        }
        this.size = size;
    }

    @Override
    public final boolean isFits(Freezable object) {
        Size tmpSize = object.getSize();
        if (tmpSize.greaterThan(size)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return size.toString();
    }
}
