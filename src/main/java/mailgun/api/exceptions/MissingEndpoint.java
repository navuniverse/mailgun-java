package mailgun.api.exceptions;

import mailgun.api.MailGunResponse;

public class MissingEndpoint extends MailGunException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissingEndpoint(String message, MailGunResponse response) {
		super(message, response);
	}
}
