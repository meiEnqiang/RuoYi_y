package com.ruoyi.common.rabbit;

import com.google.common.collect.Maps;
import com.ruoyi.common.mail.MailParameters;
import com.ruoyi.project.test.teacher.domain.Teacher;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author MeiEnQiang
 * @date 2018/10/10/0010
 */
@Service
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String context = "发送信息A " + i + "-----" + sdf.format(new Date());
        System.out.println(context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
    public void sendB(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String context = "发送信息B " + i + "-----" + sdf.format(new Date());
        System.out.println(context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
    public void sendFanout(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String context = "广播信息 " + i + "-----" + sdf.format(new Date());
        System.out.println(context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }
    public void sendEntity(Teacher teacher) {
        System.out.println("Sender object: " + teacher.toString());
        this.rabbitTemplate.convertAndSend("teacher", teacher);
    }
    public void sendMail(MailParameters mailParameters) {
        this.rabbitTemplate.convertAndSend("mail", mailParameters);
    }
}
