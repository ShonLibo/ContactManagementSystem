//package contactmanager.test.integrationTest;
//
//import contactmanager.model.Contact;
//import contactmanager.ui.ContactManager;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import javax.swing.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ContactManagerIntegrationTest {
//    private ContactManager contactManager;
//
//    @BeforeEach
//    void setUp() {
//        contactManager = new ContactManager();
//    }
//
//    @Test
//    void testIntegration_AddContact() {
//        SwingUtilities.invokeLater(() -> {
//            contactManager.formNameField.setText("Alice Doe");
//            contactManager.formPhoneField.setText("987654321");
//            contactManager.formEmailField.setText("alice@example.com");
//            contactManager.addContact(); // Simulate clicking add button
//            assertEquals(1, contactManager.contacts.size());
//            assertEquals("Alice Doe", contactManager.contacts.get(0).getName());
//        });
//    }
//
//    @Test
//    void testIntegration_DeleteContact() {
//        SwingUtilities.invokeLater(() -> {
//            Contact contact = new Contact("Bob Smith", "456789123", "bob@example.com");
//            contactManager.contacts.add(contact);
//            assertEquals(1, contactManager.contacts.size());
//            contactManager.deleteContact(0); // Simulate clicking delete button
//            assertEquals(0, contactManager.contacts.size());
//        });
//    }
//
//    @Test
//    void testIntegration_EditContact() {
//        SwingUtilities.invokeLater(() -> {
//            Contact contact = new Contact("Jane Doe", "987654321", "jane@example.com");
//            contactManager.contacts.add(contact);
//            contactManager.selectedContactIndex = 0;
//            contactManager.formNameField.setText("Jane Smith");
//            contactManager.formPhoneField.setText("555555555");
//            contactManager.formEmailField.setText("jane.smith@example.com");
//            contactManager.editContact(); // Simulate clicking edit button
//            assertEquals("Jane Smith", contactManager.contacts.get(0).getName());
//        });
//    }
//}
