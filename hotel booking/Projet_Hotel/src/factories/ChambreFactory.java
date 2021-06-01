package factories;

import entity.ChambreDouble;
import entity.ChambreFamiliale;
import entity.ChambreSimple;

public class ChambreFactory {

	protected Integer compteurSimple = 0;
	
	protected Integer compteurDouble = 0;
	
	protected Integer compteurFamiliale = 0;
	
	public ChambreFactory() {
		
	}
	
	public ChambreSimple newSimple() {
		return new ChambreSimple(++compteurSimple);
	}
	
	public ChambreDouble newDouble() {
		return new ChambreDouble(++compteurDouble);
	}
	
	public ChambreFamiliale newFamiliale() {
		return new ChambreFamiliale(++compteurFamiliale);
	}
}
