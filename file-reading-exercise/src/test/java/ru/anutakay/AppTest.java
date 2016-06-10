package ru.anutakay;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by akaygorodova@issart.com on 10.06.2016.
 */
public class AppTest {

    @Test
    public void test() {
        Application app = new Application();
        new File("out").mkdirs();
        try {
            app.start("resources/input.txt", "out/output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
