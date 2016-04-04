package ru.anutakay.fridge;

import ru.anutakay.animals.size.Size;
import ru.anutakay.animals.IAnimal;
import ru.anutakay.exception.*;

import java.util.*;

/**
 * Created by akaygorodova@issart.com on 22.03.2016.
 */
public class Checkroom extends AbstractFridge implements MultiplePlaceBox {

    private int capacity;

    Set<String> emptyCells;

    Map<String, IAnimal> objects;

    public Checkroom(Size size, int capacity) {
        super(size);
        if (capacity <= 0) {
            throw  new UncompatibleValueException();
        }
        this.capacity = capacity;
        emptyCells = new HashSet<String>();
        objects = new HashMap<String, IAnimal>();
    }

    @Override
    public String put(IAnimal freezable) throws BasicException {
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
    public IAnimal get(String key) throws BasicException {
        boolean empty = emptyCells.contains(key);
        if(empty) {
            throw new EmptyException();
        }
        boolean filled = objects.keySet().contains(key);
        if(!filled) {
            throw new UncompatibleValueException();
        }
        IAnimal obj = objects.get(key);
        objects.remove(key);
        emptyCells.add(key);
        return obj;
    }

    @Override
    public boolean hasFreeSpace() throws BasicException {
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

    @Override
    public boolean isFits(IAnimal object) {
        return place.isFits(object);
    }
}
