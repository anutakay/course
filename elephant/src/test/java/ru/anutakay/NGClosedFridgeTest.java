package ru.anutakay;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.exception.*;

import static org.testng.Assert.*;

/**
 * Created by anutakay@gmail.com on 16.02.2016.
 */
public class NGClosedFridgeTest extends NGBoxTest {

    Fridge fullFridge;
    Fridge emptyFridge;

    @Override
    @BeforeClass
    public void before() throws BasicException {
        super.before();

        emptyBox = new Fridge(mediumSize);
        fullBox = new Fridge(mediumSize);
        thing = new FreezableImpl(mediumSize);

        fullFridge = (Fridge)fullBox;
        emptyFridge = (Fridge)emptyBox;

        fullFridge.open();
        fullFridge.put(thing);
        fullFridge.close();
    }

    @Override
    @BeforeMethod
    public void beforeFullBox() throws BasicException {
        fullFridge.open();
        if(!fullBox.isFull()) {
            fullBox.put(thing);
        }
        fullFridge.close();
    }

    @Override
    @BeforeMethod
    public void beforeEmptyBox() throws BasicException {
        emptyFridge.open();
        if(emptyBox.isFull()) {
            emptyBox.get();
        }
        emptyFridge.close();
    }

    @Override
    @Test(expectedExceptions = DoorStatusException.class)
    public void successPut() throws BasicException {
        emptyBox.put(thing);
    }

    @Override
    @Test(expectedExceptions = DoorStatusException.class)
    public void  successGet() throws BasicException {
        fullBox.get();
    }

    @Override
    @Test(enabled = false)
    public void successPutGet() throws BasicException {
    }

    @Override
    @Test(enabled = false)
    public void  successPutSmall() throws BasicException {
    }

    @Override
    @Test(enabled = false)
    public void failPutNullTest() throws BasicException {
    }

    @Override
    @Test(enabled = false)
    public void failPutInFull() throws BasicException {
    }

    @Test(enabled = false)
    public void failPutBig() throws BasicException {
        Freezable obj = new FreezableImpl(bigSize);
        emptyBox.put(obj);
    }

    @Test(enabled = false)
    public void failGetEmpty() throws BasicException {
    }

}
