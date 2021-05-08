package com.delicacy.orange.java.design.state;



/**
 * 解决：对象的行为依赖于它的状态
 * 关键：将各种具体的状态类抽象出来，不同状态会有不同方法处理
 * @author yutao
 * @create 2019-12-20 10:28
 **/
public class StateDemo {
    public static void main(String[] args) {
        Session session = new Session();

        State startState = new StartState();
        startState.setContext(session);
        session.getState().doAction();

        State stopState = new StopState();
        stopState.setContext(session);
        session.getState().doAction();
    }
}
interface State {
    void setContext(Session session);
    void doAction();
}

class StartState implements State {
    public void setContext(Session session) {
        session.setState(this);
    }

    @Override
    public void doAction() {
        System.out.println("start");
    }
}

class StopState implements State {
    public void setContext(Session session) {
        session.setState(this);
    }

    @Override
    public void doAction() {
        System.out.println("stop");
    }
}

class Session {
    private State state;
    public Session() {
        state = null;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }

}
