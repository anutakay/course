package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.size.Size;

/**
 * Created by akaygorodova@issart.com on 04.04.2016.
 */
class PlaceImpl implements Place {

    private Size size;

    public PlaceImpl(Size size) {
        this.size = size;
    }

    @Override
    public final boolean isFits(IAnimal object) {
        Size tmpSize = object.getSize();
        if (tmpSize.greaterThan(size)) {
            return false;
        }
        return true;
    }
}
