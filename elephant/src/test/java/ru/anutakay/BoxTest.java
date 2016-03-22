package ru.anutakay;

import org.testng.annotations.*;
import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.EmptyException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.SizeException;

import static org.testng.Assert.*;

/**
 * Created by anutakay@gmail.com on 14.02.2016.
 */
public class BoxTest extends AbstractBoxTest {

    @BeforeMethod
    public void  beforeMethod() throws BasicException {
        empty = new BoxImpl(medium);
        full = new BoxImpl(medium);

        full.put(thing);
    }
}
