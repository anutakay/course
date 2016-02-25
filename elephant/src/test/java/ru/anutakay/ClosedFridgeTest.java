package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.exception.*;

/**
 * Created by anutakay@gmail.com on 16.02.2016.
 */
public class ClosedFridgeTest extends AbstractBoxTest {

    Fridge full;
    Fridge empty;

    @BeforeMethod
    public void beforeMethod() throws BasicException {
        empty = new Fridge(medium);
        full = new Fridge(medium);

        full.open();
        full.put(thing);
        full.close();
    }

    @Test(expectedExceptions = DoorStatusException.class)
    public void failPutClosed() throws BasicException {
        empty.put(thing);
    }

    @Test(expectedExceptions = DoorStatusException.class)
    public void  failGetClosed() throws BasicException {
        full.get();
    }

    @Test(expectedExceptions = DoorStatusException.class)
    public void  failsFull() throws BasicException {
        full.isFull();
    }
}
