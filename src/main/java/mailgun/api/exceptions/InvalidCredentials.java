package mailgun.api.exceptions;

import mailgun.api.MailGunResponse;

public class InvalidCredentials extends MailGunException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCredentials(String message, MailGunResponse response) {
		super(message, response);
	}
}
