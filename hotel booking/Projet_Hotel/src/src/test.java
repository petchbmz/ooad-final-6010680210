package src;

import java.text.SimpleDateFormat;
import java.util.Date;


import entity.Hotel;

public class test {

	public static void main(String[] s) {
		Hotel H1 = new Hotel();
		//H1.displayClientList();
		Date D1 = new Date(H1.getDdj().getTime());
		Date D2 = new Date(H1.getDdj().getTime()+(24*60*60*1000));
		System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(D1));
		System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(D2));
		//System.out.println(ch);
		System.out.println("_________________________________________1");
		System.out.println(H1.getChambreDispo(1, D1, D2).toString());
		System.out.println("_________________________________________2");
		H1.createReservation(H1, H1.getLastClient(),H1.getChambreDispo(2, D1, D2) , 2, D1, D2);
		H1.createReservation(H1, H1.getLastClient(),H1.getChambreDispo(2, D1, D2) , 2, D1, D2);
		H1.createReservation(H1, H1.getLastClient(),H1.getChambreDispo(2, D1, D2) , 2, D1, D2);
		H1.createReservation(H1, H1.getLastClient(),H1.getChambreDispo(2, D1, D2) , 2, D1, D2);
		H1.createReservation(H1, H1.getLastClient(),H1.getChambreDispo(2, D1, D2) , 2, D1, D2);
		
		System.out.println("_________________________________________3");
		H1.displayReservations();
//		System.out.println("_________________________________________4");
//		H1.addOneDay();
//		D1 = new Date(H1.getDdj().getTime()+(24*60*60*1000)+(24*60*60*1000));
//		D2 = new Date(H1.getDdj().getTime()+(24*60*60*1000)+(24*60*60*1000)+(24*60*60*1000)+(24*60*60*1000));
//		System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(D1));
//		System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(D2));
//		System.out.println(H1.getChambreDispo(1, D1, D2));
////		ch = H1.getChambreDispo(1, D1, D2);
////		System.out.println(ch.toString());
////		ch = H1.getChambreDispo(1, D1, D2);
////		System.out.println(ch.toString());
//		//System.out.println(ch.toString());
//		System.out.println("_________________________________________5");
//		H1.createReservation(H1, H1.getLastClient(), H1.getChambreDispo(1, D1, D2) , 1, D1, D2);
//		System.out.println("_________________________________________6");
//		//System.out.println(H1.getChambreDispo(1, D1, D2));
////		
//		H1.displayReservations();
	}
}
