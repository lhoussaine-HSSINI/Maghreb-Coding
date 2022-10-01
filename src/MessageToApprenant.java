import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MessageToApprenant {
    public static void go() throws MessagingException {
        //authentication info
        final String username = "postmaster@sandbox1b37be2fc27f43cf8245faad899dfa58.mailgun.org";
//        final String password = "FaHo1998HssInI1995KaRkach";
        final String password = "a3648d159d460196959f69b5e30cca09-523596d9-0c06dc55";
        String toEmail = "bontop.2018@gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.mailgun.org");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });
        //Start our mail message
        Message message = prepareMessage(session, username,toEmail);
        Transport.send(message);
    }
    private static Message prepareMessage(Session session, String username, String toEmail) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject("Subject Line");
        message.setText("my name is lhoussaine \n howa  ana ana ana");
        return  message;
    }
}

