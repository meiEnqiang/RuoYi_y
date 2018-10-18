package com.ruoyi.common.fastDFS;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author MeiEnQiang
 * @date 2018/10/15/0015
 */
@Service
public class FastDFSServiceImpl implements FastDFSService {
    @Override
    public FastDFSFile saveFile(MultipartFile multipartFile) {
        try {
            String[] fileAbsolutePath={};
            String fileName=multipartFile.getOriginalFilename();
            assert fileName != null;
            String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
            byte[] fileBuff = null;
            InputStream inputStream=multipartFile.getInputStream();
            if(inputStream!=null){
                int len1 = inputStream.available();
                fileBuff = new byte[len1];
                inputStream.read(fileBuff);
            }
            inputStream.close();
            FastDFSFile file = new FastDFSFile(fileName, fileBuff, ext);
            return FastDFSClient.upload(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
