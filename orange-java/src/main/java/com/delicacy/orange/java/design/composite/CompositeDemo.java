package com.delicacy.orange.java.design.composite;

import java.util.ArrayList;


/**
 * 组合整体和部分的关系
 * 树枝和树叶的关系
 * form和button、input、checkbox和radio关系
 *
 */
public class CompositeDemo {
    public static void main(String[] args) {
        Component branch1 = new Branch();
        Component branch2 = new Branch();
        Component leaf1 = new Leaf("1");
        Component leaf2 = new Leaf("2");
        Component leaf3 = new Leaf("3");
        branch1.add(leaf1);
        branch1.add(branch2);
        branch2.add(leaf2);
        branch2.add(leaf3);
        branch1.operation();
        branch2.operation();
    }
}

//抽象构件
interface Component {
    void add(Component c);

    void operation();
}

//树叶构件
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    public void add(Component c) {
    }

    public void operation() {
        System.out.println("树叶" + name + "：被访问！");
    }
}

//树枝构件
class Branch implements Component {
    private ArrayList<Component> children = new ArrayList<Component>();

    public void add(Component c) {
        children.add(c);
    }

    public void operation() {
        for (Object obj : children) {
            ((Component) obj).operation();
        }
    }
}