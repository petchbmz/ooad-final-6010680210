package entity;

import java.util.Map;

public abstract class Chambre {

	protected int capacite;

	protected String identifiant;

	protected String type;
	
	protected Map<Integer, Integer> tarif;

	public int getCapacite() {
		return capacite;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public String getType() {
		return type;
	}

	public String toString() {
		return ("Identifiant : " + this.identifiant + ", Type : " + this.type
				+ ", Capacité : " + this.capacite);
	}
}
