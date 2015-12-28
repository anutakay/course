package ru.anutakay;

import ru.anutakay.exception.UncompatibleValueException;

public class Size implements BaseSize {

    private int length;
    private int width;
    private int height;

    public Size(int length, int width, int height) {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new UncompatibleValueException();
        }
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean greaterThan(BaseSize size) {
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
        return false;
    }

    @Override
    public String toString() {
        return "{длина: " + length + ", ширина:" + width + ", высота: " + height + "}";
    }
}
