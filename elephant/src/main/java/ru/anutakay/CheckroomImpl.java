package ru.anutakay;

import ru.anutakay.exception.EmptyException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.SizeException;
import ru.anutakay.exception.UncompatibleValueException;

import java.util.*;

/**
 * Created by akaygorodova@issart.com on 22.03.2016.
 */
public class CheckroomImpl extends PlaceImpl implements Checkroom {

    private int capacity;

    Set<String> emptyCells;

    Map<String, Freezable> objects;

    public CheckroomImpl(Size size, int capacity) {
        super(size);
        this.capacity = capacity;
        emptyCells = new HashSet<String>();
    }

    @Override
    public String put(Freezable freezable) throws FullException, SizeException {
        if(!isFits(freezable)) {
            throw new SizeException();
        }
        if(!this.hasFreeSpace()) {
            throw new FullException();
        }
        String cell = getFirstEmptyCell();
        objects.put(cell, freezable);
        emptyCells.remove(cell);
        return cell;
    }

    @Override
    public Freezable get(String key) throws EmptyException {
        boolean empty = emptyCells.contains(key);
        if(empty) {
            throw new EmptyException();
        }
        boolean filled = objects.keySet().contains(key);
        if(!filled) {
            throw new UncompatibleValueException();
        }
        Freezable obj = objects.get(key);
        emptyCells.add(key);
        return obj;
    }

    @Override
    public boolean hasFreeSpace() {
        return maxCapacity() > usedCapacity();
    }

    @Override
    public int maxCapacity() {
        return capacity;
    }

    @Override
    public int usedCapacity() {
        return objects.size();
    }

    private String getFirstEmptyCell() {
        String res;
        if(emptyCells.isEmpty()) {
            res = UUID.randomUUID().toString();
        } else {
            res = emptyCells.iterator().next();
            emptyCells.remove(res);
        }
        return res;
    }
}
