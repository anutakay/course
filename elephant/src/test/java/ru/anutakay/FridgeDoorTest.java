package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import ru.anutakay.exception.DoorStatusException;
import ru.anutakay.fridge.Fridge;

/**
 * Created by akaygorodova@issart.com on 08.04.2016.
 */
public class FridgeDoorTest extends AbstractDoorTest {

    @BeforeMethod
    public void before() throws DoorStatusException {
        opened = new Fridge(medium);
        opened.open();
        closed = new Fridge(medium);
        if(closed.isOpened()) {
            closed.close();
        }
    }
}
