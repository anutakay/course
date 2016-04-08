package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import ru.anutakay.exception.DoorStatusException;
import ru.anutakay.fridge.Checkroom;
import ru.anutakay.fridge.SeparateCheckroom;

/**
 * Created by akaygorodova@issart.com on 08.04.2016.
 */
public class SeparateCheckroomMultipleTest extends AbstractCheckroomMultipleTest {

    @BeforeMethod
    public void beforeMethod() throws DoorStatusException {
        SeparateCheckroom tmp  = new SeparateCheckroom(medium, CAPACITY);
        tmp.open();
        checkroom = tmp;
    }

}
