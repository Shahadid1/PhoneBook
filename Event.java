/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project212;

/**
 *
 * @author haifaalsedairy
 */
public class Event implements Comparable<String>{
  
      private String Eventtitle;
      private String Eventdate;
      private String EventTime;
      private String Eventlocation;
      private String conName;
      public LinkedList<Contact> contacts= new LinkedList<Contact>();

    public Event() {
    }
     
    public Event(String eventtitle, String eventdate, String eventTime, String eventlocation) {
      Eventtitle = eventtitle;
      Eventdate = eventdate;
      EventTime = eventTime;
      Eventlocation = eventlocation;
    }



    public String getEventtitle() {
      return Eventtitle;
    }



    public void setEventtitle(String eventtitle) {
      Eventtitle = eventtitle;
    }



    public String getEventdate() {
      return Eventdate;
    }



    public void setEventdate(String eventdate) {
      Eventdate = eventdate;
    }



    public String getEventTime() {
      return EventTime;
    }



    public void setEventTime(String eventTime) {
      EventTime = eventTime;
    }



    public String getEventlocation() {
      return Eventlocation;
    }



    public void setEventlocation(String eventlocation) {
      Eventlocation = eventlocation;
    }



    public LinkedList<Contact> getContacts() {
      return contacts;
    }


   public void print() {
          System.out.println("Event title=" + Eventtitle);
          System.out.println("Event date=" + Eventdate);
          System.out.println("Event Time=" + EventTime);
          System.out.println("Event location=" + Eventlocation);
          System.out.println();
          System.out.println("contact/s of this event: ");
          contacts.print();
          System.out.println();
          }

    @Override
    public int compareTo(String title) {
    return Eventtitle.compareTo(title);
    }

    @Override
    public String toString() {
    return "Event title=" + 
            Eventtitle+"\nEvent date=" + 
            Eventdate+"\nEvent Time=" + EventTime+"\nEvent location=" + 
            Eventlocation+"\n";
    }
    
    

}
