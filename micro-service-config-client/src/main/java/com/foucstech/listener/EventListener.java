package com.foucstech.listener;

/**
 * @Classname EventListener
 * @Description TODO
 * @Date 2020/1/21 9:40
 * @Create by wuandong
 */
public interface EventListener<E extends EventObject> extends java.util.EventListener {


    void handleEvent(E event);

}
