package com.ruoyi.common.rabbit;

import com.ruoyi.common.mail.MailParameters;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MeiEnQiang
 * @date 2018/10/30/0030
 */
@Service
public class MailSenderService {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void sendMail(MailParameters mailParameters) {
        this.rabbitTemplate.convertAndSend("mail", mailParameters);
    }
}
