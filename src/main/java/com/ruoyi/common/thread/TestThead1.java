package com.ruoyi.common.thread;

/**
 * @author MeiEnQiang
 * @date 2018/10/17/0017
 */
public class TestThead1 implements Runnable {
    private Integer i;
    public TestThead1(Integer i){
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("=========>" + i);
       /* for(int k = 1 ;k <= i;k++){
            System.out.println("TestThead1======>" + k);
        }*/
    }
}
