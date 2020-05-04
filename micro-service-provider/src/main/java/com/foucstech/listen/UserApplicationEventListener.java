package com.foucstech.listen;

import com.foucstech.pojo.UserInfo;
import org.junit.internal.runners.statements.RunBefores;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @author wuandong
 * @classname UserApplicationEventListener
 * @date 2020/5/4 11:16
 */
@Component
public class UserApplicationEventListener implements ApplicationListener<UserInfoEvent> {
    ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
    final ExecutorService executor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.DAYS,queue, (r, executor) -> {
        System.out.println("queue is full....");
        new Thread(r).start();
    });
    @Override
    public void onApplicationEvent(UserInfoEvent event) {
            executor.execute(() -> {
                    UserInfo userInfo = event.getUserInfo();
                    System.out.println(event.getSource());
                    System.out.println("send message:"+userInfo.toString());
            });


    }
}
