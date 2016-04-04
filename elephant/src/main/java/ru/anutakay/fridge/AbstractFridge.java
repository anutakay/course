package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.size.Size;
import ru.anutakay.exception.DoorStatusException;

/**
 * Created by akaygorodova@issart.com on 22.03.2016.
 */
public class AbstractFridge implements Place {

    Place place = null;



    public AbstractFridge(Size size) {
        if (size == null) {
            throw new NullPointerException();
        }
        place = new PlaceImpl(size);
    }

    @Override
    public String toString() {
        return place.toString();
    }

    @Override
    public boolean isFits(IAnimal object) {
        return place.isFits(object);
    }
}
