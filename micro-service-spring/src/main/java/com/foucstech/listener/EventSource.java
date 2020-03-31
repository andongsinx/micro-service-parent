package com.foucstech.listener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname EventSource
 * @Date 2020/1/21 9:39
 * @Create by wuandong
 */
public class EventSource {


    private List<EventListener<?>> listeners = new ArrayList<>();

    public void addListener(EventListener<?> listener) {
        this.listeners.add(listener);
    }

    public void removeListener(EventListener<?> listener) {
        this.listeners.remove(listener);
    }

    public <E extends EventObject> void notifyListener(E eventObject) {
        for (EventListener listener : listeners) {
            listener.handleEvent(eventObject);
        }
    }
}
