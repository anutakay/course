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

    public Complex add(Complex other) {
        Complex result = new Complex(this.real + other.real, this.image + other.image);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Complex complex = (Complex) o;

        if (Double.compare(complex.real, real) != 0) return false;
        return Double.compare(complex.image, image) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(image);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
