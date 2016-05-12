package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.Animal;
import ru.anutakay.exception.*;
import ru.anutakay.fridge.IMultipleBox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * Created by akaygorodova@issart.com on 23.03.2016.
 */
public abstract class AbstractCheckroomMultipleTest extends AbstractTest {

    private IMultipleBox checkroom;

    public abstract IMultipleBox getCheckroom() throws BasicException;

    @BeforeMethod
    public final void  beforeMethod() throws BasicException {
        checkroom = getCheckroom();
    }

    @Test
    public void afterCreating() throws BasicException {
        assertNotNull(checkroom);
        assertTrue(checkroom.hasFreeSpace());
        assertEquals(checkroom.maxCapacity(), CAPACITY);
        assertEquals(checkroom.usedCapacity(), 0);
    }

    @Test
    public void successPut() throws BasicException {
        IAnimal obj;
        Set<String> keys = new HashSet<String>();
        String key;
        for(int i = 0; i < CAPACITY; i++) {
            assertTrue(checkroom.hasFreeSpace());
            obj = new Animal(medium);
            key = checkroom.put(obj);
            keys.add(key);
        }
        assertEquals(keys.size(), CAPACITY);
        assertFalse(checkroom.hasFreeSpace());
        assertEquals(checkroom.maxCapacity(), CAPACITY);
    }

    @Test
    public void successPutAfterGet() throws BasicException {
        IAnimal obj;
        Set<String> keys = new HashSet<String>();
        String key;
        key = checkroom.put(thing);
        keys.add(key);
        checkroom.get(key);
        for(int i = 0; i < CAPACITY; i++) {
            assertTrue(checkroom.hasFreeSpace());
            obj = new Animal(medium);
            key = checkroom.put(obj);
            keys.add(key);
        }
        assertEquals(keys.size(), CAPACITY);
        assertFalse(checkroom.hasFreeSpace());
        assertEquals(checkroom.maxCapacity(), CAPACITY);
    }

    @Test
    public void successPutAndGet() throws BasicException {
        IAnimal obj;
        Map<String, IAnimal> keys = new HashMap<String, IAnimal>();
        String key;
        for(int i = 0; i < CAPACITY; i++) {
            obj = new Animal(medium);
            key = checkroom.put(obj);
            keys.put(key, obj);
        }
        for (String i: keys.keySet()) {
            obj = checkroom.get(i);
            assertEquals(obj, keys.get(i));
        }
        assertTrue(checkroom.hasFreeSpace());
        assertEquals(checkroom.usedCapacity(), 0);
        assertEquals(checkroom.maxCapacity(), CAPACITY);
    }

    @Test
    public void successPutHalf() throws BasicException {
        IAnimal obj;
        Set<String> keys = new HashSet<String>();
        String key;
        for(int i = 0; i < HALF; i++) {
            obj = new Animal(medium);
            key = checkroom.put(obj);
            keys.add(key);
        }
        assertEquals(keys.size(), HALF);
        assertEquals(checkroom.usedCapacity(), HALF);
        assertTrue(checkroom.hasFreeSpace());
        assertEquals(checkroom.maxCapacity(), CAPACITY);
    }

    @Test(expectedExceptions = FullException.class)
    public void failPutFull() throws BasicException {
        IAnimal obj;
        Set<String> keys = new HashSet<String>();
        String key;
        for(int i = 0; i < CAPACITY + 1; i++) {
            obj = new Animal(medium);
            key = checkroom.put(obj);
            keys.add(key);
        }
    }
}
