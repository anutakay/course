package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.size.Size;
import ru.anutakay.exception.*;

/**
 * Created by akaygorodova@issart.com on 04.04.2016.
 */
public class CheckroomFridge extends Checkroom implements Openable {

    Door door = null;

    public CheckroomFridge(Size size, int capacity) {
        super(size, capacity);
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

    @Override
    public String put(IAnimal animal) throws BasicException {
        door.checkDoor();
        return  super.put(animal);
    }

    @Override
    public IAnimal get(String key) throws BasicException {
        door.checkDoor();
        return super.get(key);
    }

    @Override
    public boolean hasFreeSpace() throws BasicException {
        door.checkDoor();
        return super.hasFreeSpace();
    }
}
