package com.foucstech.listen;

import com.foucstech.pojo.UserInfo;
import org.springframework.context.ApplicationEvent;

/**
 * @author wuandong
 * @classname UserInfoEvent
 * @date 2020/5/4 11:15
 */
public class UserInfoEvent extends ApplicationEvent {

    private UserInfo userInfo;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public UserInfoEvent(Object source,UserInfo userInfo) {
        super(source);
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

}
