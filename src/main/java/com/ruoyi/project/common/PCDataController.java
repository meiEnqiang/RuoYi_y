package com.ruoyi.project.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.ruoyi.common.interceptor.InDto;
import com.ruoyi.common.interceptor.OutDto;
import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * @author MeiEnQiang
 * @date 2018/9/13/0013
 */
@RestController
@RequestMapping("/api/pc")
public class PCDataController {
    @ResponseBody
    @RequestMapping("interface/getAlertInfoByTagMac")
    public Map<String,Object> getAlertInfoByHostID(String hostID){
        Map<String,Object> map = Maps.newHashMap();
        boolean isTrue = false;
        String error = "";
        if("test".equals(hostID)){
            isTrue = true;
            error = "测试成功！！";
        }else {
            error = "访问失败";
        }
        map.put("success",isTrue);
        map.put("ErrorText",error);
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "interface/test",method = RequestMethod.POST,consumes = "application/json")
    public Map<String,Object> test(HttpServletRequest request){
        Map<String,Object> map = Maps.newHashMap();
        boolean isTrue = false;
        String error ;
        try {
            String data = IOUtils.toString(request.getInputStream(),"utf-8");
            JSONObject jsonObject = JSONObject.parseObject(data);
            if("test".equals(jsonObject.getString("test"))){
                isTrue = true;
                error = "测试成功";
            }else {
                error = "访问失败";
            }
        } catch (IOException e) {
            e.printStackTrace();
            error = e.getMessage();
        }
        map.put("success",isTrue);
        map.put("ErrorText",error);
        return map;
    }

    @RequestMapping({"interface/dataSync"})
    @ResponseBody
    public void dataSync(HttpServletRequest request, HttpServletResponse response) {
        OutDto outDto = new OutDto();
        try {
            InDto inDto=new InDto(request.getParameterMap());
            inDto.setRequest(request);
            inDto.setResponse(response);
            String method = inDto.getMethod();
            /*if(StringUtils.isBlank(method)){
                method=AtcConstant.getAtcClassMethod();
            }*/
            //依据action和method，然后读取配置中的类反射执行该class
            //Object bean = ApplicationContext.getBean(inDto.getAction()+inDto.getVersion());
            //outDto=(OutDto) ReflectUtil.invoke(bean,method, inDto,outDto);
        } catch (Exception e) {
            outDto.setStatus(OutDto.STATUS_EXCEPTION);
            e.printStackTrace();
        }
        try {
            //返回的结构为字节流是调用，为移动端做附件下载时使用
            if ("返回流".equals(outDto.getMsg())) {
                OutputStream outputStream=response.getOutputStream();
                InputStream is=new FileInputStream(outDto.getData().toString());
                byte b[] = new byte[1024];
                int len = -1;
                while ((len = is.read(b)) != -1){
                    outputStream.write(b, 0, len);
                }
                is.close();
                outputStream.close();
            }else { 	//非字节流结果返回时调用
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                //out.print(JsonUtil.object2json(outDto));
                out.print(JSONObject.toJSON(outDto));
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
