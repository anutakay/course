package ru.anutakay.fridge;

import ru.anutakay.Named;
import ru.anutakay.animals.size.Size;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.*;

public class Fridge<A extends IAnimal> extends AbstractFridge<A> implements SingleBox<A>, Named {

    private A object;

    public Fridge(Size size) {
        super(size);
    }

    @Override
    public void put(A object) throws BasicException {
        checkDoor();
        if (object == null) {
            throw new NullPointerException();
        }
        if (isFull()) {
            throw new FullException();
        }
        if (!this.isFits(object)) {
            throw new SizeException();
        }
        this.object = object;
    }

    @Override
    public A get() throws BasicException {
        checkDoor();
        if (!isFull()) {
            BasicException e = new EmptyException();
            throw e;
        }
        A result = object;
        this.object = null;
        return result;
    }


    @Override
    public boolean isFull() throws BasicException {
        checkDoor();
        if (object == null) {
            return false;
        } else {
            return true;
        }
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
