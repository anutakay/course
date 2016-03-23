package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.exception.EmptyException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.SizeException;
import ru.anutakay.exception.UncompatibleValueException;

import java.util.UUID;

import static org.testng.Assert.*;

/**
 * Created by akaygorodova@issart.com on 23.03.2016.
 */
public class CheckroomTest extends AbstractTest {

    Checkroom checkroom;

    static final int ONE = 1;

    @BeforeMethod
    public void beforeMethod() {
        checkroom = new CheckroomImpl(medium, ONE);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void failCreatingNullSize() {
        Checkroom cr = new CheckroomImpl(null, ONE);
    }

    @Test(expectedExceptions = UncompatibleValueException.class)
    public void failCreatingBadCapacity() {
        Checkroom cr = new CheckroomImpl(medium, 0);
    }

    @Test
    public void afterCreating() {
        assertNotNull(checkroom);
        assertTrue(checkroom.hasFreeSpace());
        assertEquals(checkroom.maxCapacity(), ONE);
        assertEquals(checkroom.usedCapacity(), 0);
    }

    @Test
    public void successPut() throws FullException, SizeException {
        String res = checkroom.put(thing);
        assertNotNull(res);
        assertEquals(checkroom.usedCapacity(), 1);
        assertFalse(checkroom.hasFreeSpace());
    }

    @Test
    public void successPutAndGet() throws FullException, SizeException, EmptyException {
        String key = checkroom.put(thing);
        Freezable res = checkroom.get(key);
        assertSame(res, thing);
        assertEquals(checkroom.usedCapacity(), 0);
        assertTrue(checkroom.hasFreeSpace());
    }

    @Test(expectedExceptions = SizeException.class)
    public void failPutBigSize() throws FullException, SizeException {
        Freezable obj = new FreezableImpl(big);
        String res = checkroom.put(obj);
        assertNotNull(res);
        assertEquals(checkroom.usedCapacity(), 1);
        assertFalse(checkroom.hasFreeSpace());
    }

    @Test(expectedExceptions = FullException.class)
    public void failPutFull() throws FullException, SizeException {
        Freezable obj = new FreezableImpl(medium);
        Freezable obj2 = new FreezableImpl(medium);
        checkroom.put(obj);
        checkroom.put(obj2);
    }

    @Test(expectedExceptions = EmptyException.class)
    public void  failGetEmpty() throws FullException, SizeException, EmptyException {
        String key = checkroom.put(thing);
        checkroom.get(key);
        checkroom.get(key);
    }

    @Test(expectedExceptions = UncompatibleValueException.class)
    public void  failGetBadKey() throws FullException, SizeException, EmptyException {
        checkroom.put(thing);
        String key = UUID.randomUUID().toString();
        checkroom.get(key);
    }

    @Test
    public void successKeyReusing() throws FullException, SizeException, EmptyException {
        Freezable obj1 = new FreezableImpl(medium);
        Freezable obj2 = new FreezableImpl(medium);
        String key1 = checkroom.put(obj1);
        checkroom.get(key1);
        String key2 = checkroom.put(obj2);
        Freezable res = checkroom.get(key2);
        assertEquals(key1, key2);
        assertEquals(res, obj2);
    }
}
