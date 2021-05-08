package com.delicacy.orange.java.design.command;




/**
 * 解决：通常行为请求者与行为实现者通常是一种紧耦合的关系，解耦这种关系；需要对行为进行记录、撤销或重做、事务等处理
 * 关键：请求封装对象
 * @author yutao
 * @create 2019-12-25 10:17
 **/
public class CommandDemo {
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        Invoker ir = new Invoker(cmd);
        ir.call();
    }
}
//抽象命令
interface Command {
    void execute();
}

//调用者
class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}

//具体命令
class ConcreteCommand implements Command {
    private Receiver receiver;

    ConcreteCommand() {
        receiver = new Receiver();
    }

    public void execute() {
        receiver.action();
    }
}

//接收者
class Receiver {
    public void action() {
        System.out.println("接收者的action()方法被调用...");
    }
}
