package ru.anutakay;

import ru.anutakay.exception.BasicException;
import ru.anutakay.fridge.IMultipleBox;
import ru.anutakay.fridge.SeparateCheckroom;

/**
 * Created by akaygorodova@issart.com on 08.04.2016.
 */
public class SeparateCheckroomMultipleTest extends AbstractCheckroomMultipleTest {

    @Override
    public IMultipleBox getCheckroom() throws BasicException {
        return new SeparateCheckroom(medium, CAPACITY);
    }
}
