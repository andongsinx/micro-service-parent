package com.foucstech;

import com.foucstech.kafka.data.Message;
import com.foucstech.kafka.producer.KafkaProducer;
import com.foucstech.listen.UserApplicationEventPublisher;
import com.foucstech.listen.UserInfoEvent;
import com.foucstech.mybatis.mapper.MicCrovRegionMappingMapper;
import com.foucstech.pojo.UserInfo;
import com.sun.xml.internal.ws.api.model.MEP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuandong on 2019/12/21.
 */
@RestController
public class ProviderController {

    @Autowired
    private KafkaProducer<Message> producer;

    @Autowired
    private UserApplicationEventPublisher publisher;

    @Autowired
    private MicCrovRegionMappingMapper mappingMapper;

    @RequestMapping("/provider")
    public String provider() {
        System.out.println("provider request....");
        UserInfo userinfo = new UserInfo(1L, "wuandong", "18895707655", "799024967@qq.com");
        publisher.publish(new UserInfoEvent("origion source", userinfo));
        return "provider";
    }

    @RequestMapping("/provider-kafka")
    public String kafkaSender() {
        mappingMapper.queryAll();
        Message message = new Message();
        message.setMsg("success");
        message.setTimestamp(System.currentTimeMillis());
        message.setData("send a message.......");
        producer.send(message);
        return "success";
    }

}
