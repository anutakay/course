package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.ClosedDoorException;
import ru.anutakay.exception.DoorStatusException;
import ru.anutakay.exception.OpenDoorException;
import ru.anutakay.fridge.IOpenable;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by anutakay@gmail.com on 16.02.2016.
 */
public abstract class AbstractDoorTest extends AbstractTest{

    private IOpenable opened;

    private IOpenable closed;

    public abstract IOpenable getOpened() throws DoorStatusException;

    public abstract IOpenable getClosed() throws BasicException;

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
