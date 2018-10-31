package com.ruoyi.common.mail;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ruoyi.common.rabbit.HelloSender;
import com.ruoyi.project.test.student.domain.Student;
import com.ruoyi.project.test.student.response.GetStudentResponse;
import com.ruoyi.project.test.student.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.Map;

/**
 * @author MeiEnQiang
 * @date 2018/10/11/0011
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    private MailService mailService;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private StudentService studentService;
    @Test
    public void testSimpleMail() throws Exception {
        /*Student student = new Student();
        student.setName("刘三");
        student.setPwd("123");
        student.setAccount("789");
        student.setCreateDate(new Date());
        studentService.save(student);
        Pageable pageable = PageRequest.of(1,2,new Sort(Sort.Direction.ASC,"id"));
        List<Student> studentList = studentService.findAll();
        Page<Student> studentList0 = studentService.findAll(pageable);
        List<Student> list = studentList0.getContent();
        List<Student> studentList1 = studentService.findByNameLike("张");
        List<Student> studentList2 = studentService.findByNameLike("三");
        List<Student> studentList3 = studentService.findByNameLike("张三");
        Student student1 = studentService.findByName("张");*/
        //studentService.updateByName("赵六","刘三");
        Pageable pageable = PageRequest.of(1,2,new Sort(Sort.Direction.ASC,"id"));
        Page<GetStudentResponse> page = studentService.find(pageable);
        List<GetStudentResponse> responseList = page.getContent();
        for(GetStudentResponse getStudentResponse : responseList){
            Student student = getStudentResponse.getStudent();
            System.out.println("id：" + student.getId());
            System.out.println("学生姓名：" + student.getName());
            System.out.println("老师名字：" + getStudentResponse.getTeacherName());
        }
       /* Teacher teacher = new Teacher();
        teacher.setName("梅老师");
        teacherService.save(teacher);*/
        /*List<Teacher> list = teacherService.findAll();
        Teacher teacher = new Teacher();
        for(int i = 1;i<= 100000;i++){
            teacher.setName("测试" + i);
            teacher.setCreateDate(new Date());
            //helloSender.send(i);
            //helloSender.sendB(i);
            //helloSender.sendFanout(i);
            helloSender.sendEntity(teacher);
        }*/
        Context context = new Context();
        context.setVariable("id","006");
        context.setVariable("headline","测试标题");
        List<String> titleList = Lists.newArrayList("姓名","内容");
        context.setVariable("titleList",titleList);
        List<List<String>> resultList = Lists.newArrayList();
        List<String> resultList1 = Lists.newArrayList("张三","50");
        List<String> resultList2 = Lists.newArrayList("李四","60");
        List<String> resultList3 = Lists.newArrayList("王五","70");
        List<String> resultList4 = Lists.newArrayList("赵六","80");
        resultList.add(resultList1);
        resultList.add(resultList2);
        resultList.add(resultList3);
        resultList.add(resultList4);
        context.setVariable("resultList",resultList);
        String emailContent = templateEngine.process("emailTemplate",context);
        mailService.sendSimpleMail("m17683837392@163.com", "模板邮件测试", emailContent);
        //List<String> filePaths = Lists.newArrayList("D:\\gif\\11.jpg","C:\\Users\\Administrator\\Desktop\\工作\\定位监测系统接口文档.docx");
        List<String> filePaths = Lists.newArrayList("D:\\gif\\11.jpg","D:\\gif\\test4.jpg","C:\\Users\\Administrator\\Desktop\\工作\\定位监测系统接口文档.docx");
        //mailService.sendAttachmentsMail("m17683837392@163.com", "邮件测试", emailContent,filePaths);
        //helloSender.sendMail("m17683837392@163.com","邮件测试",emailContent,filePaths);
    }
}
