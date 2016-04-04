package ru.anutakay;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.anutakay.animals.size.BaseSize;
import ru.anutakay.animals.size.Size;
import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.UncompatibleClassException;
import ru.anutakay.exception.UncompatibleValueException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by anutakay@gmail.com on 15.02.2016.
 */
public class SizeTest {

    Size smallSize;
    Size mediumSize;
    Size equalSize;
    Size bigSize;
    Size bigHeight;
    Size bigWidth;
    Size bigLength;
    Size bigWeight;

    @BeforeClass
    public void before() throws BasicException {
        smallSize = new Size(10, 10, 10, 10);
        mediumSize = new Size(20, 20, 20, 20);
        equalSize = new Size(20, 20, 20, 20);
        bigSize = new Size(100, 100, 100, 100);
        bigHeight = new Size(20, 20, 100, 20);
        bigWidth = new Size(20, 100, 20, 20);
        bigLength = new Size(100, 20, 20, 20);
        bigWeight = new Size(20, 20, 20, 100);
    }

    @Test
    public void successCompareSmall() {
        boolean res = smallSize.greaterThan(mediumSize);
        assertFalse(res);
    }

    @Test
    public void successCompareBig() {
        boolean res = bigSize.greaterThan(mediumSize);
        assertTrue(res);
    }

    @Test
    public void successCompareEqual() {
        boolean res = equalSize.greaterThan(mediumSize);
        assertFalse(res);
    }

    @Test
    public void successCompareBigHeight() {
        boolean res = bigHeight.greaterThan(mediumSize);
        assertTrue(res);
    }

    @Test
    public void successCompareBigWidth() {
        boolean res = bigWidth.greaterThan(mediumSize);
        assertTrue(res);
    }

    @Test
    public void successCompareBigLength() {
        boolean res = bigLength.greaterThan(mediumSize);
        assertTrue(res);
    }

    @Test
    public void successCompareBigWeight() {
        boolean res = bigWeight.greaterThan(mediumSize);
        assertTrue(res);
    }

    @Test(expectedExceptions = UncompatibleClassException.class)
    public void failCompareClass() {
        BaseSize size = new BaseSize() {
            @Override
            public boolean greaterThan(BaseSize size) {
                return false;
            }
        };
        mediumSize.greaterThan(size);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void failCompareNull() {
        mediumSize.greaterThan(null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void failCreateNull() {
        new Size(10, 10, 10, null);
    }

    @Test(expectedExceptions = UncompatibleValueException.class)
    public void failCreateLength() {
        new Size(0, 10, 10, 10);
    }

    @Test(expectedExceptions = UncompatibleValueException.class)
    public void failCreateWidth() {
        new Size(10, -10, 10, 10);
    }

    @Test(expectedExceptions = UncompatibleValueException.class)
    public void failCreateWeight() {
        new Size(10, 10, 10, -10);
    }
}
