package mailgun.api.resources;

import javax.ws.rs.core.MultivaluedMap;

import mailgun.api.MailGunResponse;
import mailgun.api.MailgunClient;
import mailgun.api.exceptions.InvalidCredentials;
import mailgun.api.exceptions.MailGunException;
import mailgun.api.exceptions.MissingEndpoint;
import mailgun.api.exceptions.MissingRequiredParameters;

import com.sun.jersey.api.client.ClientResponse;

public abstract class Resource {

	private MailgunClient client;
	protected MultivaluedMap<String, String> filters;
	private boolean loaded;

	public Resource(MailgunClient client) {
		this.client = client;
	}

	protected MailgunClient getClient() {
		return this.client;
	}

	protected boolean isLoaded() {
		return this.loaded;
	}

	protected void load(MultivaluedMap<String, String> params) throws Exception {
		String path = this.getResourceLocation();
		ClientResponse response = this.getClient().getService().path(path).queryParams(params).get(ClientResponse.class);
		this.parseResponse(response);
		this.loaded = true;
	}

	public void checkStatusCode(MailGunResponse response) throws MailGunException {

		int statusCode = response.getStatusCode();

		if (statusCode == 200) {
			return;
		}
		if (statusCode == 400) {
			throw new MissingRequiredParameters("Invalid Parameters", response);
		} else if (statusCode == 401) {
			throw new InvalidCredentials("Invalid Credentials", response);
		} else if (statusCode == 404) {
			throw new MissingEndpoint("Missing / Bad Endpoint", response);
		}
	}

	protected abstract String getResourceLocation();

	protected abstract void parseResponse(ClientResponse response) throws Exception;

}
