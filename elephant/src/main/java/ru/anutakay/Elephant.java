package ru.anutakay;

public class Elephant extends FreezableImpl {

    public Elephant(Size size) {
        super(size);
    }

    @Override
    public String getName() {
        return "СЛОН";
    }
}
