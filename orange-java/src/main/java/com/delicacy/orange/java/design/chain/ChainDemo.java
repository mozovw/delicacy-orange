package com.delicacy.orange.java.design.chain;

/**
 * 1、一个请求需要总经理=>经理=>专员来批复
 *
 * @author yutao
 * @create 2018-07-16 11:54
 **/
public class ChainDemo {

    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new GeneralManager();
        Handler handler2 = new Manager();
        Handler handler3 = new Commissioner();
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);
        //提交请求
        handler1.handleRequest();
    }

}

abstract class Handler {

    protected Handler successor;

    public void handleRequest() {
        if (getSuccessor() != null) {
            System.out.println(this.getClass().getSimpleName() + "不在");
            getSuccessor().handleRequest();
        } else {
            System.out.println(this.getClass().getSimpleName() + "处理请求");
        }
    }

    Handler getSuccessor() {
        return successor;
    }

    void setSuccessor(Handler successor) {
        this.successor = successor;
    }

}

//总经理
class GeneralManager extends Handler {
}

class Manager extends Handler {
}

//专员
class Commissioner extends Handler {
}
