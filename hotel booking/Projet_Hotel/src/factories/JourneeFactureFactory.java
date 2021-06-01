package factories;

import java.util.Date;

import entity.Chambre;
import entity.JourneeFacture;

public class JourneeFactureFactory {
	protected Integer compteur=0;
	
	public JourneeFacture createJourneeFacture(String idReservation, Chambre ch,Date day, int nbPers){
		return new JourneeFacture(++compteur, idReservation, ch,day, nbPers);
	}
}
