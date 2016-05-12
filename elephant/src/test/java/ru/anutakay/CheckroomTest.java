package ru.anutakay;

import ru.anutakay.exception.*;
import ru.anutakay.fridge.IMultipleBox;
import ru.anutakay.fridge.SeparateCheckroom;

/**
 * Created by akaygorodova@issart.com on 23.03.2016.
 */
public class CheckroomTest extends AbstractCheckroomTest {

    @Override
    public IMultipleBox getCheckroom() throws BasicException {
        return new SeparateCheckroom(medium, ONE);
    }
}
