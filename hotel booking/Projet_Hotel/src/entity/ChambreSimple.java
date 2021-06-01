package entity;

import java.util.HashMap;

public class ChambreSimple extends Chambre {
	
	public ChambreSimple(Integer id) {
		super();
		this.capacite = 1;
		this.type = "Simple";
		this.identifiant = "SIM_" + id.toString();
		this.tarif = new HashMap<Integer, Integer>();
		this.tarif.put(1, 38);
	}
}
