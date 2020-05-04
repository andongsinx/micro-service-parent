package com.foucstech.kafka.data;

import lombok.Data;

/**
 * @author wuandong
 * @classname Message
 * @date 2020/5/4 15:22
 */
@Data
public class Message<T> {
    private T data;

    private String msg;

    private Long timestamp;



}
