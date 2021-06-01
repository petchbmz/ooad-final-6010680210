package vues;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clients.Client;
import clients.ComplexSwingX;

import com.toedter.calendar.JDateChooser;

import entity.Chambre;
import entity.Hotel;


	public class ReservationListener implements ActionListener {
		private Hotel hotel;
		private JFrame Reservation;
		private JTextField clientName;
		private JTextField clientFirstname;
		private JTextField clientAddress;
		private Client selectedClient;
		
		public ReservationListener(Hotel hotel) {
			super();
			this.hotel = hotel;
		}
		
		public void actionPerformed(ActionEvent e) {
			Reservation = new JFrame();
			Reservation.setAlwaysOnTop(true);
			Reservation.setTitle("R\u00E9servation");
			Reservation.getContentPane().setLayout(null);
			
			
			JPanel clientPan = new JPanel();
			clientPan.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			clientPan.setBounds(10, 11, 424, 211);
			Reservation.getContentPane().add(clientPan);
			clientPan.setLayout(null);
			
			JPanel selectClientPan = new JPanel();
			selectClientPan.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "S\u00E9lection Client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			selectClientPan.setBounds(215, 21, 177, 154);
			clientPan.add(selectClientPan);
			selectClientPan.setLayout(null);
			
			
			final ComplexSwingX list = new ComplexSwingX(hotel);
			list.setBounds(10, 29, 157, 114);			
			selectClientPan.add(list);
			
			
			JPanel createClientPan = new JPanel();
			createClientPan.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Cr\u00E9ation Client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			createClientPan.setBounds(10, 21, 195, 154);
			clientPan.add(createClientPan);
			createClientPan.setLayout(null);
			
			JLabel lblNom = new JLabel("Nom : ");
			lblNom.setBounds(10, 24, 60, 14);
			createClientPan.add(lblNom);
			
			JLabel lblAdresse = new JLabel("Adresse : ");
			lblAdresse.setBounds(10, 124, 60, 14);
			createClientPan.add(lblAdresse);
			
			JLabel lblPrnom = new JLabel("Pr\u00E9nom");
			lblPrnom.setBounds(10, 74, 60, 14);
			createClientPan.add(lblPrnom);
			
			clientName = new JTextField();
			clientName.setBounds(99, 21, 86, 20);
			createClientPan.add(clientName);
			clientName.setColumns(10);
			
			clientFirstname = new JTextField();
			clientFirstname.setBounds(99, 71, 86, 20);
			createClientPan.add(clientFirstname);
			clientFirstname.setColumns(10);
			
			clientAddress = new JTextField();
			clientAddress.setBounds(99, 118, 86, 20);
			createClientPan.add(clientAddress);
			clientAddress.setColumns(10);
			
			final JPanel reservationPan = new JPanel();
			reservationPan.setVisible(false);
			reservationPan.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "R\u00E9servation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			reservationPan.setBounds(69, 230, 323, 194);
		
			final JDateChooser D1 = new JDateChooser("dd/MM/yyyy", "####/##/####", '_');
			final JDateChooser D2 = new JDateChooser("dd/MM/yyyy", "####/##/####", '_');
			
			D1.setBounds(193, 88, 120, 25);
			D2.setBounds(193, 34, 120, 25);
			
			reservationPan.add(D1);
			reservationPan.add(D2);
			Reservation.getContentPane().add(reservationPan);
			reservationPan.setLayout(null);
			
			final JComboBox<Integer> comboBox = new JComboBox<Integer>();
			comboBox.setBounds(193, 133, 39, 31);
			for(int i=1;i<=5;i++){
				comboBox.addItem(i);
			}
			
			reservationPan.add(comboBox);
			
			JLabel lblDateDebut = new JLabel("Date de d\u00E9but du s\u00E9jour : ");
			lblDateDebut.setBounds(10, 34, 146, 25);
			reservationPan.add(lblDateDebut);
			
			JLabel lblDateDeFin = new JLabel("Date de fin du s\u00E9jour : ");
			lblDateDeFin.setBounds(10, 88, 146, 25);
			reservationPan.add(lblDateDeFin);
			
			JLabel lblNombreDePersonnes = new JLabel("Nombre de personnes : ");
			lblNombreDePersonnes.setBounds(10, 136, 146, 25);
			reservationPan.add(lblNombreDePersonnes);
			
			
			final JButton btnValider = new JButton("Valider");
			btnValider.setBounds(183, 428, 89, 23);
			btnValider.setEnabled(false);
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"alert");
					//Vérifier les dates ! Si ddf < ddb, alert et pas de validation
					if(D1.getDate().after(D2.getDate())){
						JOptionPane.showMessageDialog(null,"Date de fin de séjour incorrecte !");
					}
					else
					{
						Chambre resCh;
						resCh = hotel.getChambreDispo(comboBox.getSelectedIndex(), D1.getDate(), D2.getDate());
						if(resCh==null){
							JOptionPane.showMessageDialog(null,"Aucune chambre disponible durant cette période");	
						}
						else
						{
							
						}
					}
				}
			});
			Reservation.getContentPane().add(btnValider);
			
			final JButton btnCrerClient = new JButton("Cr\u00E9er Client");
			final JButton btnSlectionnerClient = new JButton("S\u00E9lectionner client");
			
			
			btnCrerClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if((clientName.getText().equals(""))||(clientFirstname.getText().equals(""))||(clientAddress.getText().equals(""))){
						JOptionPane.showMessageDialog(null,"Champs incomplets ou invalides");
						
					}
					else 
					{
						if(hotel.existClient(clientName.getText(), clientFirstname.getText(), clientAddress.getText())){
							JOptionPane.showMessageDialog(null,"Client déja existant");
						}
						else
						{
							hotel.createClient(clientName.getText(), clientFirstname.getText(), clientAddress.getText());
							selectedClient = hotel.getLastClient();
							JOptionPane.showMessageDialog(null,"Client crée");
						}
						btnValider.setEnabled(true);
						btnSlectionnerClient.setEnabled(false);
						reservationPan.setVisible(true);
					}

				
				}
			});
			
			btnCrerClient.setBounds(60, 177, 89, 23);
			clientPan.add(btnCrerClient);
			
		
			btnSlectionnerClient.setBounds(244, 177, 119, 23);
			btnSlectionnerClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedClient = list.getClient();
					btnValider.setEnabled(true);
					btnCrerClient.setEnabled(false);
					reservationPan.setVisible(true);
				
				}
			});
			
			clientPan.add(btnSlectionnerClient);
			
			

			Reservation.setSize(459, 500);
			
			
			
			
			
			Reservation.show(true);

		}
	}