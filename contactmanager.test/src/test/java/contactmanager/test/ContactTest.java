package contactmanager.test;

import contactmanager.model.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    @Test
    void testContactCreation() {
        Contact contact = new Contact("John Doe", "1234567890", "john@example.com");
        assertEquals("John Doe", contact.getName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("john@example.com", contact.getEmail());
    }

    @Test
    void testSetters() {
        Contact contact = new Contact("Jane Doe", "9876543210", "jane@example.com");
        contact.setName("Alice Doe");
        contact.setPhone("5555555555");
        contact.setEmail("alice@example.com");

        assertEquals("Alice Doe", contact.getName());
        assertEquals("5555555555", contact.getPhone());
        assertEquals("alice@example.com", contact.getEmail());
    }
}
