package ru.anutakay.animals.size;

import ru.anutakay.exception.UncompatibleClassException;
import ru.anutakay.exception.UncompatibleValueException;

public class Size implements BaseSize {

    private int length;
    private int width;
    private int height;
    private Weight weight;

    public Size(int length, int width, int height, Weight weight) {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new UncompatibleValueException();
        }
        if (weight == null) {
            throw new NullPointerException();
        }
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public Size(int length, int width, int height, int weight) {
        this(length, width, height, new Weight(weight));
    }

    @Override
    public boolean greaterThan(BaseSize size) {
        if(size.getClass() != Size.class) {
            throw new UncompatibleClassException();
        }
        Size tmp = (Size) size;
        if (this.length > tmp.length) {
            return true;
        }
        if (this.width > tmp.width) {
            return true;
        }
        if (this.height > tmp.height) {
            return true;
        }
        if (this.weight.greaterThan(tmp.weight)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "{длина: " + length + ", ширина:" + width + ", высота: " + height + ", вес:" + weight + "}";
    }
}
