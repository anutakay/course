package ru.anutakay.fridge;

import ru.anutakay.animals.size.Size;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.ClosedDoorException;
import ru.anutakay.exception.DoorStatusException;
import ru.anutakay.exception.OpenDoorException;

/**
 * Created by akaygorodova@issart.com on 22.03.2016.
 */
public class AbstractFridge implements Place, Openable {

    private Size size;

    public boolean isOpened = false;

    public AbstractFridge(Size size) {
        if (size == null) {
            throw new NullPointerException();
        }
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
    public String toString() {
        return size.toString();
    }
}
