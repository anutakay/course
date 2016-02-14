package ru.anutakay;

import org.junit.Test;
import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.DoorStatusException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by anya on 27.12.15.
 */
public class FridgeTest {

    @Test
    public void openCloseTest() throws DoorStatusException {
        Fridge fridge = new Fridge(new Size(2, 2, 2, new Weight(2)));
        fridge.open();
        assertTrue(fridge.isOpened());
        fridge.close();
        assertFalse(fridge.isOpened());
    }

    @Test(expected = DoorStatusException.class)
    public void noCloseTest() throws DoorStatusException {
        Fridge fridge = new Fridge(new Size(2, 2, 2, new Weight(2)));
        fridge.close();
    }

    @Test(expected = DoorStatusException.class)
    public void noClose1Test() throws DoorStatusException {
        Fridge fridge1 = new Fridge(new Size(2, 2, 2, new Weight(2)));
        fridge1.open();
        fridge1.close();
        fridge1.close();
    }

    @Test(expected = DoorStatusException.class)
    public void noOpenTest() throws DoorStatusException {
        Fridge fridge = new Fridge(new Size(2, 2, 2, new Weight(2)));
        fridge.open();
        fridge.open();
    }

    @Test(expected = DoorStatusException.class)
    public void noPutDoor() throws BasicException {
        Fridge fridge = new Fridge(new Size(2, 2, 2, new Weight(2)));
        FreezableImpl elephant = new FreezableImpl(new Size(2, 2, 2, new Weight(2)));
        //fridge.open();
        fridge.put(elephant);
    }
}
