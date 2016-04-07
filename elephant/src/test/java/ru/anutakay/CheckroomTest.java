package ru.anutakay;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.Animal;
import ru.anutakay.exception.*;
import ru.anutakay.fridge.Checkroom;
import ru.anutakay.fridge.MultipleBox;

import java.util.UUID;

import static org.testng.Assert.*;

/**
 * Created by akaygorodova@issart.com on 23.03.2016.
 */
public class CheckroomTest extends AbstractCheckroomTest {

    @BeforeMethod
    public void beforeMethod() throws DoorStatusException {
        Checkroom tmp = new Checkroom(medium, ONE);
        tmp.open();
        checkroom = tmp;
    }
}
