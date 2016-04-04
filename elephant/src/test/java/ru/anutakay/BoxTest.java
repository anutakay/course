package ru.anutakay;

import org.testng.annotations.*;
import ru.anutakay.exception.BasicException;
import ru.anutakay.fridge.Box;

/**
 * Created by anutakay@gmail.com on 14.02.2016.
 */
public class BoxTest extends AbstractBoxTest {

    @BeforeMethod
    public void  beforeMethod() throws BasicException {
        empty = new Box(medium);
        full = new Box(medium);

        full.put(thing);
    }
}
