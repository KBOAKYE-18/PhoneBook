package com.example.phonebook;
class Contact{
    private String contact_name;
    private String phone_number;


    Contact(String name,String phone_num){
        contact_name = name;
        phone_number = phone_num;
    }

    String getContact_name(){
        return contact_name;
    }
    
    String getPhone_number(){
        return phone_number;
    }

    void setContact_name(String new_name){
        contact_name = new_name;
    }

    void setContact_number(String new_number){
        phone_number = new_number;
        
    }
}