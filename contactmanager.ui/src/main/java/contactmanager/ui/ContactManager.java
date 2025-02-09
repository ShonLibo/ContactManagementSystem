package contactmanager.ui;

import contactmanager.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ContactManager extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    private JPanel contactListPanel;
    private JPanel contactDetailPanel;
    private JPanel contactFormPanel;

    public ArrayList<Contact> contacts;
    private ContactService contactService;

    public int selectedContactIndex = -1;

    public JTextField formNameField;
    public JTextField formPhoneField;
    public JTextField formEmailField;

    public JLabel detailNameLabel;
    private JLabel detailPhoneLabel;
    private JLabel detailEmailLabel;

    public ContactManager() {
        setTitle("Contact Management System");

        contacts = new ArrayList<>();
        contactService = new ContactService(contacts);

        // Initialize UI components
        ContactManager();
    }

    private void ContactManager() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(new Color(240, 240, 240));

        createContactListPanel();
        createContactDetailPanel();
        createContactFormPanel();

        mainPanel.add(contactListPanel, "CONTACT_LIST");
        mainPanel.add(contactDetailPanel, "CONTACT_DETAILS");
        mainPanel.add(contactFormPanel, "CONTACT_FORM");

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createContactListPanel() {
        contactListPanel = new JPanel(new BorderLayout());
        ContactUIHelper.styleCardPanel(contactListPanel);

        JLabel header = new JLabel("CONTACT LIST VIEW", JLabel.CENTER);
        ContactUIHelper.styleHeaderLabel(header);
        contactListPanel.add(header, BorderLayout.NORTH);

        JPanel listContainer = new JPanel();
        listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));
        listContainer.setBackground(new Color(230, 230, 230));

        JScrollPane scrollPane = new JScrollPane(listContainer);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        contactListPanel.add(scrollPane, BorderLayout.CENTER);

        refreshContactListPanel(listContainer);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.setBackground(new Color(240, 240, 240));

        JButton addNewContactBtn = new JButton("Add New Contact");
        ContactUIHelper.styleButton(addNewContactBtn);
        addNewContactBtn.addActionListener(e -> {
            clearFormFields();
            selectedContactIndex = -1; // Indicate new contact
            cardLayout.show(mainPanel, "CONTACT_FORM");
        });

        JButton viewDetailBtn = new JButton("View Detail");
        ContactUIHelper.styleButton(viewDetailBtn);
        viewDetailBtn.addActionListener(e -> {
            if (selectedContactIndex >= 0 && selectedContactIndex < contacts.size()) {
                showContactDetails(selectedContactIndex);
                cardLayout.show(mainPanel, "CONTACT_DETAILS");
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Please select a contact by clicking on its name first.",
                        "No Contact Selected",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        bottomPanel.add(addNewContactBtn);
        bottomPanel.add(viewDetailBtn);
        contactListPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void refreshContactListPanel(JPanel listContainer) {
        listContainer.removeAll();

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);

            JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
            rowPanel.setBackground(new Color(230, 230, 230));
            rowPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            rowPanel.putClientProperty("index", i);

            JLabel nameLabel = new JLabel(contact.getName());
            nameLabel.setPreferredSize(new Dimension(250, 20));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            nameLabel.setForeground(Color.BLACK);
            nameLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            nameLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    selectedContactIndex = contacts.indexOf(contact);
                    ContactUIHelper.updateRowPanelColors(listContainer, selectedContactIndex);
                }
            });

            JButton editButton = new JButton("Edit");
            ContactUIHelper.styleButton(editButton);
            int finalI = i;
            editButton.addActionListener(e -> {
                selectedContactIndex = finalI;
                formNameField.setText(contact.getName());
                formPhoneField.setText(contact.getPhone());
                formEmailField.setText(contact.getEmail());
                cardLayout.show(mainPanel, "CONTACT_FORM");
                ContactUIHelper.updateRowPanelColors(listContainer, selectedContactIndex);
            });

            JButton deleteButton = new JButton("Delete");
            deleteButton.setBackground(Color.RED);
            deleteButton.setForeground(Color.WHITE);
            deleteButton.setFocusPainted(false);
            deleteButton.setFont(new Font("Arial", Font.BOLD, 13));
            deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            int finalI1 = i;
            deleteButton.addActionListener(e -> {
                int result = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this record?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );
                if (result == JOptionPane.YES_OPTION) {
                    contactService.deleteContact(finalI1);
                    if (finalI1 == selectedContactIndex) {
                        selectedContactIndex = -1;
                    }
                    refreshContactListPanel(listContainer);
                }
            });

            rowPanel.add(nameLabel);
            rowPanel.add(editButton);
            rowPanel.add(deleteButton);
            rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, rowPanel.getPreferredSize().height));
            listContainer.add(rowPanel);
        }
        listContainer.revalidate();
        listContainer.repaint();
    }

    private void createContactDetailPanel() {
        contactDetailPanel = new JPanel(new BorderLayout());
        ContactUIHelper.styleCardPanel(contactDetailPanel);

        JLabel header = new JLabel("CONTACT DETAILS VIEW", SwingConstants.CENTER);
        ContactUIHelper.styleHeaderLabel(header);
        contactDetailPanel.add(header, BorderLayout.NORTH);

        JPanel detailContainer = new JPanel();
        detailContainer.setLayout(new BoxLayout(detailContainer, BoxLayout.Y_AXIS));
        detailContainer.setBackground(new Color(230, 230, 230));
        detailContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        detailNameLabel = new JLabel("Name: ");
        detailPhoneLabel = new JLabel("Telephone Number: ");
        detailEmailLabel = new JLabel("Email Address: ");
        ContactUIHelper.styleDetailLabel(detailNameLabel);
        ContactUIHelper.styleDetailLabel(detailPhoneLabel);
        ContactUIHelper.styleDetailLabel(detailEmailLabel);

        detailContainer.add(detailNameLabel);
        detailContainer.add(Box.createVerticalStrut(10));
        detailContainer.add(detailPhoneLabel);
        detailContainer.add(Box.createVerticalStrut(10));
        detailContainer.add(detailEmailLabel);

        contactDetailPanel.add(detailContainer, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.setBackground(new Color(240, 240, 240));

        JButton backBtn = new JButton("Back To List");
        ContactUIHelper.styleButton(backBtn);
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "CONTACT_LIST"));

        JButton listViewBtn = new JButton("Contact List View");
        ContactUIHelper.styleButton(listViewBtn);
        listViewBtn.addActionListener(e -> cardLayout.show(mainPanel, "CONTACT_LIST"));

        bottomPanel.add(backBtn);
        bottomPanel.add(listViewBtn);

        contactDetailPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    public void showContactDetails(int index) {
        if (index < 0 || index >= contacts.size()) return;
        Contact c = contacts.get(index);
        detailNameLabel.setText("Name: " + c.getName());
        detailPhoneLabel.setText("Telephone Number: " + c.getPhone());
        detailEmailLabel.setText("Email Address: " + c.getEmail());
    }

    private void createContactFormPanel() {
        contactFormPanel = new JPanel(new BorderLayout());
        ContactUIHelper.styleCardPanel(contactFormPanel);

        JLabel header = new JLabel("CONTACT CREATION FORM", JLabel.CENTER);
        ContactUIHelper.styleHeaderLabel(header);
        contactFormPanel.add(header, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBackground(new Color(230, 230, 230));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));

        JLabel nameLabel = new JLabel("Name:");
        ContactUIHelper.styleDetailLabel(nameLabel);
        formNameField = new JTextField();
        formPanel.add(nameLabel);
        formPanel.add(formNameField);

        JLabel phoneLabel = new JLabel("Tel No:");
        ContactUIHelper.styleDetailLabel(phoneLabel);
        formPhoneField = new JTextField();
        formPanel.add(phoneLabel);
        formPanel.add(formPhoneField);

        JLabel emailLabel = new JLabel("Email:");
        ContactUIHelper.styleDetailLabel(emailLabel);
        formEmailField = new JTextField();
        formPanel.add(emailLabel);
        formPanel.add(formEmailField);

        contactFormPanel.add(formPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.setBackground(new Color(240, 240, 240));

        JButton saveBtn = new JButton("Save Contact");
        ContactUIHelper.styleButton(saveBtn);
        saveBtn.addActionListener(e -> saveContact());

        JButton cancelBtn = new JButton("Cancel");
        ContactUIHelper.styleButton(cancelBtn);
        cancelBtn.addActionListener(e -> cardLayout.show(mainPanel, "CONTACT_LIST"));

        bottomPanel.add(saveBtn);
        bottomPanel.add(cancelBtn);
        contactFormPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void saveContact() {
        String name = formNameField.getText().trim();
        String phone = formPhoneField.getText().trim();
        String email = formEmailField.getText().trim();

        if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "All fields must be filled out before saving.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (selectedContactIndex == -1) {
            contactService.addContact(name, phone, email);
        } else {
            contactService.editContact(selectedContactIndex, name, phone, email);
        }

        cardLayout.show(mainPanel, "CONTACT_LIST");
        refreshContactListPanel((JPanel) ((JScrollPane) contactListPanel.getComponent(1)).getViewport().getView());
    }

    private void clearFormFields() {
        formNameField.setText("");
        formPhoneField.setText("");
        formEmailField.setText("");
    }
}