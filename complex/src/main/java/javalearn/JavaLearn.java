/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javalearn;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @class JavaLearn
 * Проводит пошаговое обучение созданию классов на примере комплексных чисел.
 * @author WarFair
 */
public class JavaLearn {

    /**
     * Содержит номер шага, на котором остановился пользователь.
     * Используется при выводе информации о текущем шаге.
     */
    private static int step = 1;

    /**
     * Используется для проверки существования класса и для создания экземпляров класса
     * в дальнейшем.
     */
    private static Class ComplexClass;
    /**
     * Используется для определения существования метода setReal в классе Complex и для его вызова.
     */
    private static Method methodSetReal;
    /**
     * Используется для определения существования метода getReal в классе Complex и для его вызова.
     */
    private static Method methodGetReal;
    /**
     * Используется для определения существования метода setImage в классе Complex и для его вызова.
     */
    private static Method methodSetImage;
    /**
     * Используется для определения существования метода getImage в классе Complex и для его вызова.
     */
    private static Method methodGetImage;
    /**
     * Используется для определения существования метода add в классе Complex и для его вызова.
     */
    private static Method methodAdd;
    /**
     * Используется для определения существования конструктора по умолчанию
     * в классе Complex
     */
    private static Constructor<?> defaultCons;
    /**
     * Используется для определения существования конструктора позволяющего задавать значения
     * мнимой и действительной частей комплексного числа в классе Complex
     */
    private static Constructor<?> realImageCons;
    /**
     * хранит в себе объект созданный конструктором по умолчанию
     */
    private static Object objectDefault1;
    /**
     * хранит в себе объект созданный конструктором по умолчанию
     */
    private static Object objectDefault2;
    /**
     * хранит в себе объект созданный конструктором по умолчанию
     */
    private static Object objectDefault3;
    /**
     * хранит в себе объект созданный конструктором с заданием мнимой и действительной частей
     */
    private static Object objectRealImage1;
    /**
     * хранит в себе объект используемый приложением для автоматической проверки результатов
     */
    private static Object object1;
    /**
     * хранит в себе объект используемый приложением для автоматической проверки результатов
     */
    private static Object object2;
    /**
     * хранит в себе объект используемый приложением для автоматической проверки результатов
     */
    private static Object object3;
    /**
     * хранит в себе объект используемый приложением для автоматической проверки результатов
     */
    private static Object object4;
    /**
     * хранит в себе объект используемый приложением для автоматической проверки результата сложения
     */
    private static Object addObject1;
    /**
     * хранит в себе объект используемый приложением для автоматической проверки результата сложения
     */
    private static Object addObject2;
    /**
     * Используется для определения существования метода sub и его вызова в дальнейшем
     */
    private static Method methodSub;
    /**
     * хранит в себе объект используемый приложением для автоматической проверки результата
     * вычитания
     */
    private static Object subObject1;
    /**
     * хранит в себе объект используемый приложением для автоматической проверки результата
     * вычитания
     */
    private static Object subObject2;


    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("test");
        /// Порядок выполнения тестов имеет следующий вид:
        
        /// Определям что необходимый нам класс создан
        testComplexClassExists();

        /// Проеряем что класс имеет методы set/get
        testComplexHaveSetGet();

        /// Проверяем что можно создать экземпляр класса без исключений
        testCreateComplexObject();

        /// Проверяем что методы set/get Real работают правильно и сохраняют значения
        testComplexSetGetRealMethods();

        /// Проверяем что методы set/get Image работают правильно и сохраняют значения
        testComplexSetGetImageMethods();

        /// Проверяем что существует нужный нам конструктор
        testComplexHaveRealImageConstructor();

        /// Проверяем работу созданных конструкторов
        testComplexConstructors();

        /// Сравним два числа
        testComplexEquals();

        /// Сравним число с null
        testComplexEqualsNull();

        /// Проверяем наличие метода add()
        testComplexHaveAdd();

