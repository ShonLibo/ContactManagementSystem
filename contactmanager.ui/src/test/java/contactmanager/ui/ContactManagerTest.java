import static org.junit.jupiter.api.Assertions.*;

import contactmanager.model.Contact;
import contactmanager.ui.YourClassUnderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;

public class ContactListPanelTest {
    public ContactListPanelTest instance; // Replace with the actual class name

    @BeforeEach
    public void setUp() {
        instance = new ContactListPanelTest(); // Initialize your class
        instance.createContactListPanel(); // Call the method to test
    }

    private void createContactListPanel() {


    }

    @Test
    public void testContactListPanelComponents() {
        JPanel panel = instance.getContactListPanel(); // Assuming a getter method exists

        assertNotNull(panel);
        assertEquals("CONTACT LIST VIEW", ((JLabel) panel.getComponent(0)).getText());
        assertInstanceOf(JScrollPane.class, panel.getComponent(1));
        assertInstanceOf(JPanel.class, panel.getComponent(2));
    }
}