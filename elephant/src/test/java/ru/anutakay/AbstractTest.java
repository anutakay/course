package ru.anutakay;

import org.testng.annotations.BeforeClass;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.Animal;
import ru.anutakay.animals.size.Size;
import ru.anutakay.exception.BasicException;

/**
 * Created by anutakay@gmail.com on 22.03.2016.
 */
public class AbstractTest {

    Size small;
    Size medium;
    Size big;

    IAnimal thing;

    static final int CAPACITY = 10;
    static final int HALF = 5;

    static final int ONE = 1;

    @BeforeClass
    public void beforeClass() throws BasicException {
        small = new Size(10, 10, 10, 10);
        medium = new Size(20, 20, 20, 20);
        big = new Size(100, 100, 100, 100);

        thing = new Animal(medium);
    }

}
