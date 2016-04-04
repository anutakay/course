package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.Animal;
import ru.anutakay.exception.EmptyException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.SizeException;
import ru.anutakay.exception.UncompatibleValueException;
import ru.anutakay.fridge.Checkroom;
import ru.anutakay.fridge.MultiplePlaceBox;

import java.util.UUID;

import static org.testng.Assert.*;

/**
 * Created by akaygorodova@issart.com on 23.03.2016.
 */
public class CheckroomTest extends AbstractTest {

    MultiplePlaceBox checkroom;

    static final int ONE = 1;

    @BeforeMethod
    public void beforeMethod() {
        checkroom = new Checkroom(medium, ONE);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void failCreatingNullSize() {
        MultiplePlaceBox cr = new Checkroom(null, ONE);
    }

    @Test(expectedExceptions = UncompatibleValueException.class)
    public void failCreatingBadCapacity() {
        MultiplePlaceBox cr = new Checkroom(medium, 0);
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
        IAnimal res = checkroom.get(key);
        assertSame(res, thing);
        assertEquals(checkroom.usedCapacity(), 0);
        assertTrue(checkroom.hasFreeSpace());
    }

    @Test(expectedExceptions = SizeException.class)
    public void failPutBigSize() throws FullException, SizeException {
        IAnimal obj = new Animal(big);
        String res = checkroom.put(obj);
        assertNotNull(res);
        assertEquals(checkroom.usedCapacity(), 1);
        assertFalse(checkroom.hasFreeSpace());
    }

    @Test(expectedExceptions = FullException.class)
    public void failPutFull() throws FullException, SizeException {
        IAnimal obj = new Animal(medium);
        IAnimal obj2 = new Animal(medium);
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
