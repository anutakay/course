package ru.anutakay;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.EmptyException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.SizeException;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

/**
 * Created by anutakay@gmail.com on 25.02.2016.
 */
public abstract class AbstractBoxTest extends AbstractTest {

    BoxImpl empty;
    BoxImpl full;

    @BeforeMethod
    public abstract void  beforeMethod() throws BasicException;

    @Test
    public void successPut() throws BasicException {
        Freezable obj = new FreezableImpl(medium);

        empty.put(obj);

        assertTrue(empty.isFull());
    }

    @Test
    public void  successGet() throws BasicException {
        Freezable obj = full.get();

        assertNotNull(obj);
        assertFalse(full.isFull());
    }

    @Test
    public void successPutGet() throws BasicException {
        Freezable obj = new FreezableImpl(medium);

        empty.put(obj);
        Freezable res = empty.get();

        assertSame(res, obj);
    }

    @Test
    public void  successPutSmall() throws BasicException {
        Freezable obj = new FreezableImpl(small);

        empty.put(obj);
    }

    @Test
    public void successFits() {
        boolean res = empty.isFits(thing);
        assertTrue(res);

        res = full.isFits(thing);
        assertTrue(res);
    }

    @Test
    public void successFitsSmall() {
        Freezable obj = new FreezableImpl(small);

        boolean res = empty.isFits(obj);
        assertTrue(res);

        res = full.isFits(obj);
        assertTrue(res);
    }

    @Test
    public void successFitsBig() {
        Freezable obj = new FreezableImpl(big);

        boolean res = empty.isFits(obj);
        assertFalse(res);

        res = full.isFits(obj);
        assertFalse(res);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void failPutNullTest() throws BasicException {
        empty.put(null);
    }

    @Test(expectedExceptions = FullException.class)
    public void failPutInFull() throws BasicException {
        full.put(thing);
    }

    @Test(expectedExceptions = SizeException.class)
    public void failPutBig() throws BasicException {
        Freezable obj = new FreezableImpl(big);
        empty.put(obj);
    }

    @Test(expectedExceptions = EmptyException.class)
    public void failGetEmpty() throws BasicException {
        empty.get();
    }
}
