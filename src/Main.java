import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Contact {
    private String phone;
    private String email;

    public Contact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Phone: " + phone + "\nEmail: " + email;
    }
}

class ContactManager {
    private Map<String, Contact> contacts;

    public ContactManager() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phone, String email) {
        contacts.put(name, new Contact(phone, email));
        System.out.println("Contact added successfully.");
    }

    public void viewContacts() {
        if (!contacts.isEmpty()) {
            System.out.println("Contact List:");
            for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
                String name = entry.getKey();
                Contact contact = entry.getValue();
                System.out.println("Name: " + name);
                System.out.println(contact);
                System.out.println();
            }
        } else {
            System.out.println("No contacts found.");
        }
    }

    public void editContact(String name) {
        if (contacts.containsKey(name)) {
            Contact contact = contacts.get(name);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Editing contact: " + name);
            System.out.print("Enter new phone number: ");
            String newPhone = scanner.nextLine();
            System.out.print("Enter new email address: ");
            String newEmail = scanner.nextLine();
            contact.setPhone(newPhone);
            contact.setEmail(newEmail);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContact Management Program");
            System.out.println("Options:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String email = scanner.nextLine();
                    contactManager.addContact(name, phone, email);
                    break;
                case 2:
                    contactManager.viewContacts();
                    break;
                case 3:
                    System.out.print("Enter name of contact to edit: ");
                    String editName = scanner.nextLine();
                    contactManager.editContact(editName);
                    break;
                case 4:
                    System.out.print("Enter name of contact to delete: ");
                    String deleteName = scanner.nextLine();
                    contactManager.deleteContact(deleteName);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
