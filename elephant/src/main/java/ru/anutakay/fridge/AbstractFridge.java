package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.size.Size;
import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.ClosedDoorException;
import ru.anutakay.exception.DoorStatusException;

/**
 * Created by akaygorodova@issart.com on 22.03.2016.
 */
public class AbstractFridge<A extends IAnimal> implements Place<A>, Openable {

    private Place place = null;

    private Door door = null;

    public AbstractFridge(Size size) {
        if (size == null) {
            throw new NullPointerException();
        }
        place = new PlaceImpl(size);
        door = new Door();
    }

    @Override
    public void open() throws DoorStatusException {
        door.open();
    }

    @Override
    public void close() throws DoorStatusException {
        door.close();
    }

    @Override
    public boolean isOpened() {
        return door.isOpened();
    }

    protected void checkDoor() throws BasicException {
        if (!isOpened()) {
            BasicException e = new ClosedDoorException();
            throw e;
        }
    }

    @Override
    public String toString() {
        return place.toString();
    }

    @Override
    public boolean isFits(A object) {
        return place.isFits(object);
    }

    @Override
    public Size getSize() {
        return this.place.getSize();
    }
}
