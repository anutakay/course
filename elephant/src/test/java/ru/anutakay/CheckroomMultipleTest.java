package ru.anutakay;

import ru.anutakay.exception.BasicException;
import ru.anutakay.fridge.Checkroom;
import ru.anutakay.fridge.IMultipleBox;

/**
 * Created by akaygorodova@issart.com on 08.04.2016.
 */
public class CheckroomMultipleTest extends AbstractCheckroomMultipleTest {

    @Override
    public IMultipleBox getCheckroom() throws BasicException {
        Checkroom tmp  = new Checkroom(medium, CAPACITY);
        tmp.open();
        return tmp;
    }
}
