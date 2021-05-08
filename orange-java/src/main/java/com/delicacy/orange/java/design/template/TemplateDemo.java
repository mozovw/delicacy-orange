package com.delicacy.orange.java.design.template;

/**
 * 解决：方法通用
 * 关键：行为由父类控制，子类实现
 * @author yutao
 * @create 2019-12-20 9:55
 **/
public class TemplateDemo {
    public static void main(String[] args) {
        Game game = new Football();
        game.play();
    }
}
abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}
