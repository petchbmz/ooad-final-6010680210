package vues;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import entity.Chambre;
import entity.Hotel;

public class ListChambreListener implements ActionListener {

	public ListChambreListener(Hotel hotel) {
		super();
		this.hotel = hotel;
	}

	private Hotel hotel;

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Chambre> listCh = hotel.getChambres();

		JFrame ResListCh = new JFrame("Liste des chambres");
		Container container2 = ResListCh.getContentPane();
		container2.setLayout(new FlowLayout());

		String data[][] = {};
		String col[] = { "ID", "Type", "Capacité" };
		DefaultTableModel model = new DefaultTableModel(data, col);
		JTable jTable1 = new JTable(model);
		JTableHeader header = jTable1.getTableHeader();

		for (Chambre chambre : listCh) {
			model.insertRow(
					jTable1.getRowCount(),
					new Object[] { "" + chambre.getIdentifiant(),
							"" + chambre.getType(), "" + chambre.getCapacite() });
		}

		JPanel result2 = new JPanel(new BorderLayout());
		result2.add(header, BorderLayout.NORTH);
		result2.add(jTable1, BorderLayout.CENTER);
		container2.add(result2);
		result2.add(jTable1);
		container2.add(result2);
		ResListCh.pack();
		ResListCh.setLocationRelativeTo(null);
		ResListCh.setVisible(true);
		ResListCh.setResizable(true);
	}
}
