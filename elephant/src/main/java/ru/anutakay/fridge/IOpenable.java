package ru.anutakay.fridge;

import ru.anutakay.exception.DoorStatusException;

public interface IOpenable {

    void open() throws DoorStatusException;

    void close() throws DoorStatusException;

    boolean isOpened();
}
