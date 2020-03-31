package com.foucstech.listener;

/**
 * @Classname EventObject
 * @Description
 * @Date 2020/1/21 9:38
 * @Create by wuandong
 */
public class EventObject extends java.util.EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventObject(Object source) {
        super(source);
    }


    public void doEvent() {
        System.out.println("invoke event :" + getSource());
    }
}
