package contactmanager.model;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    Contact contact = new Contact("Samson", "073838333", "samson@gmail.com");

    @org.junit.jupiter.api.Test
    void contactTest() {

        contact.setName("Sam");
        contact.setPhone("0700000000");
        contact.setEmail("samson@gmail.com");

        assertEquals("Sam",contact.getName());
        assertEquals("0700000000",contact.getPhone());
        assertEquals("samson@gmail.com",contact.getEmail());

    }

}