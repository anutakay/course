package ru.anutakay;

public class Crocodile extends FreezableImpl {

    public Crocodile(Size size, Weight weight) {
        super(size, weight);
    }

    @Override
    public String getName() {
        return "КРОКОДИЛ";
    }
}
