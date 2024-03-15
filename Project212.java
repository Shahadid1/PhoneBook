/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project212;

import java.util.Scanner;

/**
 *
 * @author haifaalsedairy
 */
public class Project212 {

    public static void main(String[] args) {
       Phonebook p = new Phonebook();
      
          Scanner input = new Scanner (System.in);

          int option = -1;
          String conNum,conEmail,conBirthday, conNumber1,conEmail1,conBirthday1,date,time;
          boolean flag = true;
         
         do{

          System.out.println("Welcome to the Linked Tree Phonebook!  ");
          System.out.println("Please choose an option: ");
          System.out.println("1. Add a contact ");
          System.out.println("2. Search for a contact");
          System.out.println("3. Delete a contact ");
          System.out.println("4. Schedule an event ");
          System.out.println("5. Print event details");
          System.out.println("6. Print contacts by first name");
          System.out.println("7. Print all events alphabetically ");
          System.out.println("8. Print contacts that share the same event ");
          System.out.println("9. Exit ");
         option = input.nextInt();  
         switch(option){
         
          case 1 :
             System.out.println("enter the contact's name  ");
             input.nextLine();
             String conName = input.nextLine();
            do {
                System.out.println("enter contact phone number:");


                conNum=input.next();
               if(Phonebook.ValidPhoneNumber(conNum)) {


                  break;
              } else {
                  System.out.println("Invalid phone number ,Please try again.");
              }
            } while (flag);
             
             
            do {
                System.out.println("enter contact email:");
                 conEmail=input.next();
                if(Phonebook.validEmail(conEmail)) {


                    break;
                } else {
                    System.out.println("Invalid email ,Please try again.");
                }
            } while (flag);

             
             System.out.println("enter contact address:");
             String conAddress=input.next();
             
             do {
                 System.out.println("enter contact birthday (MM/DD/YYYY):");
                  conBirthday=input.next();
                  if(Phonebook.ValidDate(conBirthday)){
                      
                      
                      break;
                  } else {
                      System.out.println("Invalid date ,Please try again.");
                  }
              } while (flag);
             
             System.out.println("enter contact notes:");
             input.nextLine();
             String  conNotes=input.nextLine();
  
            Contact c = new Contact( conName,conNum,conEmail,  conAddress,  conBirthday,  conNotes);
            p.addContact(c);

            break;

         case 2 :
            System.out.println(" enter search criteria  ");
            System.out.println("1. Name ");
            System.out.println("2. Phone Number");
            System.out.println("3. Email Address ");
            System.out.println("4. Address ");
            System.out.println("5. Birthday");
            int choice =-1;
             choice = input.nextInt();
            switch(choice){
                case 1 :
                    System.out.println(" enter the contact's name  ");
                    input.nextLine();
                    String conName1 = input.nextLine();

                    Contact c1=p.searchContactbyNameNum(conName1, choice);
                    if(c1!=null)
                       {System.out.println("contact found!");
                       c1.print();}
                    else
                       System.out.println("contact not found!");

                break; 
                
                case 2 :
                	do {
                        System.out.println(" enter the contact's Phone Number  "); 
                         conNumber1 = input.next();
                         if(Phonebook.ValidPhoneNumber(conNumber1)) {
                             
                             
                             break;
                         } else {
                             System.out.println("Invalid phone number ,Please try again.");
                         }
                     } while (flag);
                                   

                    
                    Contact c2=p.searchContactbyNameNum(conNumber1, choice);

                    if(c2!=null)
                       {System.out.println("contact found!");
                       c2.print();}
                    else
                       System.out.println("contact not found!");

                break; 

                case 3 :
                	do {
                        System.out.println(" enter the contact's Email Address  "); 
                        conEmail1 = input.next(); 
                        if(Phonebook.validEmail(conEmail1)) {
                            
                            
                            break;
                        } else {
                            System.out.println("Invalid email ,Please try again.");
                        }
                    } while (flag);
                	
                	
                    LinkedList<Contact> elist=p.searchContact(conEmail1,choice);

                    if(elist!=null)
                       {System.out.println("here are the contacts found with the entered email address: ");
                       elist.findfirst();
                       while(!elist.last()){//prints list of contacts with that email
                          elist.retrieve().print();
                          elist.findnext();}
                       elist.retrieve().print();//prints last element
                        }
                    else
                       System.out.println("no contacts found with that email address: ");  

                break;

                case 4 :


                    System.out.println(" enter the contact's Address  "); 
                    String conAddress1 = input.next(); 
                    LinkedList<Contact> alist=p.searchContact(conAddress1,choice);

                    if(alist!=null)
                      {System.out.println("here are the contacts found with the entered address: ");
                      alist.findfirst();
                       while(!alist.last()){//prints list of contacts with that address
                           alist.retrieve().print();
                           System.out.println();
                           alist.findnext();}
                       alist.retrieve().print();//print last element
                       }
                    else
                    System.out.println("no contacts found with that address: "); 
                    
                    System.out.println();

                break;

                case 5 :
                	do {
                        System.out.println(" enter the contact's birthday (MM/DD/YYYY) "); 
                         conBirthday1 = input.next(); 
                         
                         if(Phonebook.ValidDate(conBirthday1)){
                             
                             
                             break;
                         } else {
                        	 
                             System.out.println("Invalid date ,Please try again.");
                         }
                     } while (flag);
                    
                    LinkedList<Contact> blist=p.searchContact(conBirthday1,choice);

                    if(blist!=null)
                       {System.out.println("here are the contacts found with the entered birthday: ");
                       blist.findfirst();
                       while(!blist.last()){//prints list of contacts with that birthday
                          blist.retrieve().print();
                          blist.findnext();}
                          blist.retrieve().print();}//prints last element

                    else
                    System.out.println("no contacts found with that birthday");  

                break;



            }//end of switch
         
         
            break;
                 
         case 3 :
             System.out.println("enter name contact you wish to delete"); 
             input.nextLine();
             String nameNum=input.nextLine();
             p.deleteContact(nameNum);
         
         break;
         
         case 4 :
             System.out.println("enter event title:");
             input.nextLine();
             String title=input.nextLine();
             System.out.println("enter contact name:");
             String name=input.nextLine();
             
             do {
                 System.out.println("enter event date (MM/DD/YYYY):");
                  date=input.next();
                 if(Phonebook.ValidDate(date)){
                     
                     
                     break;
                 } else {
                     System.out.println("Invalid date ,Please try again.");
                 }
             } while (flag);
             
             
             do {
                 System.out.println("enter event time (HH:MM):");
                  time=input.next();
                 
                if(Phonebook.ValidTime(time)){
                     
                     
                     break;
                 } else {
                     System.out.println("Invalid time ,Please try again.");
                 }
             } while (flag);
             
             
             System.out.println("enter event location:");
             input.nextLine();
             String location=input.nextLine();
             Event e=new Event(title,date,time,location);
             Contact con=p.searchContactbyNameNum(name, 1);
             
             if(con!=null)
              p.scheduleEvent(e,con);
             
             else
                 System.out.println("cannot schedule event because contact doesn't exist");
            
             //if user wants to continue adding contacts to event
             char selection;
             boolean continueAdding=true;
             while(continueAdding){
                System.out.println("do you want to add more contacts to this event? y or n");
                selection=input.next().charAt(0);
                if(selection=='y'){
                         System.out.println("enter contact name:");
                         input.nextLine();
                         name=input.nextLine(); 
                         con=p.searchContactbyNameNum(name, 1);

                        if(con!=null)
                        {p.addEvent(e);
                         con.getEvents().sortedAdd_Event(e);
                         e.getContacts().insert(con);    }
                        
                        else
                            System.out.println("cannot schedule event because contact doesn't exist");
                }


                else
                    continueAdding=false;
                        
             }
         
            
         
         break;
         
         case 5 :
                System.out.println("enter search criteria:  ");
                System.out.println("1. Contact name ");
                System.out.println("2. Event title ");
                int ch = -1;
                ch = input.nextInt();
                switch(ch){
                        case 1 :
                            System.out.println("enter the contact's name:  "); 
                            input.nextLine();
                            name=input.nextLine();
                            LinkedList<Event> list=new LinkedList<Event>();
                            list=p.searchByConName(name);
                            if(list!=null)
                                list.print();
                            else
                                System.out.println("events not found");


                        break;        

                        case 2 :
                            System.out.println("enter the event title:  "); 
                            input.nextLine();
                            title = input.nextLine(); 
                            e=p.searchByEventTitle(title);
                            if(e!=null)
                                e.print();
                            else
                                System.out.println("events not found");

                        break;

                }
         
         break;
         
         case 6 :
            System.out.println(" enter contact first name "); 
            String fName = input.next();
            p.printByName(fName);

         break;        
                 
         case 7 :
            p.printAlphabetically();
         
         break; 
        
         case 8 ://print all contacts sharing same event
            System.out.println("enter event title:");
            input.nextLine();
            title=input.nextLine();
            p.printContacts_inEvent(title);
               
         break;  
         case 9 ://exit
            System.out.println("thank you for using the phonebook application, goodbye!");    
               
         break;  
         
         default:
            System.out.println("invalid input, try again!");    

                 
                 
         }// end of switch 
         }while(option != 9);

}
}

   
