package com.delicacy.orange.java.design.facade;



/**
 * 解决：为子系统中的一组接口提供一个一致的界面。像是controller层
 * @author yutao
 * @create 2019-12-25 10:07
 **/
public class FacadeDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}

class ShapeMaker {
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}