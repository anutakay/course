package ru.anutakay;

import org.junit.Test;
import ru.anutakay.exception.DoorStatusException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by anya on 27.12.15.
 */
public class FridgeTest {

    @Test
    public void openCloseTest() {
        Fridge fridge = new Fridge(2, 2, 2, 2);
        fridge.open();
        assertTrue(fridge.isOpened());
        fridge.close();
        assertFalse(fridge.isOpened());
    }

    @Test(expected = DoorStatusException.class)
    public void noCloseTest() {
        Fridge fridge = new Fridge(2, 2, 2, 2);
        fridge.close();
    }

    @Test(expected = DoorStatusException.class)
    public void noClose1Test() {
        Fridge fridge1 = new Fridge(2, 2, 2, 2);
        fridge1.open();
        fridge1.close();
        fridge1.close();
    }

    @Test(expected = DoorStatusException.class)
    public void noOpenTest() {
        Fridge fridge = new Fridge(2, 2, 2, 2);
        fridge.open();
        fridge.open();
    }

    @Test(expected = DoorStatusException.class)
    public void noPutDoor() {
        Fridge fridge = new Fridge(2, 2, 2, 2);
        FreezableImpl elephant = new FreezableImpl(new Size(2, 2, 2), new Weight(2));
        //fridge.open();
        fridge.put(elephant);
    }
}
