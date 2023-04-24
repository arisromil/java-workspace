package email;

import java.util.Properties;

public class SendEmail {

    private void start() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.somewhere.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true")
        Session session = Session.getInstance(properties, new javax.mail.
                Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("username", "password");
            }
        });
        session.setDebug(true);
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("someone@somewhere.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress
                    ("someone@somewhere.com"));
            message.setSubject("Subject");
            message.setContent("This is a test message", "text/plain");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
