package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.ClosedDoorException;
import ru.anutakay.exception.DoorStatusException;
import ru.anutakay.exception.OpenDoorException;
import ru.anutakay.fridge.Fridge;
import ru.anutakay.fridge.Openable;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by anutakay@gmail.com on 16.02.2016.
 */
public abstract class AbstractDoorTest extends AbstractTest{

    private Openable opened;

    private Openable closed;

    public abstract Openable getOpened() throws DoorStatusException;

    public abstract Openable getClosed() throws BasicException;

    @BeforeMethod
    public final void  beforeMethod() throws BasicException {
        opened = getOpened();
        closed = getClosed();
    }

    @Test
    public void successOpen() throws DoorStatusException {
        closed.open();
        boolean res = closed.isOpened();
        assertTrue(res);
    }

    @Test
    public void  successClose() throws DoorStatusException {
        opened.close();
        boolean res = opened.isOpened();
        assertFalse(res);
    }

    @Test(expectedExceptions = OpenDoorException.class)
    public void failOpen() throws DoorStatusException {
        opened.open();
    }

    @Test(expectedExceptions = ClosedDoorException.class)
    public void failClose() throws DoorStatusException {
        closed.close();
    }
}
