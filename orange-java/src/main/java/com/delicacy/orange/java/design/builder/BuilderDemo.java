package com.delicacy.orange.java.design.builder;

import java.util.ArrayList;
import java.util.List;


/**
 * 解决：将变与不变分离开
 * @author yutao
 * @create 2019-12-31 10:08
 **/
public class BuilderDemo {
    public static void main(String[] args) {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        meal.showItems();
        meal.showCost();
    }
}

interface Packing {
    String pack();
}

interface Item {
    String name();

    Packing packing();

    float price();
}


class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}

abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}

class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}

abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}

class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}


class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}

class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float showCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        System.out.println("sum:"+cost);
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}