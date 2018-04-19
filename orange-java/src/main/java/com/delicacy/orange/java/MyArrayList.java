package com.delicacy.orange.java;

import java.util.ArrayList;

/**
 * mylist
 *
 * @author zyt
 * @create 2018-04-18 22:37
 **/
public class MyArrayList<E> {

    ArrayList arrayList = new ArrayList<>();

    private int size;

    public boolean add(E e) {
        //数组容量是够的
       // ensureCapacityInternal(size + 1);  // Increments modCount!!
       // elementData[size++] = e;
        return true;
    }
}
