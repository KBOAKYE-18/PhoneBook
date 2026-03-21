package com.example.app;

import com.example.phonebook.Phonebook;
import java.util.Scanner;
import com.example.app.Color;



public class PhonebookApp {
    

    public static void main(String[] args) {
        boolean state = true; //For terminating while loop
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(Color.CYAN + "======= PHONEBOOK APP =======" + Color.RESET);
        System.out.println(Color.YELLOW + "1." + Color.RESET + " Save Contact");
        System.out.println(Color.YELLOW + "2." + Color.RESET + " Display Contact");
        System.out.println(Color.YELLOW + "3." + Color.RESET + " Display All Contacts");
        System.out.println(Color.YELLOW + "4." + Color.RESET + " Update Name");
        System.out.println(Color.YELLOW + "5." + Color.RESET + " Update Number");
        System.out.println(Color.YELLOW + "6." + Color.RESET + " Delete Contact");
        System.out.println(Color.YELLOW + "7." + Color.RESET + " Exit");


        while(state){            

            System.out.println(Color.CYAN + "-------------------------------" + Color.RESET);
            System.out.print(Color.BLUE + "Enter option: " + Color.RESET);

            int option = scanner.nextInt();
            scanner.nextLine();

            // switch-case for actions ...
            switch(option){
                case 1:
                    System.out.print(Color.BLUE + "Enter contact name: " + Color.RESET);
                    String name = scanner.nextLine();

                    System.out.print(Color.BLUE + "Enter contact phone number: " + Color.RESET);
                    String number = scanner.next();

                    phonebook.saveContact(name.toUpperCase(), number);
                    break;

                case 2:
                    System.out.print(Color.BLUE + "Enter contact name: " + Color.RESET);
                    String name_2 = scanner.nextLine();

                    phonebook.displayContact(name_2.toUpperCase());
                    break;

                case 3:
                    phonebook.displayContacts();
                    System.out.println(Color.CYAN + "\nPress Enter to continue..." + Color.RESET);
                    scanner.nextLine(); // wait for user to press Enter
                    break;

                case 4:
                    System.out.print(Color.BLUE + "Enter old name: " + Color.RESET);
                    String old_name = scanner.nextLine();

                    System.out.print(Color.BLUE + "Enter new name: " + Color.RESET);
                    String new_name = scanner.nextLine();

                    phonebook.updateContactName(old_name.toUpperCase(), new_name.toUpperCase());
                    break;

                case 5:
                    System.out.print(Color.BLUE + "Enter name: " + Color.RESET);
                    String name_3 = scanner.nextLine();

                    System.out.print(Color.BLUE + "Enter new number: " + Color.RESET);
                    String new_number = scanner.nextLine();

                    phonebook.updateContactNumber(name_3.toUpperCase(), new_number);
                    break;

                case 6:
                    System.out.print(Color.BLUE + "Enter name: " + Color.RESET);
                    String name_4 = scanner.nextLine();

                    phonebook.deleteContact(name_4.toUpperCase());
                    break;

                case 7:
                    System.out.println(Color.GREEN + "Exiting Phonebook... Goodbye " + Color.RESET);
                    state = false;
                    break;

                default:
                    System.out.println(Color.RED + "Invalid input. Please try again." + Color.RESET);
            }

            System.out.println(); 
        }

        
        
    }    
}