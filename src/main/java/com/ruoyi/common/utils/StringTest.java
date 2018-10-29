package com.ruoyi.common.utils;

import com.ruoyi.common.fastDFS.FastDFSFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author MeiEnQiang
 * @date 2018/10/29/0029
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StringTest {
    @Test
    public void getFastDFSFileByFilePath(){
        FastDFSFile fastDFSFile = new FastDFSFile();
        String filePath = "http://10.10.30.168:80/group1/M00/00/00/CgoeqFvS0nmAc6OnAAA-jBaDz58543.jpg";
        if(StringUtils.isNotEmpty(filePath)){
            int i = filePath.lastIndexOf("/");
            String[] i1 = filePath.split("/",5);
            //String s1 = filePath.in(filePath,"/");
            String s = filePath.substring(i);
            System.out.println(filePath);
        }
    }
}
