package clients;
import java.awt.Component;

import javax.swing.*;

/**
 * A custom renderer for comboboxes that display {@link Client} model
 * elements.
 * 
 * @author Kirill Grouchnikov
 */
public class UserInfoRenderer extends DefaultListCellRenderer {
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		JLabel result = (JLabel) super.getListCellRendererComponent(list,
				value, index, isSelected, cellHasFocus);
		Client userInfo = (Client) value;
		result.setText(userInfo.getLastName()+" "+userInfo.getFirstName());
		return result;
	}
}
