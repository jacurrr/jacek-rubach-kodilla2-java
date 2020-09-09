package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> figures= new ArrayList<Shape>();
    public void addFigure(Shape shape){
        figures.add(shape);
    }
    public boolean removeFigure(Shape shape){
        boolean result = false;
        if(figures.contains(shape)) {
            figures.remove(shape);
            result = true;
        }
        return result;
    }
    public Shape getFigure(int n){
        if(n >= 0 && n < figures.size()){
            return figures.get(n);
        }else {
            return null;
        }
    }

    public String showFigure(int n) {
        if(n >= 0 && n < figures.size()){
            return "Shape: " + figures.get(n).getShapeName() + "Field: " + figures.get(n).getField();
        }else {
            return null;
        }
    }

    public void showFigures()
    {
        for (int i = 0; i < figures.size(); i++){
            System.out.println(showFigure(i));
        }
    }

    public int getSize(){
        return figures.size();
    }

}
