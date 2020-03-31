package com.foucstech.java.reflection;

import com.foucstech.java.concurrent.Drop;

import java.lang.reflect.Array;

/**
 * @author wuandong
 * @classname ObtainClass
 * @date 2020/3/27 15:04
 */
public class ObtainClass {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz= Class.forName("[D");
        double[][] d = (double[][]) Array.newInstance(clazz, 1);
        System.out.println(d);
        /*Class<Integer> integerClass = Integer.class;
        Integer integer = integerClass.newInstance();
        System.out.println(integer);*/
        //Object o = clazz.newInstance();
        //System.out.println(o);
       /* System.out.println(Double.TYPE);
        System.out.println(Double.class.getDeclaredClasses());
        System.out.println(Drop.class.getSuperclass().getDeclaredClasses());
        System.out.println(Object.class.getClasses());*/
        System.out.println( Character.class.getDeclaredClasses()[0]);
        System.out.println( Character.class.getEnclosingClass());
        System.out.println(Character.class.getDeclaringClass());
        System.out.println( Thread.State.class.getEnclosingClass());
    }

}
