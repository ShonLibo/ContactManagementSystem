package contactmanagerTest.ui.contactmanager;

import contactmanager.model.Contact;
import contactmanager.ui.ContactManager;
import org.junit.jupiter.api.Test;


import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ui_Test {
    ContactManager contactManager = new ContactManager();
        @Test
        void testUIComponentsExist() {

            assertNotNull(contactManager);
            assertNotNull(contactManager.getContentPane());
        }

        @Test
        void testAddingNewContact() {
            // Create a new contact
            Contact contact = new Contact("Samson Neyo", "734567890", "samson@example.com");

            // Verify that the contact details are correctly set
            assertEquals("Samson Neyo", contact.getName());
            assertEquals("734567890", contact.getPhone());
            assertEquals("samson@example.com", contact.getEmail());

        }

    @Test
    void testEditContact() {
        SwingUtilities.invokeLater(() -> {
            Contact contact = new Contact("Samson Neyo", "734567890", "samson@example.com");
            contactManager.contacts.add(contact);
            contactManager.selectedContactIndex = 0;
            contactManager.formNameField.setText("Adil Jacob");
            contactManager.formPhoneField.setText("078484844");
            contactManager.formEmailField.setText("adiljacob@gmail.com");
            contact.setName("Adil Jacob");
            contact.setPhone("078484844");
            contact.setEmail("adiljacob@gmail.com");
            assertEquals("Adil Jacob", contactManager.contacts.get(0).getName());
        });
    }

    @Test
    void testShowContactDetails() {
        SwingUtilities.invokeLater(() -> {
            Contact contact = new Contact("Adil Jacob", "078484844", "adiljacob@gmail.com");
            contactManager.contacts.add(contact);
            contactManager.showContactDetails(0);
            assertEquals("Name: Adil Jacob", contactManager.detailNameLabel.getText());
        });
    }

    @Test
    void testDeleteContact() {
        SwingUtilities.invokeLater(() -> {
            Contact contact = new Contact("Samson Neyo", "734567890", "samson@example.com");
            contactManager.contacts.add(contact);
            assertEquals(1, contactManager.contacts.size());
            contactManager.contacts.remove(0);
            assertEquals(0, contactManager.contacts.size());
        });
    }



    }

