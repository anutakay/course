package ru.anutakay;

import ru.anutakay.Freezable;
import ru.anutakay.exception.BasicException;

/**
 * Created by akaygorodova@issart.com on 22.03.2016.
 */
public interface Place {

    boolean isFits(Freezable object);
}
