package ru.anutakay.fridge;

import ru.anutakay.animals.size.Size;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.*;

public class Box extends AbstractFridge implements OnePlaceBox {

    private IAnimal object;

    public Box(Size size) {
        super(size);
    }

    @Override
    public void put(IAnimal object) throws BasicException {
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
    public IAnimal get() throws BasicException {
        if (!isFull()) {
            BasicException e = new EmptyException();
            throw e;
        }
        IAnimal result = object;
        this.object = null;
        return result;
    }


    @Override
    public boolean isFull() throws BasicException {
        if (object == null) {
            return false;
        } else {
            return true;
        }
    }
}
