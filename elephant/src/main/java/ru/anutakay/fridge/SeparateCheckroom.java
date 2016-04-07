package ru.anutakay.fridge;

import ru.anutakay.animals.IAnimal;
import ru.anutakay.animals.size.Size;
import ru.anutakay.exception.BasicException;
import ru.anutakay.exception.FullException;
import ru.anutakay.exception.SizeException;

import java.util.*;

/**
 * Created by akaygorodova@issart.com on 07.04.2016.
 */
public class SeparateCheckroom extends AbstractFridge implements MultipleBox {

    private int capacity;

    private Map<String, Fridge> animals = null;

    private Set<String> emptyKeys = new HashSet<String>();

    public SeparateCheckroom(Size size, int capacity) {
        super(size);
        animals = new HashMap<String, Fridge>(capacity);
        this.capacity = capacity;
    }

    @Override
    public String put(IAnimal animal) throws BasicException {
        if (!hasFreeSpace()) {
            throw new FullException();
        }
        if (!isFits(animal)) {
            throw new SizeException();
        }
        String key = getFirstEmptyCell();
        Fridge fridge = new Fridge(animal.getSize());
        fridge.open();
        fridge.put(animal);
        fridge.close();
        animals.put(key, fridge);
        return key;
    }

    @Override
    public IAnimal get(String key) throws BasicException {
        Fridge fridge  = animals.get(key);
        fridge.open();
        IAnimal res = fridge.get();
        fridge.close();
        emptyKeys.add(key);
        return res;
    }

    @Override
    public boolean hasFreeSpace() throws BasicException {
        return usedCapacity() < maxCapacity();
    }

    @Override
    public int maxCapacity() {
        return capacity;
    }

    @Override
    public int usedCapacity() {
        return animals.size() - emptyKeys.size();
    }

    private String getFirstEmptyCell() {
        String res;
        if(emptyKeys.isEmpty()) {
            res = UUID.randomUUID().toString();
        } else {
            res = emptyKeys.iterator().next();
            emptyKeys.remove(res);
        }
        return res;
    }
}
