class Contact{
    private String contact_name;
    private String phone_number;


    Contact(String name,String phone_num){
        contact_name = name;
        phone_number = phone_num;
    }

   public String getContact_name(){
        return contact_name;
    }
    
    public String getPhone_number(){
        return phone_number;
    }

    public void setContact_name(String new_name){
        contact_name = new_name;
    }

    public void setContact_number(String new_number){
        phone_number = new_number;
        
    }
}