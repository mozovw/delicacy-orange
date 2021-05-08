package com.delicacy.orange.java.design.prototype;

/**
 * 解决：运行期建立和删除原型
 * 关键：利用已有的一个原型对象，快速地生成和原型对象一样的实例
 * @author yutao
 * @create 2019-12-31 10:36
 **/
public class PrototypeDemo {
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.setId("1");
        Shape clone = (Shape)shape.clone();
        System.out.println(shape.getId());
        System.out.println(clone.getId());
        System.out.println(shape.equals(clone));
    }
}

 class Shape implements Cloneable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
