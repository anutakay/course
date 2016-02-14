package ru.anutakay.client;

import ru.anutakay.FreezableImpl;
import ru.anutakay.Fridge;
import ru.anutakay.exception.*;

public interface Client {
    boolean putToFridge(Fridge fridge, FreezableImpl object) throws BasicException;
}
