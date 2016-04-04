package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.size.Size;
import ru.anutakay.exception.*;

/**
 * Created by akaygorodova@issart.com on 04.04.2016.
 */
public class CheckroomFridge extends Checkroom {

    public CheckroomFridge(Size size, int capacity) {
        super(size, capacity);
    }

    @Override
    public String put(IAnimal animal) throws BasicException {
        checkDoor();
        return  super.put(animal);
    }

    @Override
    public IAnimal get(String key) throws BasicException {
        checkDoor();
        return super.get(key);
    }

    @Override
    public boolean hasFreeSpace() throws BasicException {
        checkDoor();
        return super.hasFreeSpace();
    }
}
