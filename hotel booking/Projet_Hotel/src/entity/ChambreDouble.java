package entity;

import java.util.HashMap;
import java.util.Map;

public class ChambreDouble extends Chambre {
	
	public ChambreDouble(Integer id) {
		super();
		this.capacite = 2;
		this.type = "Double";
		this.identifiant = "DBL_" + id.toString();
		this.tarif = new HashMap<Integer, Integer>();
		this.tarif.put(1, 42);
		this.tarif.put(2, 38);
		
	}
}
