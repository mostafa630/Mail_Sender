package com.example.mailsender;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Properties;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SenderController {
    @FXML
    TextField  mailReceiver ;
    @FXML
    TextField subject;
    @FXML
    TextArea body ;
    Session session;
    String mail;
    String password;
    public SenderController()
    {
      Properties properties = new Properties();
      properties.put("mail.smtp.auth","true");
      properties.put("mail.smtp.starttls.enable","true");
      properties.put("mail.smtp.host","smtp.gmail.com");
      properties.put("mail.smtp.port","587");
      mail ="mail";
      password="pass";
      session= Session.getInstance(properties, new Authenticator() {
          @Override
          protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(mail ,password);
          }
      });
    }
    public void onSend() throws MessagingException {
        Message message =new MimeMessage(session);
        message.setFrom(new InternetAddress(mail));
        String receiver =mailReceiver.getText();
        message.setRecipient(Message.RecipientType.TO , new InternetAddress(receiver));
        message.setSubject(subject.getText());
        message.setText(body.getText());
        Transport.send(message);
    }
}