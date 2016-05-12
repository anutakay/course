package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.size.Size;

/**
 * Created by akaygorodova@issart.com on 22.03.2016.
 */
public interface IPlace<A extends IAnimal> {

    boolean isFits(A object);

    Size getSize();
}
