package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import ru.anutakay.exception.DoorStatusException;
import ru.anutakay.fridge.Checkroom;
import ru.anutakay.fridge.Fridge;
import ru.anutakay.fridge.SeparateCheckroom;

/**
 * Created by akaygorodova@issart.com on 08.04.2016.
 */
public class CheckroomDoorTest extends AbstractDoorTest {

    @BeforeMethod
    public void before() throws DoorStatusException {
        opened = new Checkroom(medium, ONE);
        opened.open();
        closed = new Fridge(medium);
        if(closed.isOpened()) {
            closed.close();
        }
    }

}
