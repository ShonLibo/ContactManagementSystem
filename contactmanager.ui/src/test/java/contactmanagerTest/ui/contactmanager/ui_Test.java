package contactmanagerTest.ui.contactmanager;

import contactmanager.ui.ContactManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ui_Test {
    @Nested
    class ContactManagerTest {
        private ContactManager contactManager;

        @BeforeEach
        void setUp() {
            contactManager = new ContactManager();
        }

        @Test
        void testUIComponentsExist() {

            assertNotNull(contactManager);
            assertNotNull(contactManager.getContentPane());
        }

        @Test
        void testAddingNewContact() {
            JTextField nameField = (JTextField) contactManager.getContentPane().getComponent(1);
            JTextField phoneField = (JTextField) contactManager.getContentPane().getComponent(2);
            JTextField emailField = (JTextField) contactManager.getContentPane().getComponent(3);

            nameField.setText("Test User");
            phoneField.setText("1234567890");
            emailField.setText("test@example.com");

            JButton saveButton = (JButton) contactManager.getContentPane().getComponent(4);
            saveButton.doClick(); // Simulate button click

        }
    }

}
