package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import clients.*;

public class Reservation {
	protected Client client;
	protected Chambre chambre;
	protected String identifiant;
	protected int nbPersonne;
	protected Date DateDeb;
	protected Date DateFin;
	private Hotel hotel;
	private ArrayList<Prestation> prestations;
	private ArrayList<JourneeFacture> lignesFactures;
	private SimpleDateFormat year = new SimpleDateFormat("yyyy");
	private SimpleDateFormat month = new SimpleDateFormat("MM");
	private SimpleDateFormat day = new SimpleDateFormat("dd");

	public Reservation(Integer id, Hotel hotel, Client c, Chambre ch,int nb, Date Deb,
			Date Fin) {
		this.hotel = hotel;
		this.client = c;
		this.chambre = ch;
		this.nbPersonne = nb;
		this.DateDeb = Deb;
		this.DateFin = Fin;
		this.identifiant = "Resa_" + year.format(hotel.getDdj()) + "_"
				+ month.format(hotel.getDdj()) + "_"
				+ day.format(hotel.getDdj()) + "_" + id.toString();
		prestations = new ArrayList<Prestation>();
		lignesFactures = new ArrayList<JourneeFacture>();

	}

	
	public int getNbPersonne() {
		return nbPersonne;
	}


	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public ArrayList<JourneeFacture> getLignesFactures() {
		return lignesFactures;
	}


	public void setLignesFactures(ArrayList<JourneeFacture> lignesFactures) {
		this.lignesFactures = lignesFactures;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public Date getDateDeb() {
		return DateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		DateDeb = dateDeb;
	}

	public Date getDateFin() {
		return DateFin;
	}

	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}
	
	
	public void addPrestation( Prestation pres){
		this.prestations.add(pres);
	}
	
	public void addLignesFacture(JourneeFacture jour){
		this.lignesFactures.add(jour);
	}
	
	public int CalculMontant(){
		int total=0;
		for (Prestation pres : prestations){
			total = total + pres.getMontant();
		}
		for (JourneeFacture ligne : lignesFactures){
			total = total + ligne.getMontant();
		}
		return total;
	}

	public String toString() {
		return "Identifiant : " + this.identifiant 
				+ ", Client : " + this.client.getIdentifiant()
				+ " Chambre : " + this.chambre.getIdentifiant()
				+ ", Date début : " + new SimpleDateFormat("dd/MM/yyyy").format(this.DateDeb) 
				+ ", Date fin : " + new SimpleDateFormat("dd/MM/yyyy").format(this.DateFin);
	}
}
