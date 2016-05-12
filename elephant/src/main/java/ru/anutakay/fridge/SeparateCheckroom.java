package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.size.Size;
import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.UncompatibleValueException;

import java.util.*;

/**
 * Created by akaygorodova@issart.com on 07.04.2016.
 */
public class SeparateCheckroom<A extends IAnimal> implements IMultipleBox<A> {

    private int capacity;

    private Size size;

    private Map<String, Fridge> fridges;

    private Set<String> emptyKeys = new HashSet<String>();

    public SeparateCheckroom(Size size, int capacity) {
        fridges = new HashMap<String, Fridge>(capacity);
        this.capacity = capacity;
        this.size = size;
    }

    @Override
    public String put(IAnimal animal) throws BasicException {
        if (!hasFreeSpace()) {
            throw new FullException();
        }
        String key = getFirstEmptyCell();
        Fridge fridge = fridges.get(key);
        fridge.open();
        fridge.put(animal);
        fridge.close();
        return key;
    }

    @Override
    public A get(String key) throws BasicException {
        if(!fridges.containsKey(key)) {
            throw new UncompatibleValueException();
        }
        Fridge<A> fridge  = fridges.get(key);
        fridge.open();
        A res = fridge.get();
        fridge.close();
        emptyKeys.add(key);
        return res;
    }

    @Override
    public boolean hasFreeSpace() {
        return usedCapacity() < maxCapacity();
    }

    @Override
    public int maxCapacity() {
        return capacity;
    }

    @Override
    public int usedCapacity() {
        return fridges.size() - emptyKeys.size();
    }

    private String getFirstEmptyCell() {
        String res;
        if(emptyKeys.isEmpty()) {
            res = UUID.randomUUID().toString();
            Fridge<A> tmpFridge = new Fridge<A>(size);
            fridges.put(res, tmpFridge);
        } else {
            res = emptyKeys.iterator().next();
            emptyKeys.remove(res);
        }
        return res;
    }
}
