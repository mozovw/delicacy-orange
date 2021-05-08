package com.delicacy.orange.java.design.flyweight;

import java.util.HashMap;



/**
 * 解决：在有大量对象时，有可能会造成内存溢出，我们把其中共同的部分抽象出来，
 * 如果有相同的业务请求，直接返回在内存中已有的对象，避免重新创建。
 * @author yutao
 * @create 2019-12-26 10:49
 **/
public class FlyweightDemo {

    private static final String colors[] =
            {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 5; ++i) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.draw();
        }
    }
    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    private String color;

    public Circle(String color) {
        this.color = color;
    }
    @Override
    public void draw() {
        System.out.println("Circle: Draw() Color : " + color);
    }
}

class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();
    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);
        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}