package ru.anutakay.animals;

import ru.anutakay.animals.size.Size;

public class Giraffe extends Animal {

    public Giraffe(Size size) {
        super(size);
    }

    @Override
    public String getName() {
        return "ЖИРАФ";
    }
}
