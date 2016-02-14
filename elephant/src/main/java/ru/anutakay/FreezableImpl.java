package ru.anutakay;

public class FreezableImpl implements Freezable, Named {

    private Size size;

    public FreezableImpl(Size size) {
        if (size == null) {
            throw new NullPointerException();
        }
        this.size = size;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        return this.getName() + ": " + size.toString();
    }

    @Override
    public String getName() {
        return "ЭТО";
    }
}
