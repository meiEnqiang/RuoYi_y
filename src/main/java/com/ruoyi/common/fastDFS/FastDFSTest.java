package com.ruoyi.common.fastDFS;

import com.ruoyi.common.mail.MailService;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author MeiEnQiang
 * @date 2018/10/15/0015
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FastDFSTest {
    @Autowired
    private FastDFSService fastDFSService;
    @Test
    public void saveFile() throws Exception {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            File file = new File("C:\\Users\\Administrator\\Desktop\\工作\\Ubuntu命令.txt");
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
            // IOUtils.toByteArray(input)不识别时，可直接使用上面 FileInputStream 类型的input做第四个参数也是可以的。
            // 例如 MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", input);
            FastDFSFile fastDFSFile = fastDFSService.saveFile(multipartFile);
            System.out.println(fastDFSFile.getFilePath());
            inputStream = FastDFSClient.downFile(fastDFSFile.getFileGroup(),fastDFSFile.getRemoteFileName());
            outputStream = new FileOutputStream(new File("D:\\test\\upload\\" + fastDFSFile.getFileName()));
            int len = 0;
            byte[] buf = new byte[1024];
            while((len = inputStream.read(buf))!=-1) {
                outputStream.write(buf, 0, len);
            }
            //FastDFSClient.deleteFile(fastDFSFile.getFileGroup(),fastDFSFile.getRemoteFileName());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            if(outputStream != null){
                outputStream.flush();
                outputStream.close();
            }
            if(inputStream != null){
                inputStream.close();
            }
        }
    }
    @Test
    public void deleFile() throws Exception{
        FastDFSClient.deleteFile("group1","M00/00/00/CgoeqFvS2BWAJBhPAAAITMFiDjY145.txt");
        FastDFSClient.deleteFile("group1","M00/00/00/CgoeqFvS2EaAdmhsAABfq-2cD6Q05.docx");
        FastDFSClient.deleteFile("group1","M00/00/00/CgoeqFvWYueAcqtmAABFDpamt7M19.xlsx");
        FastDFSClient.deleteFile("group1","M00/00/00/CgoeqFvWYwWAHNBKAAABDNPNLK0246.txt");
    }

}
