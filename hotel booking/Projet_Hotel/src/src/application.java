package src;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vues.ListChambreListener;
import vues.ReservationListener;
import entity.Hotel;




public class application {
	public JLabel RetListCh = new JLabel();

	
	public application(Hotel hotel){
		JFrame window = new JFrame("Menu Général");
		Container container = window.getContentPane();
		container.setLayout(new FlowLayout());
		JPanel result = new JPanel(new FlowLayout());

		JButton ListChambre = new JButton("Afficher la liste des chambres");
		ListChambre.addActionListener(new ListChambreListener(hotel));
		result.add(ListChambre);
		
		
		JButton Reservation = new JButton("Prendre un réservation");
		Reservation.addActionListener(new ReservationListener(hotel));
		result.add(Reservation);
		
		
		container.add(result);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
	
	}
	
	
	public static void main(String[] args) {
		Hotel hotel = new Hotel();

		new application(hotel);
		//System.out.println(hotel.listCh.get(hotel.listCh.size()-1).toString());
		
		
	}

}
