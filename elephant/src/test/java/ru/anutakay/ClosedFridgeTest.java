package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.exception.*;
import ru.anutakay.fridge.BoxFridge;

/**
 * Created by anutakay@gmail.com on 16.02.2016.
 */
public class ClosedFridgeTest extends AbstractTest{

    BoxFridge full = null;
    BoxFridge empty = null;

    @BeforeMethod
    public void beforeMethod() throws BasicException {
        empty = new BoxFridge(medium);
        full = new BoxFridge(medium);

        full.open();
        full.put(thing);
        full.close();
    }

    @Test(expectedExceptions = ClosedDoorException.class)
    public void failPutClosed() throws BasicException {
        empty.put(thing);
    }

    @Test(expectedExceptions = ClosedDoorException.class)
    public void  failGetClosed() throws BasicException {
        full.get();
    }

    @Test(expectedExceptions = ClosedDoorException.class)
    public void  failsFull() throws BasicException {
        full.isFull();
    }
}
