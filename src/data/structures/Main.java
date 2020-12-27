package data.structures;

public class Main {
	public static void main(String[] args) {
		int emailCounter = 1;

		SendGmailEmail EvFi = new SendGmailEmail();
		EmailList emails = new EmailList();
		SenderCredentials EvsFi = new SenderCredentials();
		EmailBody email = new EmailBody();

		double startTime = System.currentTimeMillis();

		for (String emailAddress : emails.TestingEmails) {
			EvFi.send(EvsFi.getEmailAccount(), EvsFi.getEmailPassword(), emailAddress, "Email from Java", email.emailBody());
			emailCounter++;
		}
		double endTime = System.currentTimeMillis();
		double runtimeDuration = (endTime - startTime) / 1000;

		System.out.println("Sent " + emailCounter + " emails in " + runtimeDuration + " seconds.");
	}
}
