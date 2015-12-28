package ru.anutakay;

public class FreezableImpl implements Freezable, Named {

    private Size size;

    private Weight weight;

    public FreezableImpl(Size size, Weight weight) {
        if (size == null || weight == null) {
            throw new NullPointerException();
        }
        this.size = size;
        this.weight = weight;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public Weight getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return this.getName() + ": " + size.toString() + ", " + weight.toString();
    }

    @Override
    public String getName() {
        return "ЭТО";
    }
}
