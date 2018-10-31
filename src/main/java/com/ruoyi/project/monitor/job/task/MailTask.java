package com.ruoyi.project.monitor.job.task;

import com.google.common.collect.Lists;
import com.ruoyi.common.mail.MailParameters;
import com.ruoyi.common.mail.SimpleTemplateParameters;
import com.ruoyi.common.rabbit.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author MeiEnQiang
 * @date 2018/10/30/0030
 */
@Component("mailTask")
public class MailTask {
    @Autowired
    private MailSenderService mailSenderService;
    public void sendMail(String email) {
        SimpleTemplateParameters parameters = new SimpleTemplateParameters();
        parameters.setHeadline("测试标题");
        List<String> titleList = Lists.newArrayList("姓名","内容");
        parameters.setTitleList(titleList);
        List<List<String>> resultList = Lists.newArrayList();
        List<String> resultList1 = Lists.newArrayList("张三","50");
        List<String> resultList2 = Lists.newArrayList("李四","60");
        List<String> resultList3 = Lists.newArrayList("王五","70");
        List<String> resultList4 = Lists.newArrayList("赵六","80");
        resultList.add(resultList1);
        resultList.add(resultList2);
        resultList.add(resultList3);
        resultList.add(resultList4);
        parameters.setResultList(resultList);
        //mailService.sendSimpleTemplateMail(email, "模板邮件测试", parameters);
        MailParameters mailParameters = new MailParameters();
        mailParameters.setParameters(parameters);
        mailParameters.setTo(email);
        mailParameters.setSubject("邮件测试");
        mailParameters.setContent("没事邮件测试");
        //List<String> filePath = Lists.newArrayList("D:\\c_d\\Desktop\\工作\\包租房电费.xlsx","D:\\c_d\\Desktop\\工作\\Ubuntu命令.txt","D:\\gif\\11.jpg");
        //mailParameters.setFilePaths(filePath);
        mailSenderService.sendMail(mailParameters);
    }
}
