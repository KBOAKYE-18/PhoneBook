package com.example.phonebook;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import com.google.gson.reflect.TypeToken; //For specify
import java.lang.reflect.Type;
import java.io.Writer;
import java.util.Collection;  //for storing contacts
import java.util.HashMap;  
import java.util.Map;
import com.google.gson.Gson;    //for converting java objects into json objects

import com.example.app.Color;  //import color class

public class Phonebook{
   private Map<String,Contact> map;//store contacts
   private Gson gson = new Gson(); //create json object for java conversion
   
   public Phonebook(){
       /*For specifying type during json to java object conversion */
       Type mapType = new TypeToken<Map<String, Contact>>(){}.getType();

        //Used try resources for reading json data
        try (Reader reader = new FileReader("contacts.json")) {
            map = gson.fromJson(reader, mapType);
        } catch (Exception e) {
            map = new HashMap<>();
        }   

        //Check if json is empty or invalid
        if (map == null) {
            map = new HashMap<>();
        }

        System.out.println(Color.GREEN + "PhoneBook initilized....." + Color.RESET);
   }

   private boolean is_Empty(){
        return map.isEmpty();
   }

   //CRUD operations for phonebook
   public void saveContact(String name,String phone_num){
        if(name.isEmpty() || phone_num.length() != 10){
            System.out.println(Color.RED + "Invalid name or number" + Color.RESET);
            return;
        }

        Contact contact = new Contact(name,phone_num);
        map.put(name,contact);
        
        saveToFile();
        
        System.out.println(Color.GREEN + "Contact saved" + Color.RESET);
        
    }

   public void updateContactName(String old_name,String new_name){
        Contact contact;
        if((contact = check_Contact(old_name)) == null){
            return;
        }

        contact.setContact_name(new_name);
        map.remove(old_name);

        map.put(new_name,contact);
        saveToFile();

        System.out.println(Color.GREEN + "Name updated successfully" + Color.RESET);
        
     
   }

   public void updateContactNumber(String name,String new_number){
        Contact contact;
        if((contact = check_Contact(name)) == null){
            return;
        }

        if(new_number.length() != 10){
            System.out.println(Color.RED + "Invalid number" + Color.RESET);
            return;
        }
        
        contact.setContact_number(new_number);
        map.remove(name);
        map.put(name,contact);

        saveToFile();
        System.out.println(Color.GREEN + "Number updated successfully" + Color.RESET);

   }

   public void deleteContact(String name){
        if(map.get(name) == null){
            System.out.println(Color.RED + "Contact not found" + Color.RESET);
            return;
        }

        map.remove(name);
        saveToFile();

        System.out.println(Color.GREEN + "Contact deleted" + Color.RESET);
        
   }

   private Contact check_Contact(String name){
        Contact contact;
        if((contact = map.get(name)) == null){
            System.out.println(Color.RED + "Contact not found" + Color.RESET);
            return null;
        }
        
        return contact;
   }

   public void displayContacts(){
        if(is_Empty()){
            System.out.println(Color.RED + "Contact is empty" + Color.RESET);
            return;
        }

        Collection<Contact> contacts = map.values();
        for(Contact contact : contacts){
            System.out.println(Color.BLUE + contact.getContact_name() + " - " + contact.getPhone_number() + Color.RESET);
        }
        
   }

   public void displayContact(String name){
        Contact contact;
        if((contact = check_Contact(name)) == null){
            return;
        }

        System.out.println(Color.BLUE + contact.getContact_name() + " - " + contact.getPhone_number() + Color.RESET);
   }

   public void saveToFile(){
         try (Writer writer = new FileWriter("contacts.json")) {
            gson.toJson(map,writer);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(Color.GREEN + "Changes made successfully" + Color.RESET);
   }

}