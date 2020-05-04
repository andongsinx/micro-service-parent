package com.foucstech;

import com.foucstech.listen.UserApplicationEventPublisher;
import com.foucstech.listen.UserInfoEvent;
import com.foucstech.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuandong on 2019/12/21.
 */
@RestController
public class ProviderController {

    @Autowired
    private UserApplicationEventPublisher publisher;
    @RequestMapping("/provider")
    public String provider() {
        System.out.println("provider request....");
        UserInfo userinfo = new UserInfo(1L, "wuandong", "18895707655", "799024967@qq.com");
        publisher.publish(new UserInfoEvent("origion source",userinfo));
        return "provider";
    }

}
