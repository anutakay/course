package javalearn;

/**
 * Created by anutakay@gmail.com on 08.02.2016.
 */
public class Complex {

    private double real;

    private double image;

    public Complex() {

    }

    public Complex(double real, double image) {
        this.real = real;
        this.image = image;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getReal() {
        return real;
    }

    public  void setImage(double image) {
        this.image = image;
    }

    public double getImage() {
        return image;
    }
}
