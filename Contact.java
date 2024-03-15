/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project212;

import java.util.Scanner;

/**
 *
 * @author haifaalsedairy
 */
public class Contact implements Comparable<String>{
    private String conName,conNumber,conEmail,conAddress,conBirthday,conNotes;
    private LinkedList<Event> events=new LinkedList<Event>();
;
    
    public Contact() {
        
    }

    public Contact(String conName, String conNumber, String conEmail, String conAddress, String conBirthday, String conNotes) {
        this.conName = conName;
        this.conNumber = conNumber;
        this.conEmail = conEmail;
        this.conAddress = conAddress;
        this.conBirthday = conBirthday;
        this.conNotes = conNotes;
    }

    
    
    
    public int compareTo(String name) {
 
    return conName.compareTo(name);
    }

    @Override
    public String toString() {
        return "\nName=" + conName + "\nNumber=" + conNumber + "\nEmail=" + conEmail + "\nAddress=" + conAddress + "\nBirthday=" + conBirthday + "\nNotes=" + conNotes;
    }
        

    
    
    public void readContact(){
        Scanner read=new Scanner(System.in);
        System.out.println("enter contact name:");
        conName=read.nextLine();
        System.out.println("enter contact phone number:");
        conNumber=read.nextLine();
        System.out.println("enter contact email:");
        conEmail=read.nextLine();
        System.out.println("enter contact address:");
        conAddress=read.nextLine();
        System.out.println("enter contact birthday:");
        conBirthday=read.nextLine();
        System.out.println("enter contact notes:");
        conNotes=read.nextLine();
        
    }
    

    public String getConName() {
        return conName;
    }

    public String getConNumber() {
        return conNumber;
    }

    public String getConEmail() {
        return conEmail;
    }

    public String getConAddress() {
        return conAddress;
    }

    public String getConBirthday() {
        return conBirthday;
    }

    public LinkedList<Event> getEvents() {
        return events;
    }
    
    public void print() {
    System.out.println("Name: "+conName);
    System.out.println("phone Number: "+conNumber);
    System.out.println("Email Address: " + conEmail);
    System.out.println("Address: " + conAddress);
    System.out.println("Birthday: "+ conBirthday);
    System.out.println("Notes: "+ conNotes);
    System.out.println();
    }
    
   
   
    
}

