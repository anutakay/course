package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.Animal;
import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.EmptyException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.SizeException;
import ru.anutakay.fridge.Fridge;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

/**
 * Created by anutakay@gmail.com on 25.02.2016.
 */
public abstract class AbstractBoxTest extends AbstractTest {

    Fridge empty = null;
    Fridge full = null;

    @BeforeMethod
    public abstract void  beforeMethod() throws BasicException;

    @Test
    public void successPut() throws BasicException {
        IAnimal obj = new Animal(medium);

        empty.put(obj);

        assertTrue(empty.isFull());
    }

    @Test
    public void  successGet() throws BasicException {
        IAnimal obj = full.get();

        assertNotNull(obj);
        assertFalse(full.isFull());
    }

    @Test
    public void successPutGet() throws BasicException {
        IAnimal obj = new Animal(medium);

        empty.put(obj);
        IAnimal res = empty.get();

        assertSame(res, obj);
    }

    @Test
    public void  successPutSmall() throws BasicException {
        IAnimal obj = new Animal(small);

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
        IAnimal obj = new Animal(small);

        boolean res = empty.isFits(obj);
        assertTrue(res);

        res = full.isFits(obj);
        assertTrue(res);
    }

    @Test
    public void successFitsBig() {
        IAnimal obj = new Animal(big);

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
        IAnimal obj = new Animal(big);
        empty.put(obj);
    }

    @Test(expectedExceptions = EmptyException.class)
    public void failGetEmpty() throws BasicException {
        empty.get();
    }
}
