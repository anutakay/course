package ru.anutakay;

import ru.anutakay.exception.DoorStatusException;

public interface Openable {

    void open() throws DoorStatusException;

    void close() throws DoorStatusException;

    boolean isOpened();
}
