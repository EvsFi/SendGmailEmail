package data.structures;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

public class SendGmailEmail {
    public void send(String from,String password,String to,String sub,String msg){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
//            message.setText(msg);

            MimeMultipart multipart = new MimeMultipart();

            MimeBodyPart emailBody = new MimeBodyPart();
            emailBody.setText(msg);
            multipart.addBodyPart(emailBody);

            MimeBodyPart image = new MimeBodyPart();
            DataSource imageSource = new FileDataSource("Address_1");
            image.setDataHandler(new DataHandler(imageSource));
            image.setHeader("Contend-ID", "<image>");
            multipart.addBodyPart(image);

            MimeBodyPart attachment = new MimeBodyPart();
            attachment.attachFile("Address_2");
            multipart.addBodyPart(attachment);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException | IOException e) {throw new RuntimeException(e);}
    }
}
