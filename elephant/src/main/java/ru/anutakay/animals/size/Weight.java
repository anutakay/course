package ru.anutakay.animals.size;

import ru.anutakay.exception.UncompatibleValueException;

public class Weight implements BaseSize {

    private int value;

    public Weight(int value) {
        if (value <= 0) {
            throw new UncompatibleValueException();
        }
        this.value = value;
    }

    @Override
    public boolean greaterThan(BaseSize size) {
        Weight tmp = (Weight) size;
        if (this.value > tmp.value) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "{вес: " + value + "}";
    }
}
