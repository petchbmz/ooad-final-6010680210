package entity;

public class Prestation {
	private String identifiant;
	private String nom;
	private int montant;

	public Prestation(Integer id, String name, int amount) {
		this.identifiant = "Pres_" + id.toString();
		this.nom = name;
		this.montant = amount;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public String getIdentifiant() {
		return identifiant;
	}
	
	

}
