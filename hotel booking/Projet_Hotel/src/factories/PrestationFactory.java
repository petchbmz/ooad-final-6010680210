package factories;

import entity.Prestation;

public class PrestationFactory {
	private int compteur = 1;

	public PrestationFactory() {

	}

	public Prestation newPrestation(String name, int amount) {
		return new Prestation(++compteur, name, amount);

	}
}
