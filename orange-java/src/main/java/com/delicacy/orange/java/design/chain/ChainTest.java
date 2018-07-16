package com.delicacy.orange.java.design.chain;

/**
 * 应用实例
 *  1、红楼梦中的"击鼓传花"。
 *  2、JS 中的事件冒泡。
 *  3、JAVA WEB 中 Apache Tomcat 对 Encoding 的处理，Struts2 的拦截器，jsp servlet 的 Filter。
 *  使用场景·
 *  1、有多个对象可以处理同一个请求，具体哪个对象处理该请求由运行时刻自动确定。
 *  2、在不明确指定接收者的情况下，向多个对象中的一个提交一个请求。
 *  3、可动态指定一组对象处理请求。
 * @author yutao
 * @create 2018-07-16 11:54
 **/
public class ChainTest {

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

    /**
     * 持有后继的责任对象
     */
    protected Handler successor;

    /**
     * 示意处理请求的方法，虽然这个示意方法是没有传入参数的
     * 但实际是可以传入参数的，根据具体需要来选择是否传递参数
     */
    public abstract void handleRequest();

    /**
     * 取值方法
     */
    public Handler getSuccessor() {
        return successor;
    }

    /**
     * 赋值方法，设置后继的责任对象
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

}

//总经理
class GeneralManager extends Handler {
    /**
     * 处理方法，调用此方法处理请求
     */
    @Override
    public void handleRequest() {
        /**
         * 判断是否有后继的责任对象
         * 如果有，就转发请求给后继的责任对象
         * 如果没有，则处理请求
         */
        if (getSuccessor() != null) {
            System.out.println(this.getClass().getSimpleName()+"不在");
            getSuccessor().handleRequest();
        } else {
            System.out.println(this.getClass().getSimpleName() + "处理请求");
        }
    }

}

class Manager extends Handler {
    /**
     * 处理方法，调用此方法处理请求
     */
    @Override
    public void handleRequest() {
        /**
         * 判断是否有后继的责任对象
         * 如果有，就转发请求给后继的责任对象
         * 如果没有，则处理请求
         */
        if (getSuccessor() != null) {
            System.out.println(this.getClass().getSimpleName()+"不在");
            getSuccessor().handleRequest();
        } else {
            System.out.println(this.getClass().getSimpleName() + "处理请求");
        }
    }

}
//专员
class Commissioner extends Handler {
    /**
     * 处理方法，调用此方法处理请求
     */
    @Override
    public void handleRequest() {
        /**
         * 判断是否有后继的责任对象
         * 如果有，就转发请求给后继的责任对象
         * 如果没有，则处理请求
         */
        if (getSuccessor() != null) {
            System.out.println(this.getClass().getSimpleName()+"不在");
            getSuccessor().handleRequest();
        } else {
            System.out.println(this.getClass().getSimpleName() + "处理请求");
        }
    }

}
