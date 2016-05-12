package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.size.Size;

/**
 * Created by akaygorodova@issart.com on 04.04.2016.
 */
class Place implements IPlace {

    private Size size;

    public Place(Size size) {
        this.size = size;
    }

    @Override
    public final boolean isFits(IAnimal object) {
       return !object.getSize().greaterThan(size);
    }

    @Override
    public Size getSize() {
        return size;
    }
}
