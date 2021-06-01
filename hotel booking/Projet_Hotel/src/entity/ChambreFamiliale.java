package entity;

import java.util.HashMap;

public class ChambreFamiliale extends Chambre {
	
	public ChambreFamiliale(Integer id) {
		super();
		this.capacite = 5;
		this.type = "Familiale";
		this.identifiant = "FAM_" + id.toString();
		this.tarif = new HashMap<Integer, Integer>();
		this.tarif.put(1, 55);
		this.tarif.put(2, 48);
		this.tarif.put(3, 45);
		this.tarif.put(4, 43);
		this.tarif.put(5, 41);
	}
}