package ru.anutakay;

import ru.anutakay.exception.BasicException;
import ru.anutakay.fridge.MultipleBox;
import ru.anutakay.fridge.SeparateCheckroom;

/**
 * Created by akaygorodova@issart.com on 23.03.2016.
 */
public class SeparateCheckroomTest extends AbstractCheckroomTest {

    @Override
    public MultipleBox getCheckroom() throws BasicException {
        return new SeparateCheckroom(medium, ONE);
    }
}
