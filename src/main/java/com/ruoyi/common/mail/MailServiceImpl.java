package com.ruoyi.common.mail;

import com.ruoyi.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author MeiEnQiang
 * @date 2018/10/11/0011
 */
@Component
public class MailServiceImpl implements MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Value("${mail.fromMail.addr}")
    private String from;
    @Value("${mail.fromMail.fromName}")
    private String fromName;
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = repetitionCode(to, subject,message);
            helper.setText(content,true);
            mailSender.send(message);
            logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
        }
    }

    @Override
    public void sendSimpleTemplateMail(String to, String subject, SimpleTemplateParameters parameters) {
        sendSimpleMail(to, subject, getEmailContent(parameters));
    }

    @Override
    public void sendAttachmentsMail(MailParameters mailParameters) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = repetitionCode(mailParameters.getTo(), mailParameters.getSubject(), message);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<html><body>").append(mailParameters.getContent()).append("<br/>");
            SimpleTemplateParameters parameters = mailParameters.getParameters();
            if(parameters != null){
                String emailContent = getEmailContent(parameters);
                stringBuilder.append(emailContent).append("<br/>");
            }
            List<String> filePaths = mailParameters.getFilePaths();
            if(filePaths != null){
                for(String filePath : filePaths){
                    if(isPicture(filePath)){
                        String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
                        stringBuilder.append("<img src=\'cid:").append(fileName).append("\'/>").append("<br/>");
                    }
                }
            }
            stringBuilder.append("</body></html>");
            helper.setText(stringBuilder.toString(), true);
            if(filePaths != null){
                for(String filePath : filePaths){
                    FileSystemResource file = new FileSystemResource(new File(filePath));
                    String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
                    helper.addAttachment(fileName, file);
                    if(isPicture(filePath)){
                        helper.addInline(fileName,file);
                    }
                }
            }
            mailSender.send(message);
            logger.info("带附件的邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送带附件的邮件时发生异常！", e);
        }
    }
    private boolean isPicture(String filePath){
        String tmpName = filePath.substring(filePath.lastIndexOf(".") + 1);
        return "png".equals(tmpName) || "jpg".equals(tmpName);
    }
    private MimeMessageHelper repetitionCode(String to, String subject,MimeMessage message) throws Exception {
        //true表示需要创建一个multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName)));
        helper.setTo(to);
        helper.setSubject(subject);
        return helper;
    }
    private String getEmailContent(SimpleTemplateParameters parameters){
        Context context = new Context();
        context.setVariable("titleList", parameters.getTitleList());
        context.setVariable("resultList", parameters.getResultList());
        context.setVariable("headline", parameters.getHeadline());
        String emailTemplate = parameters.getEmailTemplate();
        if(StringUtils.isEmpty(emailTemplate)){
            emailTemplate = "emailTemplate";
        }
        Map<String,Object> map = parameters.getMap();
        if(map != null && map.size() > 0){
            context.setVariables(map);
        }
        return templateEngine.process(emailTemplate, context);
    }
}
