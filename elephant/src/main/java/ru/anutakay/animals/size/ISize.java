package ru.anutakay.animals.size;

public interface ISize<S extends ISize> {

    boolean greaterThan(S size);

}
