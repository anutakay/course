package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import ru.anutakay.exception.DoorStatusException;
import ru.anutakay.fridge.Checkroom;
import ru.anutakay.fridge.SeparateCheckroom;

/**
 * Created by akaygorodova@issart.com on 23.03.2016.
 */
public class SeparateCheckroomTest extends AbstractCheckroomTest {

    @BeforeMethod
    public void beforeMethod() throws DoorStatusException {
        SeparateCheckroom tmp = new SeparateCheckroom(medium, ONE);
        checkroom = tmp;
    }
}
