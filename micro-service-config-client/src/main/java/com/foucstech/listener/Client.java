package com.foucstech.listener;

/**
 * @Classname Client
 * @Description TODO
 * @Date 2020/1/21 10:51
 * @Create by wuandong
 */
public class Client {

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.addListener(event -> event.doEvent());
        eventSource.notifyListener(new EventObject("event object"));
    }
}
