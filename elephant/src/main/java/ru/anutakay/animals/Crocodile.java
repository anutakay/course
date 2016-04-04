package ru.anutakay.animals;

import ru.anutakay.animals.size.Size;

public class Crocodile extends Animal {

    public Crocodile(Size size) {
        super(size);
    }

    @Override
    public String getName() {
        return "КРОКОДИЛ";
    }
}
