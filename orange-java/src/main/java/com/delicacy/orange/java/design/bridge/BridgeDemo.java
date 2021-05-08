package com.delicacy.orange.java.design.bridge;


/**
 * 解决：将抽象与实现分离。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。
 * @author yutao
 * @create 2019-12-25 9:49
 **/
public class BridgeDemo {
    public static void main(String[] args) {
        Implementor imple = new ConcreteImplementor();
        Abstraction abs = new RefinedAbstraction(imple);
        abs.Operation();
    }
}


//实现化角色
interface Implementor {
    void OperationImpl();
}


//具体实现化角色
class ConcreteImplementor implements Implementor {
    public void OperationImpl() {
        System.out.println("具体实现化(Concrete Implementor)角色被访问");
    }
}

//抽象化角色
abstract class Abstraction {
    protected Implementor imple;

    protected Abstraction(Implementor imple) {
        this.imple = imple;
    }

    abstract void Operation();
}

//扩展抽象化角色
class RefinedAbstraction extends Abstraction {
    protected RefinedAbstraction(Implementor imple) {
        super(imple);
    }

    void Operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
        imple.OperationImpl();
    }
}