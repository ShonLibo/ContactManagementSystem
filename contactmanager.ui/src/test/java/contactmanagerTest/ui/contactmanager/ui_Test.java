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

