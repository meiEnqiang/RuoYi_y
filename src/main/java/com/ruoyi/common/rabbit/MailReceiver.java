package com.ruoyi.common.rabbit;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.mail.MailParameters;
import com.ruoyi.common.mail.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author MeiEnQiang
 * @date 2018/10/10/0010
 */
@Component
@RabbitListener(queues = "mail")
public class MailReceiver {
    @Autowired
    private MailService mailService;
    @RabbitHandler
    public void process(MailParameters mailParameters) {
        mailService.sendAttachmentsMail(mailParameters.getTo(),mailParameters.getSubject(),mailParameters.getContent(),mailParameters.getFilePaths());
    }
}
