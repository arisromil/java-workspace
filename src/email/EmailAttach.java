package email;

public class EmailAttach {

    private void start() {
        String host = "smtp.somewhere.com";
        String username = "username";
        String password = "password";
        String from = "someone@somewhere.com";
        String to = "anotherone@somewhere.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new
                javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication
                                (username, password);
                    }
                }
    });

        session.setDebug(true);
    try

    {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new
                InternetAddress(to));
        message.setSubject("Subject");
// Create Mime "Message" part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("This is a test message", "text/plain");
// Create Mime "File" part
        MimeBodyPart fileBodyPart = new MimeBodyPart();
        fileBodyPart.attachFile(System.getProperty("user.dir") + File.
                separator + "attach.txt");
        MimeBodyPart fileBodyPart2 = new MimeBodyPart();
        fileBodyPart2.attachFile(System.getProperty("user.dir") + File.
                separator + "attach2.txt");
// Piece the body parts together
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(fileBodyPart);
//add another body part to supply another attachment
        multipart.addBodyPart(fileBodyPart2);
// Set the content of the message to be the MultiPart
        message.setContent(multipart);
        Transport.send(message);
        System.out.println("Sent message successfully....");
    } catch(MessagingException | IOException e)

    {
        e.printStackTrace();
    }
}
