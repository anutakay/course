package ru.anutakay.client;

import ru.anutakay.FreezableImpl;
import ru.anutakay.Fridge;

public interface Client {
    public boolean putToFridge(Fridge fridge, FreezableImpl object);
}
