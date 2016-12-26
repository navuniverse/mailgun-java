package mailgun.api.exceptions;

import mailgun.api.MailGunResponse;

public class MissingRequiredParameters extends MailGunException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissingRequiredParameters(String message, MailGunResponse response) {
		super(message, response);
	}
}
