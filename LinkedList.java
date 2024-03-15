/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project212;

/**
 *
 * @author haifaalsedairy
 */

  class Node<T>{
  public T data;
  public Node<T> next;

  public Node(){
        data=null;
        next=null;  
  }

    public Node(T data) {
        this.data = data;
        next=null;
    }
  


}

public class LinkedList <T> {
   
    private Node<T> head;
    private Node<T> current;

   
    public LinkedList() {
        head=current=null;
    }
    
    public boolean empty(){
        return head==null;
    }
    
    public boolean full(){
        return false;
    }
    
    public void findfirst(){
        current=head;
    }
    
    public void findnext(){
       current=current.next;  
    }
    
    public T retrieve(){
        return current.data;
    }
    
    public void update(T val){
        current.data=val;
    }
    public boolean last(){
      return current.next==null;  
    }

    public boolean search(T c){
        if(head==null)
            return false;
        
        Node<T> tmp=head;
        
        while(tmp!=null)
        {
            if(tmp.data.equals(c))
                return true;
            tmp=tmp.next;}
        return false;
        
    }
    
   
    
    public void insert(T c){
      Node<T> n= new Node<T>(c);
       
      if(head==null){
            head=current=n;
            return;}
      
      n.next=current.next;
      current.next=n;
      current=n;
    }
    
    public void remove(){
        if(current==head){
            current=current.next;
            head=head.next;
        }

        else{
          Node <T> tmp=head;
            while(tmp.next!=current)
               tmp=tmp.next;
          tmp.next=current.next;
        

        if(current.next==null)
            current=head;
        else
            current=current.next;
        }
      }
       
        
     public void print(){
        Node<T> tmp=head;
        
        while(tmp!=null){
            System.out.println(tmp.data);
            tmp=tmp.next;}
     }
            
    
    public void sortedAdd(T c){
        Node<T> n=new Node<T>(c);
        
        if(head==null)
            current=head=n; 
            
            
        
        else if(((Contact)c).compareTo(((Contact)(head.data)).getConName())<0){
            n.next=head;
            head=n;
            current=n;
        }
        
        else {
            Node<T> r=null;
            Node<T> s=head;
            while(s!=null && ((Contact)c).compareTo(((Contact)(s.data)).getConName())>=0 )
            {r=s;
            s=s.next;}

            {r.next=n;
            n.next=s;
            current=n;}
        }
    }
    
    public void sortedAdd_Event(T e){
    

        Node<T> n=new Node<T>(e);
        
        if(head==null)
            current=head=n; 
            
            
        
        else if(((Event)e).compareTo(((Event)(head.data)).getEventtitle())<0){
            n.next=head;
            head=n;
            current=n;
        }
        
        else {
            Node<T> r=null;
            Node<T> s=head;
            while(s!=null && ((Event)e).compareTo(((Event)(s.data)).getEventtitle())>=0 )
            {r=s;
            s=s.next;}

            {r.next=n;
            n.next=s;
            current=n;}
        }
    }
   
        
    } 