        /// Проверяем правильность сложения
        testComplexAdd();

        /// Проверяем наличие метода sub()
        testComplexHaveSub();

        /// Проверяем правильность вычитания
        testComplexSub();

        /// Проверяем правильность вычислений с null
        testComplexAddNull();
        testComplexSubNull();

        /// Проверяем конвертацию в строку
        testComplexToString();

        System.out.println("Готово");
    }

    /**
     * Выполняет проверку существования методов setReal, getReal, setImage, getImage
     */
    private static void testComplexHaveSetGet()
    {
        boolean needToStop = false;

        try {
            Class[] params = {double.class};
            methodSetReal = ComplexClass.getMethod("setReal", params);
        } catch (NoSuchMethodException ex) {
            System.out.println("Шаг №"+(step));
            System.out.println("Класс должен содержать метод setReal, принимающий в качестве "+
                    "параметра переменную типа double, и ничего не возвращать (Руководство, пункт 2)");
            needToStop = true;
        } catch (SecurityException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Class[] params = null;
            methodGetReal = ComplexClass.getMethod("getReal", params);
        } catch (NoSuchMethodException ex) {
            if (!needToStop)
            {
                System.out.println("Шаг №"+(step));
            }
            System.out.println("Класс должен содержать метод getReal возвращающий значение типа"
                    +" double, и не принимающий никаких значений (Руководство, пункт 2)");
            needToStop = true;
        } catch (SecurityException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }


        try {
            Class[] params = {double.class};
            methodSetImage = ComplexClass.getMethod("setImage", params);
        } catch (NoSuchMethodException ex) {
            if (!needToStop)
            {
                System.out.println("Шаг №"+(step));
            }
            System.out.println("Класс должен содержать метод setImage, принимающий в качестве "+
                    "параметра переменную типа double, и ничего не возвращать (Руководство, пункт 2)");
            needToStop = true;
        } catch (SecurityException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Class[] params = null;
            methodGetImage = ComplexClass.getMethod("getImage", params);
        } catch (NoSuchMethodException ex) {
            if (!needToStop)
            {
                System.out.println("Шаг №"+(step));
            }
            System.out.println("Класс должен содержать метод getImage возвращающий значение типа"
                    +" double, и не принимающий никаких значений (Руководство, пункт 2)");
            needToStop = true;
        } catch (SecurityException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (needToStop)
        {
            System.exit(0);
        }

        step++;
    }

    /**
     * Выполняет проверку существования класса Complex в пакете javalearn
     */
    private static void  testComplexClassExists()
    {
        try {
            ComplexClass = Class.forName("javalearn.Complex");
        } catch (Exception ex) {
            System.out.println("Шаг №"+(step));
            System.out.println("Класс javalearn.Complex не найден. Создайте этот класс (Руководство, пункт 1)");
            System.exit(0);
        }
        ++step;
    }

    /**
     * Выполняет проверку возможности создания объектов с помощью конструктора по умолчанию
     */
    private static void testCreateComplexObject()
    {
        try {
            defaultCons = ComplexClass.getConstructor();
            objectDefault1 = defaultCons.newInstance();
            objectDefault2 = defaultCons.newInstance();
        } catch (NoSuchMethodException ex) {
            System.out.println("Шаг №"+(step));
            System.out.println("Класс не имеет конструктора по умолчанию.");
            System.out.println("Обратитесь к пункту 4 руководства");
            System.exit(0);
        } catch (Exception ex) {
            System.out.println("Шаг №"+(step));
            System.out.println("Во время создания объекта произошло исключение. Похоже что "+
                    "в конструкторе по умолчанию выполняются какие-то лишние действия.");
            System.exit(0);
        }
    }

    /**
     * Выполняет проверку результатов работы setReal и getReal
     */
    private static void testComplexSetGetRealMethods() {
        boolean needToStop = false;
        try {
            final int c1 = 10;
            final double c2 = 20.0;
            methodSetReal.invoke(objectDefault1, c1);
            methodSetReal.invoke(objectDefault2, c2);
            double v1, v2;
            v1 = ((Double) methodGetReal.invoke(objectDefault1)).doubleValue();
            v2 = ((Double) methodGetReal.invoke(objectDefault2)).doubleValue();
            if (c1 != v1)
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Последовательность выполнения:");
                System.out.println("Complex obj1 = new Complex();");
                System.out.println("obj1.setReal("+c1+");");
                System.out.println("double v1 = obj1.getReal();");
                System.out.println("В результате получилось v1="+v1+", однако должно быть "+c1);
                needToStop = true;
            }
            if (c2 != v2)
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Последовательность выполнения:");
                System.out.println("Complex obj2 = new Complex();");
                System.out.println("obj2.setReal("+c2+");");
                System.out.println("double v2 = obj2.getReal();");
                System.out.println("В результате получилось v2="+v2+", однако должно быть "+c2);
                needToStop = true;
            }
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (needToStop)
        {
            System.out.println("Чтобы выполнить этот шаг просмотрите руководство пункт 3");
            System.exit(0);
        }

        step++;
    }

    /**
     * Выполняет проверку результатов работы setImage и getImage
     */
    private static void testComplexSetGetImageMethods() {
        boolean needToStop = false;
        try {
            final int c1 = 10;
            final double c2 = 20.0;
            methodSetImage.invoke(objectDefault1, c1);
            methodSetImage.invoke(objectDefault2, c2);
            double v1, v2;
            v1 = ((Double) methodGetImage.invoke(objectDefault1)).doubleValue();
            v2 = ((Double) methodGetImage.invoke(objectDefault2)).doubleValue();
            if (c1 != v1)
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Последовательность выполнения:");
                System.out.println("Complex obj1 = new Complex();");
                System.out.println("obj1.setImage("+c1+");");
                System.out.println("double v1 = obj1.getImage();");
                System.out.println("В результате получилось v1="+v1+", однако должно быть "+c1);
                needToStop = true;
            }
            if (c2 != v2)
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Последовательность выполнения:");
                System.out.println("Complex obj2 = new Complex();");
                System.out.println("obj2.setImage("+c2+");");
                System.out.println("double v2 = obj2.getImage();");
                System.out.println("В результате получилось v2="+v2+", однако должно быть "+c2);
                needToStop = true;
            }
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (needToStop)
        {
            System.out.println("Чтобы выполнить этот шаг просмотрите руководство пункт 3");
            System.exit(0);
        }

        step++;
    }

    /**
     * Выполняет проверку существования конструктора позволяющего задавать действительную
     * и мнимую часть комплексного числа
     */
    private static void testComplexHaveRealImageConstructor() {
        boolean needToStop = false;
        try {
            realImageCons = ComplexClass.getConstructor(double.class, double.class);
        } catch (NoSuchMethodException ex) {
            if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
            System.out.println("Необходимо создать конструктор класса, принимающий в качетсве "+
                    "параметров действительную (1 параметр) и мнимую (2 параметр) часть числа "+
                    "(оба параметра типа double).");
            System.out.println("Для выполнения обратитесь к руководству пункту 4");
            needToStop = true;
            System.exit(0);
        } catch (SecurityException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        step++;
    }

    /**
     * Выполняет проверку результатов работы конструкторов класса (какие начальные значения
     * задаются при создании объекта)
     */
    private static void testComplexConstructors() {
        boolean needToStop = false;
        try {
            objectDefault3 = defaultCons.newInstance();
            final int c1 = 10;
            final double c2 = 20.0;
            objectRealImage1 = realImageCons.newInstance(c1, c2);

            double v1Real = ((Double) methodGetReal.invoke(objectDefault3)).doubleValue();
            double v1Image = ((Double) methodGetImage.invoke(objectDefault3)).doubleValue();
            double v2Real = ((Double)  methodGetReal.invoke(objectRealImage1)).doubleValue();
            double v2Image = ((Double)  methodGetImage.invoke(objectRealImage1)).doubleValue();

            if (v1Real != 0)
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Конструктор по умолчанию не задает начальное значение 0 "+
                        "для мнимой части числа");
                needToStop = true;
            }
            if (v1Image != 0)
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Конструктор по умолчанию не задает начальное значение 0 "+
                        "для действительной части числа");
                needToStop = true;
            }

            if (v2Real != c1)
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Конструктор с заданием действительной и мнимой части "+
                        "неправильно задает действительную часть.");
                System.out.println("При создании указывается "+
                        "MyClass o = new MyClass("+c1+", "+c2+");");
                System.out.println("Однако в действительной части хранится "+v2Real);
                needToStop = true;
            }
            if (v2Image != c2)
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Конструктор с заданием действительной и мнимой части "+
                        "неправильно задает мнимую часть.");
                System.out.println("При создании указывается "+
                        "MyClass o = new MyClass("+c1+", "+c2+");");
                System.out.println("Однако в мнимой части хранится "+v2Image);
                needToStop = true;
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (needToStop)
        {
            System.out.println("Обратитесь к 5 пункту руководства");
            System.exit(0);
        }

        step++;
    }

    /**
     * Выполняет проверку равенства двух комплексных чисел
     */
    private static void testComplexEquals() {
        boolean needToStop = false;
        try {
            final int c1 = 10;
            final double c2 = 20.0;
            final double c3 = 30.0;
            final int c4 = 40;
            object1 = realImageCons.newInstance(c1, c2);
            object2 = realImageCons.newInstance(c1, c2);
            object3 = realImageCons.newInstance(c1, c3);
            object4 = realImageCons.newInstance(c4, c3);

            if (!object1.equals(object1))
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Созданный объект оказался неравен самому себе.");
                needToStop = true;
            }

            if (!object1.equals(object2))
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Выполнен следующий код:");
                System.out.println("Complex o1 = new Complex("+c1+", "+c2+");");
                System.out.println("Complex o2 = new Complex("+c1+", "+c2+");");
                System.out.println("В результате сравнения объекты оказались неравны");
                needToStop = true;
            }

            if (object1.equals(object3))
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Выполнен следующий код:");
                System.out.println("Complex o1 = new Complex("+c1+", "+c2+");");
                System.out.println("Complex o2 = new Complex("+c1+", "+c3+");");
                System.out.println("В результате сравнения объекты оказались равны");
                needToStop = true;
            }

            if (object4.equals(object3))
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Выполнен следующий код:");
                System.out.println("Complex o1 = new Complex("+c1+", "+c3+");");
                System.out.println("Complex o2 = new Complex("+c4+", "+c3+");");
                System.out.println("В результате сравнения объекты оказались равны");
                needToStop = true;
            }

            if (object1.equals("Test string"))
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Выполнен следующий код:");
                System.out.println("Complex o1 = new Complex("+c1+", "+c3+");");
                System.out.println("String s = \"Test string\";");
                System.out.println("В результате сравнения объекты оказались равны");
                needToStop = true;
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (needToStop)
        {
            System.out.println("Обратитесь к 6 пункту руководства");
        }

        step++;
    }

    /**
     * Выполняет проверку правильности обработки сравнения с null'ом
     */
    private static void testComplexEqualsNull() {
        boolean needToStop = false;
        Object testNull = null;
        final int c1 = 10;
        final double c2 = 20.0;
        try
        {
            if (object1.equals(testNull))
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Выполнен следующий код:");
                System.out.println("Complex o1 = new Complex("+c1+", "+c2+");");
                System.out.println("Complex o2 = null;");
                System.out.println("В результате сравнения объекты оказались равны");
                needToStop = true;
            }
        }
        catch (NullPointerException e)
        {
            if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
            System.out.println("Выполнен следующий код:");
            System.out.println("Complex o1 = new Complex("+c1+", "+c2+");");
            System.out.println("Complex o2 = null;");
            System.out.println("В результате сравнения было выброшено исключение NullPointerException");
            System.out.println("Нужно чтобы в результате было false");
            needToStop = true;
        }
        catch (Exception e)
        {
            if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
            System.out.println("Выполнен следующий код:");
            System.out.println("Complex o1 = new Complex("+c1+", "+c2+");");
            System.out.println("Complex o2 = null;");
            System.out.println("В результате сравнения было выброшено исключение "+e);
            needToStop = true;
        }

        if (needToStop)
        {
            System.exit(0);
        }

        step++;
    }

    /**
     * Проверка существования метода add в классе Complex
     */
    private static void testComplexHaveAdd() {
        boolean needToStop = false;
        try {
            Class[] params = {ComplexClass};
            methodAdd = ComplexClass.getMethod("add", params);
        } catch (NoSuchMethodException ex) {
            if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
            System.out.println("Класс не имеет метода add. Обратитесь к пункту 7 руководства");
            needToStop = true;
        } catch (SecurityException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (needToStop)
        {
            System.exit(0);
        }
    }

    /**
     * Проверка результата сложения двух комплексных чисел
     */
    private static void testComplexAdd() {
        boolean needToStop = false;
        final int r1 = 10, r2 = 20;
        final double d1 = 30, d2 = 40;
        try {
            addObject1 = realImageCons.newInstance(r1, d1);
            addObject2 = realImageCons.newInstance(r2, d2);
            Object addObject3 = methodAdd.invoke(addObject1, addObject2);
            if (addObject3 != null)
            {
                double v1, v2;
                v1 = ((Double) methodGetReal.invoke(addObject3)).doubleValue();
                v2 = ((Double) methodGetImage.invoke(addObject3)).doubleValue();

                if (v1 != r1+r2 || v2 != d1+d2)
                {
                    if (!needToStop)
                    {
                        System.out.println("Шаг №"+(step));
                    }
                    System.out.println("Выполнен следующий код:");
                    System.out.println("Complex o1 = new Complex("+r1+", "+d1+");");
                    System.out.println("Complex o2 = new Complex("+r2+", "+d2+");");
                    System.out.println("В результате сложения получилось число Complex("+v1+", "+v2+")");
                    System.out.println("Должно получиться число Complex("+(r1+r2)+", "+(d1+d2)+")");
                    needToStop = true;
                }
            }
            else
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("В результате сложения получилось значение null");
                needToStop = true;
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (needToStop)
        {
            System.exit(0);
        }

        step++;
    }

    /**
     * Выполняет проверку существования метода sub
     */
    private static void testComplexHaveSub() {
        boolean needToStop = false;
        try {
            Class[] params = {ComplexClass};
            methodSub = ComplexClass.getMethod("sub", params);
        } catch (NoSuchMethodException ex) {
            if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
            System.out.println("Класс не имеет метода sub. Обратитесь к пункту 7 руководства");
            needToStop = true;
        } catch (SecurityException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (needToStop)
        {
            System.exit(0);
        }

        step++;
    }

    /**
     * Выполняет проверку результата вычитания комплексного числа
     */
    private static void testComplexSub() {
        boolean needToStop = false;
        final int r1 = 10, r2 = 20;
        final double d1 = 30, d2 = 40;
        try {
            subObject1 = realImageCons.newInstance(r1, d1);
            subObject2 = realImageCons.newInstance(r2, d2);
            Object subObject3 = methodSub.invoke(addObject1, addObject2);
            if (subObject3 != null)
            {
                double v1, v2;
                v1 = ((Double) methodGetReal.invoke(subObject3)).doubleValue();
                v2 = ((Double) methodGetImage.invoke(subObject3)).doubleValue();

                if (v1 != r1-r2 || v2 != d1-d2)
                {
                    if (!needToStop)
                    {
                        System.out.println("Шаг №"+(step));
                    }
                    System.out.println("Выполнен следующий код:");
                    System.out.println("Complex o1 = new Complex("+r1+", "+d1+");");
                    System.out.println("Complex o2 = new Complex("+r2+", "+d2+");");
                    System.out.println("В результате вычитания получилось число Complex("+v1+", "+v2+")");
                    System.out.println("Должно получиться число Complex("+(r1-r2)+", "+(d1-d2)+")");
                    needToStop = true;
                }
            }
            else
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("В результате сложения получилось значение null");
                needToStop = true;
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (needToStop)
        {
            System.exit(0);
        }

        step++;
    }

    /**
     * Выполняет проверку сложения комплексного числа и null'а
     */
    private static void testComplexAddNull() {
        boolean needToStop = false;
        final int r1 = 10, r2 = 20;
        final double d1 = 30, d2 = 40;
        try {
            addObject1 = realImageCons.newInstance(r1, d1);
            addObject2 = null;
            try
            {
                Object addObject3 = methodAdd.invoke(addObject1, addObject2);
            }
            catch (Exception e)
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Выполнен следующий код:");
                System.out.println("Complex o1 = new Complex("+r1+", "+d1+");");
                System.out.println("Complex o2 = null;");
                System.out.println("В результате сложения было выброшено исключение");
                System.out.println("Обратитесь к пункту 8 руководства");
                needToStop = true;
            }

        } catch (InstantiationException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (needToStop)
        {
            System.exit(0);
        }

        step++;
    }

    /**
     * Выполняет проверку вычитания null'а из комплексного числа
     */
    private static void testComplexSubNull() {
        boolean needToStop = false;
        final int r1 = 10, r2 = 20;
        final double d1 = 30, d2 = 40;
        try {
            subObject1 = realImageCons.newInstance(r1, d1);
            subObject2 = null;
            try
            {
                Object addObject3 = methodSub.invoke(subObject1, subObject2);
            }
            catch (Exception e)
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Выполнен следующий код:");
                System.out.println("Complex o1 = new Complex("+r1+", "+d1+");");
                System.out.println("Complex o2 = null;");
                System.out.println("В результате вычитания было выброшено исключение");
                System.out.println("Обратитесь к пункту 8 руководства");
                needToStop = true;
            }

        } catch (InstantiationException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (needToStop)
        {
            System.exit(0);
        }

        step++;
    }

    /**
     * Проверка правильности работы метода toString
     */
    private static void testComplexToString() {
        boolean needToStop = false;
        final double c1 = 10;
        final double c2 = 20.0;
        try {
            object1 = realImageCons.newInstance(c1, c2);
            object2 = realImageCons.newInstance(c1, -c2);
            String s = object1.toString();
            if (s == null)
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Метод toString вернул null.");
                return;
            }
            if (s.startsWith("javalearn.Complex"))
            {
                if (!needToStop)
                {
                    System.out.println("Шаг №"+(step));
                }
                System.out.println("Каждый уважающий себя класс должен уметь конвертироваться в строку");
                System.out.println("Обратитесь к пункту 9 руководства");
                needToStop = true;
            }
            else
            {
                String str1 = ""+c1+"+"+c2+"i";
                if (s.equals(str1))
                {
                    String s2 = object2.toString();
                    String str2 = ""+c1+(-c2)+"i";
                    if (!s2.equals(str2))
                    {
                        if (!needToStop)
                        {
                            System.out.println("Шаг №"+(step));
                        }
                        System.out.println("А вот если мнимая часть отрицательная, то получается так:");
                        System.out.println("\""+s2+"\"");
                        System.out.println("А должно быть так");
                        System.out.println("\""+str2+"\"");
                        needToStop = true;
                    }
                }
                else
                {
                    if (!needToStop)
                    {
                        System.out.println("Шаг №"+(step));
                    }
                    System.out.println("Нужно чтобы метод вернул \""+str1+"\", однако он вернул \""+s+"\"");
                    needToStop = true;
                }
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JavaLearn.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (needToStop)
        {
            System.exit(0);
        }

        step++;
    }
}