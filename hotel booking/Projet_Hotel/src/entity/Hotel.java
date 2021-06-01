package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;

import clients.*;
import factories.*;

public class Hotel {
	private final ArrayList<Chambre> chambres;
	private ArrayList<Reservation> reservations;
	private ArrayList<Client> clients;
	public ArrayList<Prestation> prestations;

	private ChambreFactory factoryChambre;
	private ClientFactory factoryClient;
	private ReservationFactory factoryReservation;
	private JourneeFactureFactory factoryJourneeFacture;
	private FactureFactory factoryFacture;
	private String nom;
	private Date ddj;

	public Hotel() {
		this.nom = "Hôtel Esaipien";
		ddj = new Date();
		chambres = new ArrayList<Chambre>();
		reservations = new ArrayList<Reservation>();
		clients = new ArrayList<Client>();
		prestations = new ArrayList<Prestation>();

		factoryChambre = new ChambreFactory();
		factoryClient = new ClientFactory();
		factoryReservation = new ReservationFactory();
		factoryJourneeFacture = new JourneeFactureFactory();
		factoryFacture = new FactureFactory();

		for (int i = 1; i <= 6; i++) {
			createChambreSimple();
		}
		for (int i = 1; i <= 4; i++) {
			createChambreDouble();
		}
		for (int i = 1; i <= 3; i++) {
			createChambreFamiliale();
		}

		createClient("Shmester", "Ester", "32 rue du poney");
		createClient("Larson", "Bob", "54 rue de verdun");
		createClient("Winters", "Richard", "32 rue du poney");
		createClient("Sobel", "Edward", "32 rue du poney");

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDdj() {
		return ddj;
	}

	public void setDdj(Date ddj) {
		this.ddj = ddj;
	}

	public ArrayList<Chambre> getChambres() {
		return chambres;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public ChambreFactory getFactoryChambre() {
		return factoryChambre;
	}

	public ClientFactory getFactoryClient() {
		return factoryClient;
	}

	public void createClient(String lastName, String firstName, String Address) {
		clients.add(factoryClient.newClient(lastName, firstName, Address));
	}

	public void createChambreSimple() {
		chambres.add(factoryChambre.newSimple());
	}

	public void createChambreDouble() {
		chambres.add(factoryChambre.newDouble());
	}

	public void createChambreFamiliale() {
		chambres.add(factoryChambre.newFamiliale());
	}

	public void createReservation(Hotel hotel, Client c, Chambre ch,
			int nbPersonne, Date Deb, Date Fin) {
		if (ch == null) {
			JOptionPane.showMessageDialog(null, "Réservation immposible");
		} else {

			reservations.add(factoryReservation.newReservation(hotel, c, ch,
					nbPersonne, Deb, Fin));
		}
	}

	public void displayClientList() {
		for (Client client : clients) {
			System.out.println(client.toString());
		}
	}

	public void displayReservations() {
		for (Reservation resa : reservations) {
			System.out.println(resa.toString());
		}
	}

	public void addOneDay() {
		this.ddj = new Date(this.ddj.getTime() + (24 * 60 * 60 * 1000));
		if (reservations.size() != 0) {
			for (Reservation resa : reservations) {
				// (String idReservation, Chambre ch,Date day, int nbPers)
				resa.addLignesFacture(factoryJourneeFacture
						.createJourneeFacture(resa.identifiant, resa.chambre,
								ddj, resa.nbPersonne));
			}
		}
	}

	public void editerFacture(Client c, Hotel hotel) {
		c.setFacture(factoryFacture.createFacture(hotel, c));
		c.getFacture().calcTotal();
	}

	public Client getLastClient() {
		return clients.get(clients.size() - 1);
	}

	public Chambre getChambreDispo(int nb, Date ddb, Date ddf) {
		Chambre chdispo = null;
		int i = 0;
		if (nb == 1) {
			Iterator<Chambre> ite = chambres.iterator();
			while (chdispo == null && ite.hasNext()) {
				Chambre ch = ite.next();
				i = 0;
				if (ch.type == "Simple") {
					if (reservations.size() != 0) {
						Iterator<Reservation> iteResa = reservations.iterator();
						while (chdispo == null && iteResa.hasNext()) {
							Reservation resa = iteResa.next();
							if (resa.getChambre().getIdentifiant() == ch
									.getIdentifiant()) {
								i++;
								if ((ddf.before(resa.DateDeb))
										|| (ddb.after(resa.DateFin))) {
									chdispo = ch;
									return chdispo;
								}
							}

						}
						if (i == 0) {
							chdispo = ch;
							return chdispo;
						}

					} else {
						chdispo = ch;
						return chdispo;
					}
				}

			}
			if (chdispo == null) {
				System.out.println("zz");
				chdispo = getChambreDispo(2, ddb, ddf);
			}
		}

		if (nb == 2) {
			Iterator<Chambre> ite = chambres.iterator();
			while (chdispo == null && ite.hasNext()) {
				Chambre ch = ite.next();
				i = 0;
				if (ch.type == "Double") {
					if (reservations.size() != 0) {
						Iterator<Reservation> iteResa = reservations.iterator();
						while (chdispo == null && iteResa.hasNext()) {
							Reservation resa = iteResa.next();
							if (resa.getChambre().getIdentifiant() == ch
									.getIdentifiant()) {
								i++;
								if ((ddf.before(resa.DateDeb))
										|| (ddb.after(resa.DateFin))) {
									chdispo = ch;
									return chdispo;
								}
							}

						}
						if (i == 0) {
							chdispo = ch;
							return chdispo;
						}

					} else {
						chdispo = ch;
						return chdispo;
					}
				}

			}
			if (chdispo == null) {
				return getChambreDispo(3, ddb, ddf);
			}
		}

		if (nb >= 3) {
			Iterator<Chambre> ite = chambres.iterator();
			while (chdispo == null && ite.hasNext()) {
				Chambre ch = ite.next();
				i = 0;
				if (ch.type == "Familiale") {
					if (reservations.size() != 0) {
						Iterator<Reservation> iteResa = reservations.iterator();
						while (chdispo == null && iteResa.hasNext()) {
							Reservation resa = iteResa.next();
							if (resa.getChambre().getIdentifiant() == ch
									.getIdentifiant()) {
								i++;
								if ((ddf.before(resa.DateDeb))
										|| (ddb.after(resa.DateFin))) {
									chdispo = ch;
									return chdispo;
								}
							}

						}
						if (i == 0) {
							chdispo = ch;
							return chdispo;
						}

					} else {
						chdispo = ch;
						return chdispo;
					}
				}

			}
		}

		// if (nb == 2) {
		// for (Chambre ch : chambres) {
		// if (ch.getType() == "Simple") {
		// if (reservations.size() != 0) {
		// for (Reservation resa : reservations) {
		// if (((ddb.before(resa.DateDeb)) && (ddf
		// .before(resa.DateDeb)))
		// || ((ddb.after(resa.DateFin)) && (ddf
		// .after(resa.DateFin)))) {
		// chdispo = chambres.get(i);
		//
		// } else {
		// getChambreDispo(2, ddb, ddf);
		// }
		// }
		// } else {
		//
		// chdispo = chambres.get(i);
		// break;
		// }
		// }
		// i++;
		// }
		// }
		// if (nb >= 3) {
		// for (Chambre ch : chambres) {
		// if (ch.getType() == "Familiale") {
		// if (reservations.size() != 0) {
		// for (Reservation resa : reservations) {
		// if (((ddb.before(resa.DateDeb)) && (ddf
		// .before(resa.DateDeb)))
		// || ((ddb.after(resa.DateFin)) && (ddf
		// .after(resa.DateFin)))) {
		// chdispo = chambres.get(i);
		//
		// } else {
		// getChambreDispo(2, ddb, ddf);
		// }
		// }
		// } else {
		//
		// chdispo = chambres.get(i);
		// break;
		// }
		// }
		// i++;
		// }
		// }

		return chdispo;

	}

	public boolean existClient(String lastName, String firstName, String Address) {
		boolean exist;
		exist = false;
		for (Client client : clients) {
			if (client.getLastName() == lastName
					&& client.getFirstName() == firstName
					&& client.getAddress() == Address) {
				exist = true;
			}
		}
		return exist;
	}
}
