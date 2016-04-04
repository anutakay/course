package ru.anutakay.fridge;

import ru.anutakay.Named;
import ru.anutakay.animals.size.Size;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.*;

public class BoxFridge extends Box implements Named, Openable {

    public BoxFridge(Size size) {
        super(size);
    }

    @Override
    public boolean isFull() throws BasicException {
        checkDoor();
        return super.isFull();
    }

    @Override
    public void put(IAnimal object) throws BasicException {
        checkDoor();
        super.put(object);
    }

    @Override
    public IAnimal get() throws BasicException {
        checkDoor();
        return super.get();
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
