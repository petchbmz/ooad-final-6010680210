package factories;

import clients.Client;
import entity.Facture;
import entity.Hotel;

public class FactureFactory {
	protected Integer compteur = 0;

	public FactureFactory() {

	}

	public Facture createFacture(Hotel hotel, Client c) {
		return new Facture(++compteur, hotel, c);
	}
}
