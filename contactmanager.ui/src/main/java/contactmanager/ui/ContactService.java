package contactmanager.ui;

import contactmanager.model.Contact;
import java.util.ArrayList;

public class ContactService {

    private ArrayList<Contact> contacts;

    public ContactService(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(String name, String phone, String email) {
        contacts.add(new Contact(name, phone, email));
    }

    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        }
    }

    public void editContact(int index, String name, String phone, String email) {
        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.get(index);
            contact.setName(name);
            contact.setPhone(phone);
            contact.setEmail(email);
        }
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}