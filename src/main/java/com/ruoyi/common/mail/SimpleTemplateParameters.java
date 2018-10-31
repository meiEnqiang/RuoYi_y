package com.ruoyi.common.mail;

import lombok.Data;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author MeiEnQiang
 * @date 2018/10/30/0030
 */
@Data
public class SimpleTemplateParameters implements Serializable {
    /**
     * 表格抬头
     */
    private String headline;
    /**
     * 表格标题
     */
    private List<String> titleList;
    /**
     * 表格内容
     */
    private List<List<String>> resultList;
    /**
     * 外加定义内容
     */
    private Map<String,Object> map;
    /**
     * 模板名字
     */
    private String emailTemplate;
    /**
     * 一般文本内容
     */
    private String content;
}
