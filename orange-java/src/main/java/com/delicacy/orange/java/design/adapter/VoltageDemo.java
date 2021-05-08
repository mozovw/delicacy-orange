package com.delicacy.orange.java.design.adapter;

/**
 * 1、在美国使用中国的电器需要变压器
 * 2、关键：美国电压需要继承变压器，输出中国电压
 * @author zyt
 * @create 2018-05-28 17:10
 **/
public class VoltageDemo {
    public static void main(String[] args) {
        USATransform usaTransform = new USATransform();
        System.out.println(usaTransform.voltage());
        System.out.println(usaTransform.transform("cha"));
        CHATransform chaTransform = new CHATransform();
        System.out.println(chaTransform.voltage());
        System.out.println(chaTransform.transform("usa"));
    }
}

//中国电压
class CHAVoltage implements Voltage{
    public Integer voltage() {
        return 220;
    }
}

//美国电压
class USAVoltage implements Voltage{
    public Integer voltage() {
        return 110;
    }
}

//电压
interface Voltage {
    Integer voltage();
}

//变压器
interface Transformer {
    Integer transform(String key);
}

//美国
class USATransform extends USAVoltage implements Transformer {
    public Integer transform(String key) {
        if (key=="cha"){
            return this.voltage()+110;
        }
        return this.voltage();
    }
}

//中国
class CHATransform extends CHAVoltage implements Transformer {
    public Integer transform(String key) {
        if (key=="usa"){
            return this.voltage()-Integer.valueOf("110");
        }
        return this.voltage();
    }
}
