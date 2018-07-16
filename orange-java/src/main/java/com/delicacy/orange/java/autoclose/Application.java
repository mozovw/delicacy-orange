package com.delicacy.orange.java.autoclose;

/**
 * @author zyt
 * @create 2018-06-05 13:38
 **/
public class Application {

    public static void main(String[] args) {
        try(Resource resource = new Resource()){
            resource.read();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
