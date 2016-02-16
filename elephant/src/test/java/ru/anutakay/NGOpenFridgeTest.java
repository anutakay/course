package ru.anutakay;

import org.testng.annotations.BeforeClass;
import ru.anutakay.exception.BasicException;

/**
 * Created by anutakay@gmail.com on 16.02.2016.
 */
public class NGOpenFridgeTest extends NGBoxTest {

    Fridge fullFridge;
    Fridge emptyFridge;

    @BeforeClass
    public void before() throws BasicException {
        super.before();

        emptyBox = new Fridge(mediumSize);
        fullBox = new Fridge(mediumSize);
        thing = new FreezableImpl(mediumSize);

        fullFridge = (Fridge)fullBox;
        emptyFridge = (Fridge)emptyBox;

        emptyFridge.open();
        fullFridge.open();
        fullFridge.put(thing);
    }
}
