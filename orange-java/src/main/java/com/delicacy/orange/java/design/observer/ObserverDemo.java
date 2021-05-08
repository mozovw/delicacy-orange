package com.delicacy.orange.java.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决：一个对象状态改变给其他对象通知的问题
 * 关键：类中建立集合存储观察者，实现新增方法和遍历方法
 * @author zyt
 * @create 2018-05-28 18:10
 **/
public class ObserverDemo {
    public static void main(String[] args) {
        Transporter transporter = new Transporter();

        Watcher police = new Police();
        Watcher security = new Security();
        Watcher thief = new Thief();

        transporter.addWatcher(thief);
        transporter.addWatcher(police);
        transporter.addWatcher(security);

        transporter.notifyWatchers();
    }

}

interface Watcher {
     void update();
}

interface Watched {
     void addWatcher(Watcher watcher);
     void notifyWatchers();
}

class Security implements Watcher {
    @Override
    public void update() {
        System.out.println("运输车有行动，保安贴身保护");
    }
}

class Thief implements Watcher {
    @Override
    public void update() {
        System.out.println("运输车有行动，强盗准备动手");
    }
}

class Police implements Watcher {
    @Override
    public void update() {
        System.out.println("运输车有行动，警察护航");
    }
}


class Transporter implements Watched {
    private List<Watcher> list = new ArrayList<>();
    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }
    @Override
    public void notifyWatchers() {
        for (Watcher watcher : list) {
            watcher.update();
        }
    }

}
