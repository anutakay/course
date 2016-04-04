package ru.anutakay.fridge;

import ru.anutakay.Named;
import ru.anutakay.animals.size.Size;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.*;

public class Fridge extends Box implements Named {

    public Fridge(Size size) {
        super(size);
    }

    @Override
    public boolean isFull() throws BasicException {
        if (!isOpened()) {
            BasicException e = new ClosedDoorException();
            throw e;
        }
        return super.isFull();
    }

    @Override
    public void put(IAnimal object) throws BasicException {
        if (!isOpened()) {
            BasicException e = new ClosedDoorException();
            throw e;
        }
        super.put(object);
    }

    @Override
    public IAnimal get() throws BasicException {
        if (!isOpened()) {
            BasicException e = new ClosedDoorException();
            throw e;
        }
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
