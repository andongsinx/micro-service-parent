package com.foucstech.listen;

import com.foucstech.pojo.UserInfo;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author wuandong
 * @classname UserApplicationEventPushListener
 * @date 2020/5/4 11:16
 */
@Component
public class UserApplicationEventPublisher implements ApplicationEventPublisherAware {
    ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(UserInfoEvent event){
        applicationEventPublisher.publishEvent(event);
    }


}
