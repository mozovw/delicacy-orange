package com.delicacy.orange.java.design.singleton;

/**
 * 解决：一个全局使用的类频繁地创建与销毁
 * @author yutao
 * @create 2019-12-31 9:54
 **/
public class SingletonDemo {
    public static void main(String[] args) {
        //获取唯一可用的对象
        Singleton object = Singleton.getInstance();
        //显示消息
        object.showMessage();
    }
}

 class Singleton {

    //创建 Singleton 的一个对象
    private static Singleton instance = new Singleton();

    //让构造函数为 private，这样该类就不会被实例化
    private Singleton(){}

    //获取唯一可用的对象
    public static Singleton getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
