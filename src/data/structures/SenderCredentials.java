package data.structures;

public class SenderCredentials extends SendGmailEmail{
    private String emailAccount = "EvsFi@gmail.com"; //Not my email FYI
    private String emailPassword = "MyPassword1"; //Not my password, glad I caught this

    public String getEmailAccount() {
        return emailAccount;
    }

    public String getEmailPassword() {
        return emailPassword;
    }
}
