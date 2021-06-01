package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import clients.Client;


public class Facture {
	private String identifiant;
	private Hotel hotel;
	private ArrayList<Reservation> reservations;
	private int total=0;
	private Date date;
	private SimpleDateFormat year = new SimpleDateFormat("yyyy");
	private SimpleDateFormat month = new SimpleDateFormat("MM");
	private SimpleDateFormat day = new SimpleDateFormat("dd");

	public Facture(Integer id, Hotel hotel, Client c) {
		this.date = hotel.getDdj();
		this.setHotel(hotel);
		this.identifiant = "Fac_"  + year.format(date) + "_"
				+ month.format(date) + "_"
				+ day.format(date) + "_" + id.toString();
		for (Reservation resa : hotel.getReservations()){
			if(resa.getClient().getIdentifiant()==c.getIdentifiant()){
				reservations.add(resa);
			}
		}
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}



	public int getTotal() {
		return total;
	}

	public void calcTotal(){

		for (Reservation resa : reservations) {
			total = total + resa.CalculMontant();
		}

		
		
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public void addReservation( Reservation resa){
		this.reservations.add(resa);
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	


}
