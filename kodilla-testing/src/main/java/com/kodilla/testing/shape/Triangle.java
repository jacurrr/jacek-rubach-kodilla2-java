package com.kodilla.testing.shape;

public class Triangle implements Shape{
    private double sideA;
    private double sideB;
    private double sideC;
    private double height;
    private int angle;

    public Triangle(double sideA){
        this.sideA = sideA;
    }

    public Triangle(double sideA, double height){
        this.sideA = sideA;
        this.height = height;
    }

    public Triangle(double sideA, double sideB, double sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Triangle(double sideA, double sideB, int angle){
        this.sideA = sideA;
        this.sideB = sideB;
        this.angle = angle;
    }

    @Override
    public String getShapeName() {
        return "Triangle ";
    }

    @Override
    public double getField() {
        if(height != 0) {
            return sideA * height * 0.5;
        }else if(sideB == 0) {
            return sideA * sideA * Math.sqrt(3) / 4;
        }else if(angle != 0) {
            return 0.5 * sideA * sideB * Math.sin(Math.PI * angle / 180);
        }else {
                double halfOfPerimeter = 0.5 * (sideA + sideB + sideC);
                return Math.sqrt(halfOfPerimeter * (halfOfPerimeter - sideA) * (halfOfPerimeter - sideB) * (halfOfPerimeter - sideC));
        }
    }
}
