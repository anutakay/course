package ru.anutakay.fridge;

import ru.anutakay.exception.ClosedDoorException;
import ru.anutakay.exception.DoorStatusException;
import ru.anutakay.exception.OpenDoorException;

/**
 * Created by akaygorodova@issart.com on 04.04.2016.
 */
class Door implements IOpenable {

    public boolean isOpened = false;

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
}
