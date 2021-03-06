package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.animals.Animal;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.*;
import ru.anutakay.fridge.Checkroom;
import ru.anutakay.fridge.IMultipleBox;

import java.util.UUID;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by akaygorodova@issart.com on 07.04.2016.
 */
public abstract class AbstractCheckroomTest extends AbstractTest {

    private IMultipleBox checkroom;

    public abstract IMultipleBox getCheckroom() throws BasicException;

    @BeforeMethod
    public final void  beforeMethod() throws BasicException {
        checkroom = getCheckroom();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void failCreatingNullSize() {
        IMultipleBox cr = new Checkroom(null, ONE);
    }

    @Test(expectedExceptions = UncompatibleValueException.class)
    public void failCreatingBadCapacity() {
        IMultipleBox cr = new Checkroom(medium, 0);
    }

    @Test
    public void afterCreating() throws BasicException {
        assertNotNull(checkroom);
        assertTrue(checkroom.hasFreeSpace());
        assertEquals(checkroom.maxCapacity(), ONE);
        assertEquals(checkroom.usedCapacity(), 0);
    }

    @Test
    public void successPut() throws BasicException {
        String res = checkroom.put(thing);
        assertNotNull(res);
        assertEquals(checkroom.usedCapacity(), 1);
        assertFalse(checkroom.hasFreeSpace());
    }

    @Test
    public void successPutAndGet() throws BasicException {
        String key = checkroom.put(thing);
        IAnimal res = checkroom.get(key);
        assertSame(res, thing);
        assertEquals(checkroom.usedCapacity(), 0);
        assertTrue(checkroom.hasFreeSpace());
    }

    @Test(expectedExceptions = SizeException.class)
    public void failPutBigSize() throws BasicException {
        IAnimal obj = new Animal(big);
        String res = checkroom.put(obj);
        assertNotNull(res);
        assertEquals(checkroom.usedCapacity(), 1);
        assertFalse(checkroom.hasFreeSpace());
    }

    @Test(expectedExceptions = FullException.class)
    public void failPutFull() throws BasicException {
        IAnimal obj = new Animal(medium);
        IAnimal obj2 = new Animal(medium);
        checkroom.put(obj);
        checkroom.put(obj2);
    }

    @Test(expectedExceptions = EmptyException.class)
    public void  failGetEmpty() throws BasicException {
        String key = checkroom.put(thing);
        checkroom.get(key);
        checkroom.get(key);
    }

    @Test(expectedExceptions = UncompatibleValueException.class)
    public void  failGetBadKey() throws BasicException {
        checkroom.put(thing);
        String key = UUID.randomUUID().toString();
        checkroom.get(key);
    }

    @Test
    public void successKeyReusing() throws BasicException {
        IAnimal obj1 = new Animal(medium);
        IAnimal obj2 = new Animal(medium);
        String key1 = checkroom.put(obj1);
        checkroom.get(key1);
        String key2 = checkroom.put(obj2);
        IAnimal res = checkroom.get(key2);
        assertEquals(key1, key2);
        assertEquals(res, obj2);
    }
}
