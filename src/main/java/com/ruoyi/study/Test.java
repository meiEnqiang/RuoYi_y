package com.ruoyi.study;

import com.google.common.collect.Lists;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author MeiEnQiang
 * @date 2018/11/2/0002
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @org.junit.Test
    public void s1(){
        int num = 100;
        for (int i = 1; i <= num; i++) {
            if(num % i == 0){
                System.out.println(i + " x " + num / i + " = " + num);
            }
        }
    }
    @org.junit.Test
    public void s2(){
        int num = 100;
        List<Integer> list1 = Lists.newArrayList();
        //List<Integer> list2 = Lists.newArrayList();
        for (int i = 1; i <= num; i++) {
            boolean flage = true;
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    //list2.add(i);
                    flage = false;
                    break;
                }
            }
            if(flage){
                list1.add(i);
            }
        }
        System.out.println("==========基数============");
        for (int integer : list1) {
            System.out.print(integer + " ");
            if(integer == list1.get(list1.size()-1)){
                System.out.println();
            }
        }
        System.out.println("======================");
    }
    @org.junit.Test
    public void s3(){
        int i = Integer.MAX_VALUE;
        System.out.println(i*4);
    }
}
