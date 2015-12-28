package ru.anutakay.client;

import ru.anutakay.FreezableImpl;
import ru.anutakay.Fridge;

public class StrongClient implements Client {

    @Override
    public boolean putToFridge(Fridge fridge, FreezableImpl object) {
        System.out.println(fridge.getName() + " открыт?");
        boolean isOpen = fridge.isOpened();
        if (isOpen) {
            System.out.println("Да, открыт");
        } else {
            System.out.println("Нет, закрыт");
            System.out.println("Открываю " + fridge.getName());
            fridge.open();
        }
        System.out.println(fridge.getName() + " пустой?");
        boolean isFull = fridge.isFull();
        FreezableImpl old = null;
        if (isFull) {
            System.out.println("Нет, здесь что-то есть");
            System.out.println("Вытаскиваю что-то из " + fridge.getName());
            old = (FreezableImpl) fridge.get();
            System.out.println("Это " + old.getName());
        } else {
            System.out.println("Да, " + fridge.getName() + " пуст.");
        }
        System.out.println("Влезет ли " + object + " в " + fridge + "?");
        boolean isFits = fridge.isFits(object);
        if (isFits) {
            System.out.println(object.getName() + " влезет в " + fridge.getName());
        } else {
            System.out.println(object.getName() + " не влезет в " + fridge.getName());
            if (old != null) {
                System.out.println("Кладу " + old.getName() + " обратно в " + fridge.getName());
                fridge.put(old);
            }
            System.out.println("Закрываю " + fridge.getName());
            fridge.close();
            return false;
        }
        System.out.println("Кладу " + object.getName() + " в " + fridge.getName());
        fridge.put(object);
        System.out.println("Закрываю " + fridge.getName());
        fridge.close();
        return true;
    }
}
