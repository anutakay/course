package ru.anutakay;

public class Crocodile extends FreezableImpl {

    public Crocodile(Size size) {
        super(size);
    }

    @Override
    public String getName() {
        return "КРОКОДИЛ";
    }
}
