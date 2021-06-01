package factories;

import clients.Client;


public class ClientFactory {

	protected Integer compteurSimple = 0;
	
	public ClientFactory() {
		
	}
	
	public Client newClient(String lastName, String firstName, String Address) {
		return new Client(++compteurSimple, lastName, firstName, Address);
	}
}
