package com.ruoyi.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.system.user.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author MeiEnQiang
 * @date 2018/9/17/0017
 */
public class DataSyncInterceptor implements HandlerInterceptor {
    /**
     * @描述 验证用户名密码是否正确
     */
    public OutDto testLegal(HttpServletRequest request) throws Exception {
        //实例化一个InDto，同时获得了客户端传来的信息
        InDto inDto=new InDto(request.getParameterMap());
        JSONObject reqJSON = JSON.parseObject(inDto.getReq());
        String action = inDto.getAction();//获取到请求的Action
        OutDto outDto=new OutDto();
        if("login".equals(action)){//如果是登录进行验证
            String userName = reqJSON.getString("userName");
            String userPwd = reqJSON.getString("userPwd");
            if("admin".equals(userName) && "123456".equals(userPwd)){
                outDto.setStatusFail();
                outDto.setMsg("用户名或密码不正确！");
            }else{
                outDto.setStatusSuccess();
            }
            return outDto;
        }
        return null;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object o) throws Exception {
        //请求参数注入InDto
        OutDto outDto=new OutDto();
        try {
            InDto inDto=new InDto(request.getParameterMap());
            //设置验证结果,先不走验证非法，直接返回成功
            outDto = testLegal(request);
            //参数验证结果成功后，执行下面的拦截器
            if(OutDto.STATUS_SUCCESS.equals(outDto.getStatus())){
                return true;
            }else{
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                //out.print(JsonUtil.object2json(outDto));
                out.print(JSONObject.toJSON(outDto));
                out.close();
                return false;
            }
        } catch (Exception e) {
            response.setCharacterEncoding("UTF-8");
            outDto.setStatus(OutDto.STATUS_EXCEPTION);//异常时
            PrintWriter out = response.getWriter();
            //out.print(JsonUtil.object2json(outDto));
            out.print(JSONObject.toJSON(outDto));
            e.printStackTrace();
            out.close();
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }
}
