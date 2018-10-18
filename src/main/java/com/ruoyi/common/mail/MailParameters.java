package com.ruoyi.common.mail;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author MeiEnQiang
 * @date 2018/10/11/0011
 */
@Data
public class MailParameters implements Serializable {
    private String to;
    private String subject;
    private String content;
    private List<String> filePaths;
}
