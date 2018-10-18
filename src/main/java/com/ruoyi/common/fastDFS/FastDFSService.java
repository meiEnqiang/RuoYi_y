package com.ruoyi.common.fastDFS;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author MeiEnQiang
 * @date 2018/10/15/0015
 */
public interface FastDFSService {
    FastDFSFile saveFile(MultipartFile multipartFile);
}
