package com.delicacy.orange.java.design.visitor;

/**
 * 在被访问的类里面加一个对外提供接待访问者的接口
 * @author yutao
 * @create 2019-12-20 10:16
 **/
public class VisitorDemo {
    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}

interface ComputerPartVisitor {
    void visit(Computer computer);
}

class Computer implements ComputerPart {

    private String name = "lenovo";
    private int salary = 5000;

    public void info() {
        System.out.println("name=" + this.name);
        System.out.println("salary=" + this.salary);
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
        computer.info();
    }
}