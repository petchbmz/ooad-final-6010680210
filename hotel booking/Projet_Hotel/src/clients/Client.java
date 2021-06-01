package clients;

import entity.Facture;


public class Client {
	private String firstName;
	private String lastName;
	private String address;
	protected String identifiant;
	private Facture facture;

	public Client(Integer id, String lastName, String firstName, String Address) {
		this.identifiant = lastName.substring(0, 3) + "_"
				+ firstName.substring(0, 3) + "_" + id.toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = Address;
		this.facture=null;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentifiant() {
		return identifiant;
	}
	
	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String toString() {
		return this.identifiant + " " + this.lastName + " " + this.firstName
				+ " " + this.address;
	}
	
	
}
