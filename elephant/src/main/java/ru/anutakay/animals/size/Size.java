package ru.anutakay.animals.size;

import ru.anutakay.exception.UncompatibleValueException;

public class Size implements ISize<Size> {

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
    public boolean greaterThan(Size size) {

        return this.length > size.length || this.width > size.width
                || this.height > size.height || this.weight.greaterThan(size.weight);
    }

    @Override
    public String toString() {
        return "{длина: " + length + ", ширина:" + width + ", высота: " + height + ", вес:" + weight + "}";
    }
}
