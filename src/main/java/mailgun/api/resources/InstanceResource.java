package mailgun.api.resources;

import mailgun.api.MailgunClient;

import com.sun.jersey.api.client.ClientResponse;

public abstract class InstanceResource extends Resource {

	public InstanceResource(MailgunClient client) {
		super(client);
	}

	@Override
	protected void parseResponse(ClientResponse response) throws Exception {
		// Gson gson = new Gson();
		// InstanceResource obj = gson.fromJson(response.getEntity(String.class), this.getClass());
		// this.value = obj;
	}

}
