package mailgun.api;

import java.net.URI;

import javax.ws.rs.core.MultivaluedMap;

import mailgun.api.exceptions.MailGunException;
import mailgun.api.resources.instances.MessageInstance;
import mailgun.api.resources.lists.Bounces;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class MailgunClient {

	private String domain;

	private String apiEndpoint = "api.mailgun.net";
	public static final String API_VERSION = "v2";
	private Client client = Client.create();
	protected WebResource service;

	public MailgunClient(String domain, String apiKey) {
		this.domain = domain;
		client.addFilter(new HTTPBasicAuthFilter("api", apiKey));
		this.service = client.resource(getBaseUri());
	}

	public Bounces getBounces(MultivaluedMap<String, String> params) {
		return new Bounces(this, params);
	}

	public Bounces getBounces() {
		return this.getBounces(new MultivaluedMapImpl());
	}

	public MessageInstance sendSimpleEmail(Email email) throws Exception, MailGunException {
		MessageInstance msg = new MessageInstance(this, email);
		msg.sendSimple();
		return msg;
	}

	public URI getBaseUri() {
		return URI.create(String.format("https://%s/%s/%s", this.apiEndpoint, API_VERSION, this.domain));
	}

	public URI getRouteBaseUri() {
		return URI.create(String.format("https://%s/%s/%s", this.apiEndpoint, API_VERSION, "routes"));
	}

	public URI getCampaignBaseUri() {
		return URI.create(String.format("https://%s/%s/%s", this.apiEndpoint, API_VERSION, "campaigns"));
	}

	public URI getDomainBaseUri() {
		return URI.create(String.format("https://%s/%s/%s", this.apiEndpoint, API_VERSION, "domains"));
	}

	public String getApiEndpoint() {
		return this.apiEndpoint;
	}

	public void setApiEndpoint(String apiEndpoint) {
		this.apiEndpoint = apiEndpoint;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public WebResource getService() {
		return service;
	}

	public void setService(WebResource service) {
		this.service = service;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
