package ru.anutakay.client;

import ru.anutakay.animals.Animal;
import ru.anutakay.fridge.BoxFridge;
import ru.anutakay.exception.*;

public interface Client {
    boolean putToFridge(BoxFridge fridge, Animal object) throws BasicException;
}
