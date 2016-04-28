package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.ClosedDoorException;
import ru.anutakay.fridge.Checkroom;
import ru.anutakay.fridge.Fridge;
import ru.anutakay.fridge.MultipleBox;

/**
 * Created by anutakay@gmail.com on 16.02.2016.
 */
public class CheckroomClosedTest extends AbstractTest{

    MultipleBox full;
    MultipleBox empty;

    String key;

    @BeforeMethod
    public void beforeMethod() throws BasicException {

        Checkroom tmpFull =  new Checkroom(medium, ONE);

        tmpFull.open();
        key = tmpFull.put(thing);
        tmpFull.close();

        empty = new Checkroom(medium, ONE);
        full = tmpFull;
    }

    @Test(expectedExceptions = ClosedDoorException.class)
    public void failPutClosed() throws BasicException {
        empty.put(thing);
    }

    @Test(expectedExceptions = ClosedDoorException.class)
    public void  failGetClosed() throws BasicException {
        full.get(key);
    }

    @Test
    public void successHasFreeSpace() {
        empty.hasFreeSpace();
        full.hasFreeSpace();
    }

    @Test
    public void successMaxCapacity() {
        empty.maxCapacity();
        full.maxCapacity();
    }

    @Test
    public void successUsedCapacity() {
        empty.usedCapacity();
        full.usedCapacity();
    }
}
