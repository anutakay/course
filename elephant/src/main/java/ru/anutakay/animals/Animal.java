package ru.anutakay.animals;

import ru.anutakay.Named;
import ru.anutakay.animals.size.Size;

public class Animal implements IAnimal, Named {

    private Size size;

    public Animal(Size size) {
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
