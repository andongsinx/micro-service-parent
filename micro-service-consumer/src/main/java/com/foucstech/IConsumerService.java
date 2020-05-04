package com.foucstech;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by wuandong on 2019/12/21.
 */
@Service
@FeignClient("micro-provider")
public interface IConsumerService {
    /**
     * 获取列表
     * @return
     */
    @GetMapping("/provider")
    String getList();

}
