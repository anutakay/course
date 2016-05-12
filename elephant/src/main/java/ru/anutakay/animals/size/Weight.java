package ru.anutakay.animals.size;

import ru.anutakay.exception.UncompatibleValueException;

public class Weight implements ISize<Weight> {

    private int value;

    public Weight(int value) {
        if (value <= 0) {
            throw new UncompatibleValueException();
        }
        this.value = value;
    }

    @Override
    public boolean greaterThan(Weight size) {
        return this.value > size.value;
    }

    @Override
    public String toString() {
        return "{вес: " + value + "}";
    }
}
