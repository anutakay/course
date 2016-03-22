package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.EmptyException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.SizeException;

import static org.testng.Assert.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by anutakay@gmail.com on 16.02.2016.
 */
public class OpenFridgeTest extends AbstractBoxTest {

    @BeforeMethod
    public void beforeMethod() throws BasicException {
        Fridge fullFridge = new Fridge(medium);
        Fridge emptyFridge = new Fridge(medium);

        emptyFridge.open();
        fullFridge.open();

        full = fullFridge;
        empty = emptyFridge;

        full.put(thing);
    }
}
