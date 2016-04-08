package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import ru.anutakay.exception.DoorStatusException;
import ru.anutakay.fridge.Checkroom;

/**
 * Created by akaygorodova@issart.com on 08.04.2016.
 */
public class CheckroomMultipleTest extends AbstractCheckroomMultipleTest {

    @BeforeMethod
    public void beforeMethod() throws DoorStatusException {
        Checkroom tmp  = new Checkroom(medium, CAPACITY);
        tmp.open();
        checkroom = tmp;
    }

}
