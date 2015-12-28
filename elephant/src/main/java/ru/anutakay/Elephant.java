package ru.anutakay;

public class Elephant extends FreezableImpl {

    public Elephant(Size size, Weight weight) {
        super(size, weight);
    }

    @Override
    public String getName() {
        return "СЛОН";
    }
}
