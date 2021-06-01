package clients;
import javax.swing.ComboBoxEditor;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicComboBoxEditor;

/**
 * A custom editor for comboboxes that display {@link Client} model
 * elements.
 *
 * @author Kirill Grouchnikov
 */
public class UserInfoEditor extends BasicComboBoxEditor {
	public UserInfoEditor(ComboBoxEditor origEditor) {
		super();
		editor.setBorder(((JComponent) origEditor.getEditorComponent())
				.getBorder());
	}

	@Override
	public void setItem(Object anObject) {
		if (anObject instanceof Client) {
			super.setItem(((Client) anObject).getLastName());
		} else {
			super.setItem(anObject);
		}
	}

	@Override
	public Object getItem() {
		Object superRes = super.getItem();
		if (superRes instanceof String) {
			Client result = UserRepository.getUserInfo(
					(String) superRes);
			return result;
		}
		return superRes;
	}
}
