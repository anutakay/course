package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.exception.DoorStatusException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by anutakay@gmail.com on 16.02.2016.
 */
public class DoorFridgeTest {

    Fridge open;
    Fridge closed;

    @BeforeMethod
    public void before() throws DoorStatusException {
        Size size = new Size(10, 10, 10, 10);
        open = new Fridge(size);
        open.open();
        closed = new Fridge(size);
    }

    @BeforeMethod
    public void beforeClosed() throws DoorStatusException {
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

    @Test(expectedExceptions = DoorStatusException.class)
    public void failOpen() throws DoorStatusException {
        open.open();
    }

    @Test(expectedExceptions = DoorStatusException.class)
    public void failClose() throws DoorStatusException {
        closed.close();
    }
}
