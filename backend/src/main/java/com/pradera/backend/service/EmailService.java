package com.pradera.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pradera.backend.model.UserDAO;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailService {
    private static final String NO_REPLY_ADDRESS = "noreply@pradera.com";

    private final JavaMailSender emailSender;

    private final FreeMarkerConfigurer freeMarkerConfigurer;

    private final ObjectMapper objectMapper;

    public void sendSimpleEmail(String to, String subject, String text) {
        //TODO: From not working. Evaluate if we can change the username of email configuration to no-reply email.
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(NO_REPLY_ADDRESS);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendCreatedAccountEmail(UserDAO user) throws MessagingException, IOException, TemplateException {
        Template freemarkerTemplate = freeMarkerConfigurer.getConfiguration()
                .getTemplate("new-user.ftl");
        String htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerTemplate, objectMapper.convertValue(user, Map.class));

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(NO_REPLY_ADDRESS);
        helper.setTo("ecolan.h@gmail.com");
        helper.setSubject("FreeMarker email");
        helper.setText(htmlBody, true);
//        helper.addInline("attachment.png", resourceFile);
        emailSender.send(message);
    }

}
