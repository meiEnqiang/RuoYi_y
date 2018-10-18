package com.ruoyi.common.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author MeiEnQiang
 * @date 2018/10/11/0011
 */
@Component
public class MailServiceImpl implements MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender mailSender;
    @Value("${mail.fromMail.addr}")
    private String from;
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(new InternetAddress(from, MimeUtility.encodeText("邮件测试")));
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            mailSender.send(message);
            logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
        }
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, List<String> filePaths) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            StringBuilder stringBuilder = new StringBuilder();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(new InternetAddress(from, MimeUtility.encodeText("邮件测试")));
            helper.setTo(to);
            helper.setSubject(subject);
            stringBuilder.append("<html><body>").append(content).append("<br/>");
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
}
