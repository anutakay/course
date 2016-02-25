package ru.anutakay;

import org.testng.annotations.BeforeClass;
import ru.anutakay.exception.BasicException;

/**
 * Created by anutakay@gmail.com on 25.02.2016.
 */
public class AbstractBoxTest {

    Size small;
    Size medium;
    Size big;

    Freezable thing;

    @BeforeClass
    public void beforeClass() throws BasicException {
        System.out.println("basic before");
        small = new Size(10, 10, 10, 10);
        medium = new Size(20, 20, 20, 20);
        big = new Size(100, 100, 100, 100);

        thing = new FreezableImpl(medium);
    }
}
