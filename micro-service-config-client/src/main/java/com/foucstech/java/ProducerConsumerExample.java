package com.foucstech.java;

/**
 * @author wuandong
 * @classname ProducerConsumerExample
 * @date 2020/3/24 14:16
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
