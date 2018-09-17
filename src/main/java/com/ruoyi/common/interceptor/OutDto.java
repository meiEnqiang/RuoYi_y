package com.ruoyi.common.interceptor;

/**
 * @author MeiEnQiang
 * @date 2018/9/17/0017
 */
public class OutDto {
    /**
     * 成功
     */
    public static final String STATUS_SUCCESS="100";
    /**
     * 失败
     */
    public static final String STATUS_FAIL="200";
    /**
     * 服务端异常
     */
    public static final String STATUS_EXCEPTION="300";

    /**
     * 代码标识
     */
    private String status;
    /**
     * 信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;


    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    /**
     * @描述 设置失败状态
     */
    public void setStatusFail() {
        this.status = STATUS_FAIL;
    }
    /**
     * @描述 设置失败状态和消息
     */
    public void setStatusFail(String msg) {
        this.status = STATUS_FAIL;
        this.msg=msg;
    }


    /**
     * @描述 设置成功状态
     */
    public void setStatusSuccess() {
        this.status = STATUS_SUCCESS;
    }
    /**
     * @描述 设置成功状态并插入data数据
     * @author quzf
     */
    public void setStatusSuccess(Object data,String msg) {
        this.status = STATUS_SUCCESS;
        this.data=data;
        this.msg=msg;
    }
    /**
     * @描述 设置成功状态并插入data数据
     */
    public void setStatusSuccess(String msg) {
        this.status = STATUS_SUCCESS;
        this.msg=msg;
        this.data="";
    }
}
