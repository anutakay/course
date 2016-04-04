package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import ru.anutakay.exception.BasicException;
import ru.anutakay.fridge.BoxFridge;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by anutakay@gmail.com on 16.02.2016.
 */
public class OpenFridgeTest extends AbstractBoxTest {

    @BeforeMethod
    public void beforeMethod() throws BasicException {
        BoxFridge fullFridge = new BoxFridge(medium);
        BoxFridge emptyFridge = new BoxFridge(medium);

        emptyFridge.open();
        fullFridge.open();

        full = fullFridge;
        empty = emptyFridge;

        full.put(thing);
    }
}
