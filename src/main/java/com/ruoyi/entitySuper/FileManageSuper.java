package com.ruoyi.entitySuper;

import com.ruoyi.entity.FileManage;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author MeiEnQiang
 * @date 2018/10/26/0026
 */
@Data
public class FileManageSuper {
    private MultipartFile file;
    private FileManage fileManage;
}
