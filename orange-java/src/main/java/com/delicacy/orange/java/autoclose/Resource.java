package com.delicacy.orange.java.autoclose;

/**
 * @author zyt
 * @create 2018-06-05 13:36
 **/
public class Resource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("resource closed");
    }

    public void read(){
        System.out.println("resource read");
    }

}
