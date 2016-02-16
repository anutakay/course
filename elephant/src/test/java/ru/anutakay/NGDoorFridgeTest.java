package ru.anutakay;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.exception.DoorStatusException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by anutakay@gmail.com on 16.02.2016.
 */
public class NGDoorFridgeTest {

    Fridge openFridge;
    Fridge closedFridge;

    @BeforeClass
    public void before() {
        Size size = new Size(10, 10, 10, 10);
        openFridge = new Fridge(size);
        closedFridge = new Fridge(size);
    }

    @BeforeMethod
    public void beforeOpen() throws DoorStatusException {
        if(!openFridge.isOpened()) {
            openFridge.open();
        }
    }

    @BeforeMethod
    public void beforeClosed() throws DoorStatusException {
        if(closedFridge.isOpened()) {
          closedFridge.close();
        }
    }

    @Test
    public void successOpen() throws DoorStatusException {
        closedFridge.open();
        boolean res = closedFridge.isOpened();
        assertTrue(res);
    }

    @Test
    public void  successClose() throws DoorStatusException {
        openFridge.close();
        boolean res = openFridge.isOpened();
        assertFalse(res);
    }

    @Test(expectedExceptions = DoorStatusException.class)
    public void failOpen() throws DoorStatusException {
        openFridge.open();
    }

    @Test(expectedExceptions = DoorStatusException.class)
    public void failClose() throws DoorStatusException {
        closedFridge.close();
    }
}
