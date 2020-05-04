package com.foucstech.kafka.producer;

import com.foucstech.kafka.data.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author wuandong
 * @classname KafkaProducer
 * @date 2020/5/4 15:31
 */
@Component
@Slf4j
public class KafkaProducer<T extends Message> {
    @Autowired
    private KafkaTemplate<String, String> template;
    private String topic = "kafka_topic";

    public void send(T data) {
        log.info("kafka send message:{}", data.toString());
        template.send(topic, data.toString());
    }

}
