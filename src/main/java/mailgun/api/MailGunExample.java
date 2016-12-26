package mailgun.api;

import mailgun.api.exceptions.MailGunException;
import mailgun.api.resources.instances.MessageInstance;

public class MailGunExample {

	public static void main(String args[]) throws Exception, MailGunException {

		// test mailgun api key
		MailgunClient client = new MailgunClient(null, null);

		String to = "";
		String from = "";
		String subject = "hello";
		String body = "yep";

		Email email = new Email(to, from, body, subject);
		MessageInstance msg = client.sendSimpleEmail(email);

	}
}
