package ru.anutakay;

import org.junit.Test;
import ru.anutakay.exception.*;

import static org.junit.Assert.*;

/**
 * Created by anya on 27.12.15.
 */
public class BoxTest {

    @Test
    public void cteateTest() {
        Box box = new BoxImpl(2, 2, 2, 2);
        assertNotNull(box);
    }

    @Test(expected = UncompatibleValueException.class)
    public void createNullSizeTest() {
        new BoxImpl(0, 0, 0, 2);
    }

    @Test(expected = UncompatibleValueException.class)
    public void createNullWeightTest() {
        new BoxImpl(2, 2, 2, 0);
    }

    @Test(expected = UncompatibleValueException.class)
    public void createNullTest() {
        new BoxImpl(0, 2, 2, 0);
    }

    @Test
    public void putGetTest() throws BasicException {
        Box box = new BoxImpl(2, 2, 2, 2);
        Freezable elephant = new FreezableImpl(new Size(2, 2, 2), new Weight(2));
        box.put(elephant);
        Freezable result = box.get();
        assertSame(elephant, result);
    }

    @Test(expected = SizeException.class)
    public void bigSizeTest() throws BasicException {
        Box box = new BoxImpl(2, 2, 2, 2);
        Freezable elephant = new FreezableImpl(new Size(3, 3, 3), new Weight(2));
        box.put(elephant);
    }

    @Test(expected = WeightException.class)
    public void bigWeightTest() throws BasicException {
        Box box = new BoxImpl(2, 2, 2, 2);
        Freezable elephant = new FreezableImpl(new Size(2, 2, 2), new Weight(3));
        box.put(elephant);
    }

    @Test
    public void fullTest() throws BasicException {
        Box box = new BoxImpl(2, 2, 2, 2);
        Freezable elephant = new FreezableImpl(new Size(2, 2, 2), new Weight(2));
        assertFalse(box.isFull());
        box.put(elephant);
        assertTrue(box.isFull());
    }

    @Test
    public void fitsTest() {
        Box box = new BoxImpl(2, 2, 2, 2);
        Freezable elephant = new FreezableImpl(new Size(2, 2, 2), new Weight(2));
        assertTrue(box.isFits(elephant));
    }

    @Test
    public void notFitsSizeTest() {
        Box box = new BoxImpl(2, 2, 2, 2);
        Freezable elephant = new FreezableImpl(new Size(3, 3, 3), new Weight(2));
        assertFalse(box.isFits(elephant));
    }

    @Test
    public void notFitsWeightTest() {
        Box box = new BoxImpl(2, 2, 2, 2);
        Freezable elephant = new FreezableImpl(new Size(2, 2, 2), new Weight(3));
        assertFalse(box.isFits(elephant));
    }

    @Test(expected = FullException.class)
    public void notPutTest() throws BasicException {
        Box box = new BoxImpl(2, 2, 2, 2);
        Freezable elephant = new FreezableImpl(new Size(2, 2, 2), new Weight(2));
        box.put(elephant);
        box.put(elephant);
    }

    @Test(expected = EmptyException.class)
    public void notGetTest() throws BasicException {
        Box box = new BoxImpl(2, 2, 2, 2);
        box.get();
    }

    @Test(expected = EmptyException.class)
    public void notGet1Test() throws BasicException {
        Box box = new BoxImpl(2, 2, 2, 2);
        Freezable elephant = new FreezableImpl(new Size(2, 2, 2), new Weight(2));
        box.put(elephant);
        box.get();
        box.get();
    }
}
