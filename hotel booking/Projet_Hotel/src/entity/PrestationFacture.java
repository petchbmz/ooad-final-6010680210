package entity;

import java.util.Date;

public class PrestationFacture {
	private String identifiant;
	private String prestation;
	private int montant;
	private Date date;

	public PrestationFacture(Integer id, String presta, int amount, Date day) {
		this.identifiant = "PresFac_"+id.toString();
		this.prestation = presta;
		this.montant = amount;
		this.date = day;

	}

	public String getPrestation() {
		return prestation;
	}

	public void setPrestation(String prestation) {
		this.prestation = prestation;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
