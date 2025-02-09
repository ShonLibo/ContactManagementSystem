package integrationTest;

import contactmanager.model.Contact;
import contactmanager.ui.ContactManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {

    private ContactManager contactManager;

    @BeforeEach
    public void setup() {
        // Initialize the ContactManager UI
        contactManager = new ContactManager();
    }

    @Test
    public void testAddContact() {
        // Simulate adding a new contact through the UI
        Contact contact = new Contact("Samson Neyo", "0738363673", "samson@gmail.com");
        contactManager.contacts.add(contact);

        // Verify that the contact is in the list
        assertEquals(1, contactManager.contacts.size());
        assertEquals("Samson Neyo", contactManager.contacts.get(0).getName());
        assertEquals("0738363673", contactManager.contacts.get(0).getPhone());
        assertEquals("samson@gmail.com", contactManager.contacts.get(0).getEmail());
    }

    @Test
    public void testEditContact() {
        // Add a contact first
        Contact contact = new Contact("Samson Neyo", "9747474474", "samson@gmail.com");
        contactManager.contacts.add(contact);

        // Simulate editing the contact
        contact.setName("Adil Jacob");
        contact.setPhone("947474747");
        contact.setEmail("adiljacob@gmail.com");

        // Verify the changes
        assertEquals("Adil Jacob", contactManager.contacts.get(0).getName());
        assertEquals("947474747", contactManager.contacts.get(0).getPhone());
        assertEquals("adiljacob@gmail.com", contactManager.contacts.get(0).getEmail());
    }

    @Test
    public void testDeleteContact() {
        // Add a contact to the list
        Contact contact = new Contact("Samson Neyo", "073838383", "samson@gmail.com");
        contactManager.contacts.add(contact);

        // Simulate deleting the contact (this would usually be tied to a button click in the UI)
        contactManager.contacts.remove(0);

        // Verify that the contact has been removed
        assertTrue(contactManager.contacts.isEmpty());
    }

    @Test
    public void testViewContactDetails() {
        // Add a contact
        Contact contact = new Contact("Samson Neyo", "0784848484", "samson@gmail.com");
        contactManager.contacts.add(contact);

        // Simulate viewing the contact details in the UI (e.g., navigating to a details panel)
        contactManager.showContactDetails(0);

        // Verify that the contact details are displayed correctly (you would need to check the labels in the actual UI)
        assertEquals("Name: Samson Neyo", contactManager.detailNameLabel.getText());
        assertEquals("Telephone Number: 0784848484", contactManager.detailPhoneLabel.getText());
        assertEquals("Email Address: samson@gmail.com", contactManager.detailEmailLabel.getText());
    }
}
