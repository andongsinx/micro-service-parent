package com.foucstech;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author wuandong
 * @classname CustomApplicationContextInitializer
 * @date 2020/4/1 16:16
 */
public class CustomApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("com.foucstech.CustomApplicationContextInitializer");
    }
}
