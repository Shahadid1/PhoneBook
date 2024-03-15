/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project212;

/**
 *
 * @author haifaalsedairy
 */

 
public class Phonebook {
     static LinkedList<Contact> conList;
     static LinkedList<Event> EventList;
     
    
    
    public Phonebook(){
        conList=new LinkedList<Contact>();
        EventList=new LinkedList<Event>();
    }
   
    //returns true if contact is unique(has unique name and phone number) and false if not
public static boolean uniquecontact(Contact c) {
      if (conList.empty())
        return true;
      
      conList.findfirst();
      while (!conList.last()) {
        if (conList.retrieve().getConName().equals(c.getConName())|| conList.retrieve().getConNumber().equals(c.getConNumber()))
            return false;
        conList.findnext();
      }
      if (conList.retrieve().getConName().equals(c.getConName())|| conList.retrieve().getConNumber().equals(c.getConNumber()))
          return false;
      return true;
      
    }
    //checks if contact is unique then adds it to my contact list
public static void addContact(Contact c){   
           
     if(conList.empty()){
        conList.sortedAdd(c);
        System.out.println("Contact added successfully");}

      
    
    else if(uniquecontact(c)) 
        {conList.sortedAdd(c);
        System.out.println("Contact added successfully");
        }
    
    else
        System.out.println("contact already exists");
        
}  
    
    
    
// deletes contact along with its events
public static void deleteContact (String contact){
         boolean exist=false;
         if (conList.empty()) 
          exist=false;
         else{
            conList.findfirst();

            while(!conList.last()){ 
                    if(conList.retrieve().getConName().equals(contact)){
                    LinkedList<Event> l=getEvents_inContact(conList.retrieve().getConName());
                    if(!l.empty()){
                        l.findfirst();
                        while(!l.empty()&&!l.last())
                        {deleteEvent(contact,l.retrieve().getEventtitle());
                          l.findnext();}
                        deleteEvent(contact,l.retrieve().getEventtitle());//for last event
                        conList.remove(); 
                        exist=true; 
                        }
                    }
            conList.findnext();

            }

             
            if(conList.retrieve().getConName().equals(contact))// for last contact
                {
                  LinkedList<Event> l=getEvents_inContact(conList.retrieve().getConName());
                  if(!l.empty()){
                  l.findfirst();
                  while(!l.empty()&&!l.last())
                  {deleteEvent(contact,l.retrieve().getEventtitle());
                  l.findnext();}
                  deleteEvent(contact,l.retrieve().getEventtitle());}//for last event
                  conList.remove(); 
                  exist=true; 

                }
        
       
          }
       
            if(exist)
                System.out.println("contact has been deleted");
            else
                System.out.println("contact does not exist");


}
     
     //returns events list in contact
public static LinkedList<Event> getEvents_inContact(String name ){
       Contact con = searchContactbyNameNum( name , 1);
       if(con!=null)
           return con.getEvents();
       return null;
        
}
    
 
    
    
    //returns contacts in event
public static LinkedList<Contact> getContacts_inEvent(String title ){
        
        Event event = searchByEventTitle(title); 
            if(event!=null)
                 return event.getContacts();
        return null;
            
}

//deletes contact from event and deletes event with the deleted contact from eventlist 
public static void deleteEvent(String contact , String title ){
       LinkedList<Contact> con = getContacts_inEvent(title); 
       con.findfirst();
       while(!con.empty() && !con.last()){
         if(con.retrieve().getConName().equals(contact) || con.retrieve().getConNumber().equals(contact)) 
         {con.remove();
         break;}
         con.findnext();
       }
        if(!con.empty())
            if(con.retrieve().getConName().equals(contact) || con.retrieve().getConNumber().equals(contact)) 
              con.remove();
        
        if(!con.empty())
            return;
        if(EventList.empty())
            return;
        EventList.findfirst();
        while(!EventList.last()){
        if(EventList.retrieve().getEventtitle().equals(title)){
            EventList.remove();
        System.out.println(title+" event deleted Successfully");
        return;}
        EventList.findnext();
        }
        if(EventList.retrieve().getEventtitle().equals(title)){
            EventList.remove();
        System.out.println(title+" event deleted Successfully");
        return;}
        else 
       System.out.println(" event does not exist ");
  
       
    }
    
public static LinkedList<Contact> searchContact(String s , int identifier){//search by address,email,and birthday
        if(conList.empty())
            return null;
        LinkedList<Contact> temp=new LinkedList<Contact>(); //temporary list to put contacts found
        conList.findfirst();
        switch(identifier){
            case 3://by email
               
                
                while(!conList.last()) //if conlist has multiple elements 
                {if(conList.retrieve().getConEmail().equals(s) )
                  temp.insert(conList.retrieve());
                conList.findnext();
                    }
                if(conList.retrieve().getConEmail().equals(s) )
                  temp.insert(conList.retrieve());
                break;
                
            case 4://by address
                while(!conList.last()) 
                {if(conList.retrieve().getConAddress().equals(s) )
                  temp.insert(conList.retrieve());
                conList.findnext();
                    }
                if(conList.retrieve().getConAddress().equals(s) )
                  temp.insert(conList.retrieve());
                break;
               
               
            case 5:// by birthday
               
               while(!conList.last())
                {if(conList.retrieve().getConBirthday().equals(s) )
                  temp.insert(conList.retrieve());
                conList.findnext();
                    }
                if(conList.retrieve().getConBirthday().equals(s) )//last check
                  temp.insert(conList.retrieve());
                break; 
        }
        return temp;    
    }
    
    
    //returns contact with given name or number
public static Contact searchContactbyNameNum(String contact , int identifier){ //returns 1 contact since name and number are unique
  
    if (conList.empty())
        return null;
    
      Contact C = null;
       conList.findfirst();
         switch(identifier){ //switch for identifier 1: search by name and 2: search by number
     
           case 1 : 
           
          while(!conList.last()){// if multiple elements (search by name)
               if(conList.retrieve().getConName().equalsIgnoreCase(contact)) 
               C = conList.retrieve();
               
                conList.findnext();
                } // end of loop
           if(conList.retrieve().getConName().equals(contact)) 
                 C = conList.retrieve();
               
           
           break;
           
            case 2 :
             
           while(!conList.last()){//if multiple elements (search by number)

               if(conList.retrieve().getConNumber().equals(contact)) 

               C = conList.retrieve();
              
                conList.findnext();
                } // end of loop
            if(conList.retrieve().getConNumber().equals(contact)) //last element check
                 C = conList.retrieve();
           break;
           
           
       }//end switch

       return C;

    }
   
