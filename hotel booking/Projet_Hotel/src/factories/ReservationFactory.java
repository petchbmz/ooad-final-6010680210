package factories;

import java.util.Date;

import clients.Client;
import entity.Chambre;
import entity.Hotel;
import entity.Reservation;

public class ReservationFactory {
	protected Integer compteur=0;
	
	public ReservationFactory() {
		
	}
	
	public Reservation newReservation(Hotel hotel, Client c, Chambre ch,int nbpersonne, Date Deb,
			Date Fin) {
		return new Reservation(++compteur, hotel, c, ch,nbpersonne, Deb, Fin);
	}
}
