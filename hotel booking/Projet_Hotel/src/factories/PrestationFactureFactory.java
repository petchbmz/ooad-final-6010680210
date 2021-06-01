package factories;

import java.util.Date;

import entity.PrestationFacture;

public class PrestationFactureFactory {

	private int compteur = 1;

	public PrestationFactureFactory() {

	}

	public PrestationFacture newPrestationFacture(String presta, int amount,
			Date day) {
		return new PrestationFacture(++compteur, presta, amount, day);

	}
}
