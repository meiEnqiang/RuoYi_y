package com.ruoyi.common.interceptor;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author MeiEnQiang
 * @date 2018/9/17/0017
 */
@Data
public class InDto {
    /**
     * 版本号
     *一般为固定的，主要是为了和Action进行凭借识别对应的controller
     */
    private String version;
    /**
     * 方法包名
     */
    private String action;
    /**
     * 方法名
     */
    private String method;
    /**
     * 时间戳
     */
    private String timeStamp;
    /**
     * 请求参数
     */
    private String req;
    /**
     * 接口请求request
     */
    private HttpServletRequest request;
    /**
     * 接口请求response
     */
    private HttpServletResponse response;
    /**
     * 注入
     */
    private Object dao;
    //构造函数
    public InDto(Map<String,String[]> map) throws IOException {
        this.version=map.get("Version")!=null?map.get("Version")[0]:"";
        this.action=map.get("Action")!=null?map.get("Action")[0]:"";
        this.method=map.get("Method")!=null?map.get("Method")[0]:"";
        this.timeStamp=map.get("TimeStamp")!=null?map.get("TimeStamp")[0]:"";
        this.req=map.get("Req")!=null?map.get("Req")[0]:"";

    }


}
