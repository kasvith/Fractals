package com.kasun.math;

/**
 * Created by kasun on 7/14/17.
 */
public class Complex {
    private double x = 0.0f;
    private double y = 0.0f;

    public Complex(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Complex add(Complex number){
        return Complex.add(this, number);
    }

    public Complex substract(Complex number){
        return Complex.subtract(this, number);
    }

    public Complex multiply(Complex number){
        return Complex.multiply(this, number);
    }

    public Complex square(){
        return Complex.square(this);
    }

    public double getAbsolute(){
        return Complex.getAbsolute(this);
    }

    public static Complex add(Complex a, Complex b){
        return new Complex(a.getX() + b.getX(), a.getY() + b.getY());
    }

    public static Complex subtract(Complex a, Complex b){
        return new Complex(a.getX() - b.getX(), a.getY() - b.getY());
    }

    public static Complex multiply(Complex a, Complex b){
        double real = a.getX()*b.getX() - a.getY()*b.getY();
        double img = a.getX()*b.getY() + a.getY()*b.getX();

        return new Complex(real, img);
    }

    public static Complex square(Complex number){
        double real = Math.pow(number.getX(), 2) - Math.pow(number.getY(), 2);
        double img = 2 * number.getX() * number.getY();

        return new Complex(real, img);
    }

    public static double getAbsolute(Complex complex){
        return Math.sqrt(Math.pow(complex.getX(), 2) + Math.pow(complex.getY(), 2));
    }
}
