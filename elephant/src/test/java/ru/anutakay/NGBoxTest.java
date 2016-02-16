package ru.anutakay;

import org.testng.annotations.*;
import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.EmptyException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.SizeException;

import static org.testng.Assert.*;

/**
 * Created by anutakay@gmail.com on 14.02.2016.
 */
public class NGBoxTest {

    Size smallSize;
    Size mediumSize;
    Size bigSize;

    Box emptyBox;
    Box fullBox;

    Freezable thing;

    @BeforeClass
    public void before() throws BasicException {
        smallSize = new Size(10, 10, 10, 10);
        mediumSize = new Size(20, 20, 20, 20);
        bigSize = new Size(100, 100, 100, 100);

        emptyBox = new BoxImpl(mediumSize);
        fullBox = new BoxImpl(mediumSize);

        thing = new FreezableImpl(mediumSize);
        fullBox.put(thing);
    }

    @BeforeMethod
    public void beforeFullBox() throws BasicException {
        if(!fullBox.isFull()) {
            fullBox.put(thing);
        }
    }

    @BeforeMethod
    public void beforeEmptyBox() throws BasicException {
        if(emptyBox.isFull()) {
            emptyBox.get();
        }
    }


    @Test
    public void successPut() throws BasicException {
        Freezable obj = new FreezableImpl(mediumSize);

        emptyBox.put(obj);

        assertTrue(emptyBox.isFull());
    }

    @Test
    public void  successGet() throws BasicException {
        Freezable obj = fullBox.get();

        assertNotNull(obj);
        assertFalse(fullBox.isFull());
    }

    @Test
    public void successPutGet() throws BasicException {
        Freezable obj = new FreezableImpl(mediumSize);

        emptyBox.put(obj);
        Freezable res = emptyBox.get();

        assertSame(res, obj);
    }

    @Test
    public void  successPutSmall() throws BasicException {
        Freezable obj = new FreezableImpl(smallSize);

        emptyBox.put(obj);
    }

    @Test
    public void successFits() {
        boolean res = emptyBox.isFits(thing);
        assertTrue(res);

        res = fullBox.isFits(thing);
        assertTrue(res);
    }

    @Test
    public void successFitsSmall() {
        Freezable obj = new FreezableImpl(smallSize);

        boolean res = emptyBox.isFits(obj);
        assertTrue(res);

        res = fullBox.isFits(obj);
        assertTrue(res);
    }

    @Test
    public void successFitsBig() {
        Freezable obj = new FreezableImpl(bigSize);

        boolean res = emptyBox.isFits(obj);
        assertFalse(res);

        res = fullBox.isFits(obj);
        assertFalse(res);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void failPutNullTest() throws BasicException {
        emptyBox.put(null);
    }

    @Test(expectedExceptions = FullException.class)
    public void failPutInFull() throws BasicException {
        fullBox.put(thing);
    }

    @Test(expectedExceptions = SizeException.class)
    public void failPutBig() throws BasicException {
        Freezable obj = new FreezableImpl(bigSize);
        emptyBox.put(obj);
    }

    @Test(expectedExceptions = EmptyException.class)
    public void failGetEmpty() throws BasicException {
        emptyBox.get();
    }
}
