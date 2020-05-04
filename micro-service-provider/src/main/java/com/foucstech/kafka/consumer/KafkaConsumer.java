package com.foucstech.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author wuandong
 * @classname KafkaConsumer
 * @date 2020/5/4 15:50
 */
@Component
@Slf4j
public class KafkaConsumer {

    private static final String TOPIC = "kafka_topic";

    @KafkaListener(topics = {TOPIC})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> optional = Optional.ofNullable(record.value());
        if (optional.isPresent()) {
            Object message = optional.get();
            log.info("--------record:{}---------", record);
            log.info("--------message:{}--------", message);
        }

    }


}
