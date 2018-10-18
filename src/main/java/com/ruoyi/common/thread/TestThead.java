package com.ruoyi.common.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

/**
 * @author MeiEnQiang
 * @date 2018/10/17/0017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestThead {
    @Test
    public void aa(){
        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                    4, 200, TimeUnit.MILLISECONDS,
                    new ArrayBlockingQueue<Runnable>(2),new ThreadPoolExecutor.CallerRunsPolicy());
            for (int i = 0; i < 11; i++) {
                int num = i;
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("正在執行task" + Thread.currentThread().getName());

                        System.out.println("task:" +  Thread.currentThread().getName()+ "執行結束");
                    }
                });
            }
            executor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
