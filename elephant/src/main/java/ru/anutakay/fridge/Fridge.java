package ru.anutakay.fridge;

import ru.anutakay.INamed;
import ru.anutakay.animals.size.Size;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.*;

public class Fridge<A extends IAnimal> extends AbstractFridge<A> implements ISingleBox<A>, INamed {

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
            throw new EmptyException();
        }
        A result = object;
        this.object = null;
        return result;
    }


    @Override
    public boolean isFull() throws BasicException {
        checkDoor();
        return object != null;
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
