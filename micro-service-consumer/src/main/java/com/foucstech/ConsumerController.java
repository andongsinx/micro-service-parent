package com.foucstech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuandong on 2019/12/21.
 */
@RestController
public class ConsumerController {

    @Autowired
    IConsumerService consumerService;

    @RequestMapping("consumer")
    public String consumer() {
        return consumerService.getList();
    }
}
