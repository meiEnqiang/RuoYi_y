package com.ruoyi.common.rabbit;

import com.ruoyi.project.test.teacher.domain.Teacher;
import com.ruoyi.project.test.teacher.service.TeacherService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author MeiEnQiang
 * @date 2018/10/10/0010
 */
@Component
@RabbitListener(queues = "teacher")
public class HelloReceiver1 {
    @Autowired
    TeacherService teacherService;
    @RabbitHandler
    public void process(Teacher teacher) {
        System.out.println("object  : " + teacher.toString());
        teacherService.save(teacher);
    }
}
