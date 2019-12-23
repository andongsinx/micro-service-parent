package com.foucstech;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by wuandong on 2019/12/21.
 */
@Service
@FeignClient("zk-server")
public interface IConsumerService {

    @GetMapping("/provider")
    String getList();

}
