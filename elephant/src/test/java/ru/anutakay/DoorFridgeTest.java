package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.exception.ClosedDoorException;
import ru.anutakay.exception.DoorStatusException;
import ru.anutakay.exception.OpenDoorException;
import ru.anutakay.fridge.Fridge;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by anutakay@gmail.com on 16.02.2016.
 */
public class DoorFridgeTest extends AbstractTest{

    Fridge open;
    Fridge closed;

    @BeforeMethod
    public void before() throws DoorStatusException {
        open = new Fridge(medium);
        open.open();
        closed = new Fridge(medium);
        if(closed.isOpened()) {
            closed.close();
        }
    }

    @Test
    public void successOpen() throws DoorStatusException {
        closed.open();
        boolean res = closed.isOpened();
        assertTrue(res);
    }

    @Test
    public void  successClose() throws DoorStatusException {
        open.close();
        boolean res = open.isOpened();
        assertFalse(res);
    }

    @Test(expectedExceptions = OpenDoorException.class)
    public void failOpen() throws DoorStatusException {
        open.open();
    }

    @Test(expectedExceptions = ClosedDoorException.class)
    public void failClose() throws DoorStatusException {
        closed.close();
    }
}
