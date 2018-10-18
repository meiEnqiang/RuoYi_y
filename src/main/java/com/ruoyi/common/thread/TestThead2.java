package com.ruoyi.common.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MeiEnQiang
 * @date 2018/10/17/0017
 */
public class TestThead2 extends Thread{
    private int i;
    private String str;
    public TestThead2(int i,String str){
        this.i = i;
        this.str = str;
    }
    @Override
    public void run(){
        for(int k = 1 ;k <= i;k++){
            try {
                //sleep(1000);
                System.out.println("Thead" + str + "======>" + k + " " + (new SimpleDateFormat("yyyy.MM.dd HH:mm:ss")).format(new Date()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
