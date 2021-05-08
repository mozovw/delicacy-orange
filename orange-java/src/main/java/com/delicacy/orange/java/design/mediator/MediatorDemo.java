package com.delicacy.orange.java.design.mediator;

import java.util.Date;

/**
 * 解决：想通过一个中间类来封装多个类中的行为，而又不想生成太多的子类。
 * 关键：行为封装到一个类中单独处理。
 * @author yutao
 * @create 2019-12-20 10:48
 **/
public class MediatorDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}


class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString()
                + " [" + user.getName() + "] : " + message);
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}

