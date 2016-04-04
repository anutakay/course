package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.Animal;
import ru.anutakay.exception.EmptyException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.SizeException;
import ru.anutakay.fridge.Checkroom;
import ru.anutakay.fridge.MultiplePlaceBox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * Created by akaygorodova@issart.com on 23.03.2016.
 */
public class CheckroomMultipleTest extends AbstractTest {

    MultiplePlaceBox checkroom = null;

    static final int CAPACITY = 10;
    static final int HALF = 5;

    @BeforeMethod
    public void beforeMethod() {
        checkroom = new Checkroom(medium, CAPACITY);
    }

    @Test
    public void afterCreating() {
        assertNotNull(checkroom);
        assertTrue(checkroom.hasFreeSpace());
        assertEquals(checkroom.maxCapacity(), CAPACITY);
        assertEquals(checkroom.usedCapacity(), 0);
    }

    @Test
    public void successPut() throws FullException, SizeException {
        IAnimal obj = null;
        Set<String> keys = new HashSet<String>();
        String key = null;
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
    public void successPutAfterGet() throws FullException, SizeException, EmptyException {
        IAnimal obj = null;
        Set<String> keys = new HashSet<String>();
        String key = null;
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
    public void successPutAndGet() throws FullException, SizeException, EmptyException {
        IAnimal obj = null;
        Map<String, IAnimal> keys = new HashMap<String, IAnimal>();
        String key = null;
        for(int i = 0; i < CAPACITY; i++) {
            obj = new Animal(medium);
            key = checkroom.put(obj);
            keys.put(key, obj);
        }
        int num = keys.size();
        String[] arr = new String[keys.keySet().size()];
        keys.keySet().toArray(arr);
        for (int i = 0; i < num; i++) {
            key = arr[i];
            obj = checkroom.get(key);
            assertEquals(obj, keys.get(key));
        }
        assertTrue(checkroom.hasFreeSpace());
        assertEquals(checkroom.usedCapacity(), 0);
        assertEquals(checkroom.maxCapacity(), CAPACITY);
    }

    @Test
    public void successPutHalf() throws FullException, SizeException {
        IAnimal obj = null;
        Set<String> keys = new HashSet<String>();
        String key = null;
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
    public void failPutFull() throws FullException, SizeException {
        IAnimal obj = null;
        Set<String> keys = new HashSet<String>();
        String key = null;
        for(int i = 0; i < CAPACITY + 1; i++) {
            obj = new Animal(medium);
            key = checkroom.put(obj);
            keys.add(key);
        }
    }
}
