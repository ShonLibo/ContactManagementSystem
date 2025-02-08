package contactmanagerTest.ui.contactmanager;

import contactmanager.model.Contact;
import contactmanager.ui.ContactManager;
import org.junit.jupiter.api.Test;


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
            Contact contact = new Contact("John Doe", "1234567890", "johndoe@example.com");

            // Verify that the contact details are correctly set
            assertEquals("John Doe", contact.getName());
            assertEquals("1234567890", contact.getPhone());
            assertEquals("johndoe@example.com", contact.getEmail());



        }

        


    }

