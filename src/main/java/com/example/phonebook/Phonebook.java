package com.example.phonebook;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;   



public class Phonebook{
   private Map<String,Contact> map;//store contacts
   private Gson gson = new Gson();

   public Phonebook(){
       Type mapType = new TypeToken<Map<String, Contact>>(){}.getType();

        try (Reader reader = new FileReader("contacts.json")) {
            map = gson.fromJson(reader, mapType);
        } catch (Exception e) {
            map = new HashMap<>();
        }   

        //Check if json is empty or invalid
        if (map == null) {
            map = new HashMap<>();
        }

        System.out.println("PhoneBook initilized");
   }

   private boolean is_Empty(){
        return map.isEmpty();
   }

   //CRUD operations for phonebook
   public int saveContact(String name,String phone_num){
        if(name.isEmpty() || phone_num.length() != 10){
            System.out.println("Invalid name or number");
            return 1;
        }

        Contact contact = new Contact(name,phone_num);
        map.put(name,contact);

        System.out.println("Contact saved");
        return 1;
    }

   public int updateContactName(String old_name,String new_name){
        Contact contact;
        if((contact = check_Contact(old_name)) == null){
            System.out.println("Contact not found");
            return 1;
        }

        contact.setContact_name(new_name);
        map.remove(old_name);

        map.put(new_name,contact);
        System.out.println("Name updated successfully");
        return 1;
     
   }

   public int updateContactNumber(String name,String new_number){
        Contact contact;
        if((contact = check_Contact(name)) == null){
            System.out.println("Contact not found");
            return 1;
        }

        if(new_number.length() != 10){
            System.out.println("Invalid number");
            return 1;
        }
        
        contact.setContact_number(new_number);
        map.remove(name);
        map.put(name,contact);
        System.out.println("Number updated successfully");

        return 1;
   }

   public int deleteContact(String name){
        if(map.get(name) == null){
            System.out.println("Contact not found");
            return 1;
        }

        map.remove(name);
        System.out.println("Contact deleted");
        return 1;
   }

   private Contact check_Contact(String name){
        Contact contact;
        if((contact = map.get(name)) == null){
            System.out.println("Contact not found");
            return null;
        }
        
        return contact;
   }

   public int displayContacts(){
        if(is_Empty()){
            System.out.println("Contact is empty");
            return 1;
        }

        Collection<Contact> contacts = map.values();
        for(Contact contact : contacts){
            System.out.println(contact.getContact_name() + " - " + contact.getPhone_number());
        }
        return 1;
   }

   public int displayContact(String name){
        Contact contact;
        if((contact = check_Contact(name)) == null){
            System.out.println("Contact not found");
            return 1;
        }

        System.out.println(contact.getContact_name() + " - " + contact.getPhone_number());
        return 1;
   }

   public int exit(){
         try (Writer writer = new FileWriter("contacts.json")) {
            gson.toJson(map,writer);
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        System.out.println("PhoneBook closed");
        return 0;
   }
}