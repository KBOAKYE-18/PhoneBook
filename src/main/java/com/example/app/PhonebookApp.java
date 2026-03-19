package com.example.app;

import com.example.phonebook.Phonebook;

public class PhonebookApp {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        
        System.out.println("\n--- TEST: Add Contacts ---");
        phonebook.saveContact("Alice", "0123456789");
        phonebook.saveContact("Bob", "0987654321");
        phonebook.saveContact("", "1234567890");      // invalid
        phonebook.saveContact("Charlie", "12345");    // invalid

        System.out.println("\n--- TEST: Display All Contacts ---");
        phonebook.displayContacts();

        System.out.println("\n--- TEST: Search Contact ---");
        phonebook.displayContact("Alice");            // should exist
        phonebook.displayContact("Unknown");          // should not exist

        System.out.println("\n--- TEST: Update Contact Name ---");
        phonebook.updateContactName("Alice", "Alicia");
        phonebook.updateContactName("NonExistent", "Test"); // should fail
        phonebook.displayContacts();

        System.out.println("\n--- TEST: Update Contact Number ---");
        phonebook.updateContactNumber("Alicia", "1112223333");
        phonebook.updateContactNumber("Bob", "000"); // invalid length handled
        phonebook.displayContacts();

        System.out.println("\n--- TEST: Delete Contact ---");
        phonebook.deleteContact("Bob");
        phonebook.deleteContact("Unknown");          // should fail
        phonebook.displayContacts();

        System.out.println("\n--- TEST: Exit (Save to JSON) ---");
        phonebook.exit();

        System.out.println("\n--- ALL TESTS COMPLETED ---");
    }
}