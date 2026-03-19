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



class Phonebook{
   private Map<String,Contact> map;//store contacts
   private Gson gson = new Gson();

   Phonebook(){
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
   public void saveContact(String name,String phone_num){
        if(name.isEmpty() || phone_num.length() != 10){
            System.out.println("Invalid name or number");
            return;
        }

        Contact contact = new Contact(name,phone_num);
        map.put(name,contact);

        System.out.println("Contact saved");
    }

   public void updateContactName(String old_name,String new_name){
        Contact contact;
        if((contact = searchContact(old_name)) == null){
            System.out.println("Contact not found");
            return;
        }

        contact.setContact_name(new_name);
        map.remove(old_name);

        map.put(new_name,contact);
        System.out.println("Name updated successfully");
     
   }

   public void updateContactNumber(String name,String new_number){
        Contact contact;
        if((contact = searchContact(name)) == null){
            System.out.println("Contact not found");
            return;
        }
        
        contact.setContact_number(new_number);
        map.put(name,contact);
        System.out.println("Number updated successfully");

   }

   public void deleteContact(String name){
        if(map.get(name) == null){
            System.out.println("Contact not found");
            return;
        }

        map.remove(name);
        System.out.println("Contact deleted");
   }

   public Contact searchContact(String name){
        Contact contact;
        if((contact = map.get(name)) == null){
            return null;
        }

        return contact;
   }

   public Collection<Contact> displayContacts(){
        if(is_Empty()){
            System.out.println("Contact is empty");
            return null;
        }

        Collection<Contact> contacts = map.values();
        return contacts;
   }

   public void exit(){
         try (Writer writer = new FileWriter("contacts.json")) {
            gson.toJson(map,writer);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("PhoneBook closed");
   }
}