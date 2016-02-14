package ru.anutakay;

public class Giraffe extends FreezableImpl {

    public Giraffe(Size size) {
        super(size);
    }

    @Override
    public String getName() {
        return "ЖИРАФ";
    }
}
