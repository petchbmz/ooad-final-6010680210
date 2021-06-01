package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JourneeFacture {
	private String identifiant;
	private String idResa;
	private Chambre typeChambre;
	private Date date;
	private int montant=0;
	private int nbPersonne;

	public JourneeFacture(Integer id, String idReservation, Chambre ch,
			Date day, int nbPers) {
		this.identifiant = "JrFac_"
				+ new SimpleDateFormat("dd/MM/yyyy").format(day) + "_"
				+ id.toString();
		this.idResa = idReservation;
		this.typeChambre = ch;
		this.date = day;
		this.nbPersonne = nbPers;
		calculMontant();
		
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getIdResa() {
		return idResa;
	}

	public Chambre getTypeChambre() {
		return typeChambre;
	}

	public void setTypeChambre(Chambre typeChambre) {
		this.typeChambre = typeChambre;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getMontant() {
		calculMontant();
		return montant;
	}
	
	public void calculMontant(){
		this.montant = nbPersonne * typeChambre.tarif.get(nbPersonne);
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}
	
	public String toString(){
//		(Integer id, String idReservation, Chambre ch,Date day, int nbPers) {
		return "ID : "+this.identifiant+", ID_Resa : "+this.idResa+", Chambre : "+this.typeChambre.getType()+", nbPersonne : "+this.nbPersonne+", Date : "+this.date.toString();
	}

}
