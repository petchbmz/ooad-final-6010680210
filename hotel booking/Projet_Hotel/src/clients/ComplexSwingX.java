package clients;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

import entity.Hotel;

public class ComplexSwingX extends JPanel {
	private JComboBox comboBox;
	private Client client;
	
	public Client getClient() {
		return client;
	}

	public ComplexSwingX(Hotel hotel) {
		UserRepository listUser = new UserRepository(hotel);
		Client[] allUsers = UserRepository.getAllUsers();
		this.comboBox = new JComboBox(allUsers);
		// set the renderer
		this.comboBox.setRenderer(new UserInfoRenderer());

		// install auto-completion
		AutoCompleteDecorator.decorate(this.comboBox, new ObjectToStringConverter() {
			public String getPreferredStringForItem(Object item) {
				if (item == null)
					return null;
				return ((Client) item).getLastName()+" "+((Client) item).getFirstName();
			}
		});

		this.add(this.comboBox);

		this.comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						Client selected = (Client) ComplexSwingX.this.comboBox
								.getSelectedItem();
						if (selected != null) {
							client = selected;
						}
					}
				});
			}
		});
		}
	

}