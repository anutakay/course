package ru.anutakay.fridge;

import ru.anutakay.animals.size.Size;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.*;

import java.util.*;

/**
 * Created by akaygorodova@issart.com on 22.03.2016.
 */
public class Checkroom<A extends IAnimal> extends AbstractFridge<A> implements IMultipleBox<A> {

    private int capacity;

    Set<String> emptyCells;

    Map<String, A> objects;

    public Checkroom(Size size, int capacity) {
        super(size);
        if (capacity <= 0) {
            throw  new UncompatibleValueException();
        }
        this.capacity = capacity;
        emptyCells = new HashSet<String>();
        objects = new HashMap<String, A>();
    }

    @Override
    public String put(A freezable) throws BasicException {
        checkDoor();
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
    public A get(String key) throws BasicException {
        checkDoor();
        boolean empty = emptyCells.contains(key);
        if(empty) {
            throw new EmptyException();
        }
        boolean filled = objects.keySet().contains(key);
        if(!filled) {
            throw new UncompatibleValueException();
        }
        A obj = objects.get(key);
        objects.remove(key);
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
