package com.ruoyi.common.mail;

import java.util.List;

/**
 * @author MeiEnQiang
 * @date 2018/10/11/0011
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);

    void sendSimpleTemplateMail(String to, String subject, SimpleTemplateParameters parameters);

    void sendAttachmentsMail(MailParameters mailParameters);
}
