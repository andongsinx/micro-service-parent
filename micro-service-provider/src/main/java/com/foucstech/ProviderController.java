package com.foucstech;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuandong on 2019/12/21.
 */
@RestController
public class ProviderController {

    @RequestMapping("/provider")
    public String provider() {
        System.out.println("provider request....");
        return "provider";
    }

}
