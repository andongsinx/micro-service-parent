package com.foucstech.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuandong on 2019/12/23.
 */
@RestController
@RefreshScope
public class TestController {


    @Value("${from}")
    private String fromValue;

    @RequestMapping("from")
    public String test() {
        return fromValue;
    }


}
