package ru.anutakay;

public class Giraffe extends FreezableImpl {

    public Giraffe(Size size, Weight weight) {
        super(size, weight);
    }

    @Override
    public String getName() {
        return "ЖИРАФ";
    }
}
