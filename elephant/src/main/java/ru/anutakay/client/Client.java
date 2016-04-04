package ru.anutakay.client;

import ru.anutakay.animals.Animal;
import ru.anutakay.fridge.Fridge;
import ru.anutakay.exception.*;

public interface Client {
    boolean putToFridge(Fridge fridge, Animal object) throws BasicException;
}
