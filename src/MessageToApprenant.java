import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class MessageToApprenant {
    public static void go() throws MessagingException, IOException {
        //authentication info
        final String username = "";
        final String password = "";


        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });
        //Start our mail message
        Formateur.brief_email.forEach((e) -> {
            Message message = null;
            try {
                message = prepareMessage(session, username,e);
            } catch (MessagingException ex) {
                throw new RuntimeException(ex);
            }
            try {
                Transport.send(message);
            } catch (MessagingException ex) {
                throw new RuntimeException(ex);
            }
        });

    }
    private static Message prepareMessage(Session session, String username, String toEmail) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject("NOUVEAU BRIEF");
        message.setText("Votre formateur/formatrice a assigné en "+Formateur.info_brief.get(4)+" le Brief "+Formateur.info_brief.get(2));
        return  message;
    }
}

