package ru.anutakay;

import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.DoorStatusException;
import ru.anutakay.fridge.Checkroom;
import ru.anutakay.fridge.Fridge;
import ru.anutakay.fridge.Openable;

/**
 * Created by akaygorodova@issart.com on 08.04.2016.
 */
public class FridgeDoorTest extends AbstractDoorTest {

    @Override
    public Openable getOpened() throws DoorStatusException {
        Openable tmp = new Checkroom(medium, ONE);
        tmp.open();
        return tmp;
    }

    @Override
    public Openable getClosed() throws BasicException {
        return new Fridge(medium);
    }
}