    //print contacts by first name
public static void printByName(String name){
       if(conList.empty()) return;
       
       boolean found=false;
       int space=0;
       
       conList.findfirst();
       while(!conList.last()){
           
       space=conList.retrieve().getConName().indexOf(" ");
      
       if(conList.retrieve().getConName().substring(0,space).equalsIgnoreCase(name))
        {conList.retrieve().print();
        found=true;}
       conList.findnext();
       }
       
       space=conList.retrieve().getConName().indexOf(" ");//last element check
       if(conList.retrieve().getConName().substring(0,space).equalsIgnoreCase(name)){
            conList.retrieve().print();
            found=true;}
       
       if(found=false)    
           System.out.println("contacts with that first name do not exist");
   }
  
 
   //return list of events of a contact
public static LinkedList<Event> searchByConName(String conName ){   //assuming that one contact has many events  
    
    Contact c ;
    c=searchContactbyNameNum(conName,1);
    if(c!=null)
        if(!c.getEvents().empty())
           return c.getEvents();
         return null;
}
   
public static void addEvent (Event e){
        
    if(searchByEventTitle(e.getEventtitle()) == null ) 
      EventList.sortedAdd_Event(e); 
        
}

public static void printContacts_inEvent(String title ){
        if(searchByEventTitle(title)!=null)
          if(searchByEventTitle(title).getContacts()!=null)
             searchByEventTitle(title).getContacts().print();
            
}
    
public static Event searchByEventTitle(String Title ){
     if(EventList.empty())
         return null;
     
    EventList.findfirst();
           while(!EventList.last()){
           if(EventList.retrieve().getEventtitle().equals(Title))
            return EventList.retrieve(); 
               EventList.findnext();}

       if(EventList.retrieve().getEventtitle().equals(Title))
            return EventList.retrieve(); 
           return null;
    
   }
    
public static void scheduleEvent(Event e,Contact c){
        if(conflict(e)){
            System.out.println("cannot schedule event due to conflict in event time");
            return;}

        addEvent(e);
        c.getEvents().sortedAdd_Event(e);
        e.getContacts().insert(c);
         System.out.println("event scheduled successfully");

    }

public static boolean conflict(Event e) {
      
       if(EventList.empty())   
           return false;
             
        while(!EventList.last()) {
          if(e.getEventdate().equals(EventList.retrieve().getEventdate())&&e.getEventTime().equals(EventList.retrieve().getEventTime())) 
            return true;
          EventList.findnext();
        }
        if(e.getEventdate().equals(EventList.retrieve().getEventdate())&&e.getEventTime().equals(EventList.retrieve().getEventTime())) 
          return true ;
          
        else
          return false;
          
          
          }
    
    //print events alphabetically
public static void printAlphabetically(){
        if(EventList.empty())
           {System.out.println("no events scheduled");
           return;
           }
        EventList.findfirst();
        while(!EventList.last()){
            EventList.retrieve().print();
            EventList.findnext();
        }
        EventList.retrieve().print();

    }
    //checks for valid date
public static boolean ValidDate(String date) {

        if ( date.length() != 10||date.charAt(2) != '/' || date.charAt(5) != '/') {
            return false;
        }

        String monthS= date.substring(0, 2);
        String dayS = date.substring(3, 5);
        String yearS = date.substring(6);

   
        int month = Integer.parseInt(monthS);
        int day = Integer.parseInt(dayS);
        int year = Integer.parseInt(yearS);

        if (month < 1 || month > 12 || day < 1 || day > 31 || year < 1) {
           return false;
        }
        
        return true;
      
}


public static boolean ValidPhoneNumber(String phnum) {


        for (int i=0 ; i<phnum.length();i++) {

          char ch=phnum.charAt(i);


              if (ch < '0' || ch > '9') {
                  return false; 
              }
        }
        
        if (phnum.length() != 10) {
              return false;
              }
        return true;
      }


public static boolean validEmail(String email) {
              int emailindex=email.indexOf('@');
                int dotindex = email.indexOf('.');

              if(emailindex!=-1  &&  dotindex!=-1) 
                return true;

               return false;
              }
    

public static boolean ValidTime(String time) {
        if (time.length() != 5) {
            return false;
        }

        String hoursS = time.substring(0, 2);
        String minutesS = time.substring(3);

            int hours = Integer.parseInt(hoursS);
            int minutes = Integer.parseInt(minutesS);

            if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
                return false;
            }
            return true;

    }



}
 

