package integrationTest;

import contactmanager.model.Contact;
import contactmanager.ui.ContactManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IT {

    private ContactManager contactManager;

    @BeforeEach
    public void setup() {

        contactManager = new ContactManager();
    }

    @Test
    public void testAddContact() {

        Contact contact = new Contact("Samson Neyo", "0738363673", "samson@gmail.com");
        contactManager.contacts.add(contact);


        assertEquals(1, contactManager.contacts.size());
        assertEquals("Samson Neyo", contactManager.contacts.get(0).getName());
        assertEquals("0738363673", contactManager.contacts.get(0).getPhone());
        assertEquals("samson@gmail.com", contactManager.contacts.get(0).getEmail());
    }

    @Test
    public void testEditContact() {

        Contact contact = new Contact("Samson Neyo", "9747474474", "samson@gmail.com");
        contactManager.contacts.add(contact);

        contact.setName("Adil Jacob");
        contact.setPhone("947474747");
        contact.setEmail("adiljacob@gmail.com");

        assertEquals("Adil Jacob", contactManager.contacts.get(0).getName());
        assertEquals("947474747", contactManager.contacts.get(0).getPhone());
        assertEquals("adiljacob@gmail.com", contactManager.contacts.get(0).getEmail());
    }

    @Test
    public void testDeleteContact() {

        Contact contact = new Contact("Samson Neyo", "073838383", "samson@gmail.com");
        contactManager.contacts.add(contact);

        contactManager.contacts.remove(0);

        assertTrue(contactManager.contacts.isEmpty());
    }

    @Test
    public void testViewContactDetails() {

        Contact contact = new Contact("Samson Neyo", "0784848484", "samson@gmail.com");
        contactManager.contacts.add(contact);

        contactManager.showContactDetails(0);

        assertEquals("Name: Samson Neyo", contactManager.detailNameLabel.getText());
        assertEquals("Telephone Number: 0784848484", contactManager.detailPhoneLabel.getText());
        assertEquals("Email Address: samson@gmail.com", contactManager.detailEmailLabel.getText());
    }
}
