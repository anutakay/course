package ru.anutakay;

/**
 * Created by akaygorodova@issart.com on 22.03.2016.
 */
public class PlaceImpl implements Place {

    protected Size size;

    public PlaceImpl(Size size) {
        this.size = size;
    }

    @Override
    public boolean isFits(Freezable object) {
        Size tmpSize = object.getSize();
        if (tmpSize.greaterThan(size)) {
            return false;
        }
        return true;
    }
}
