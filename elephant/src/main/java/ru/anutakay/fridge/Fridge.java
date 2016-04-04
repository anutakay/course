package ru.anutakay.fridge;

import ru.anutakay.Named;
import ru.anutakay.animals.size.Size;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.*;

public class Fridge extends Box implements Named, Openable {

    Door door = null;

    public Fridge(Size size) {
        super(size);
        door = new Door();
    }

    @Override
    public boolean isFull() throws BasicException {
        door.checkDoor();
        return super.isFull();
    }

    @Override
    public void put(IAnimal object) throws BasicException {
        door.checkDoor();
        super.put(object);
    }

    @Override
    public IAnimal get() throws BasicException {
        door.checkDoor();
        return super.get();
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
    public String toString() {
        return this.getName() + ": " + super.toString();
    }

    @Override
    public String getName() {
        return "ХОЛОДИЛЬНИК";
    }
}
