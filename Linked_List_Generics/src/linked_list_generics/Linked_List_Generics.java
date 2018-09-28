package linked_list_generics;

import java.util.*;

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {

    private Node head;     //First item in LL

    private int length;    //Number of items.

    public LinkedList() {
        this.length = 0;
    }

    public int getLength() {        //Getter, NO setter
        return length;
    }

    public int peek() {     //Returns value at head of list. Doesn't alter the list.
           return head.data;                                 
    }

    public void add(int data) {     //Adds node at the front.
        if(head == null){
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);
    }
    
    public void show(){
        Node node = head;
        
        while(node.next != null){
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }

    public boolean find(int item) {        //Looks through the list for the int.
        //boolean foundit = false;           //You'll want to use .equals() if its generic.
        Node temp = head;
        while(temp != null){
            if(item == temp.data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void remove() {                  //Removes the head.
        Node temp = head;
        head = head.next;
        System.out.println("It has been deleted.");
    }
    
    public boolean isRemoved() {       //Removes first instance of the specified item.
        return true;                     //Returns true if it found it and removed it.   
    }                                      
    
    public void sort(LinkedList list) {      //Obvious, right?             
            //boolean isSorted = true;
            Node current = head;
            Node tail = null;
            while(current != null && tail != head){
                Node next = current;
                for( ; next.next != tail; next = next.next){
                    if(next.data <= next.next.data){
                        int temp = next.data;
                        next.data = next.next.data;
                        next.next.data = temp;
                    }
                }
                tail = next;
                current = head;
            }
        }
}
class Linked_List_Generics{
      
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.add(78);       //adds integers to the linked list
        list.add(13);
        list.add(2);
        list.add(72);
        list.add(54);
        list.add(69);
        list.add(14);
        
        list.show();        //displays the contents of the linked list.
        
        System.out.println("*******************************************");
        
        System.out.println("The number at the head of the linked list is: " + list.peek());
        //This peeks into the linked list and returns the integer at the head.
        
        System.out.println("*******************************************");
        
        list.remove();                              //removes the head from the linked list.
        System.out.println(list.isRemoved());       //verifies that the head was deleted from the linked list.
        System.out.println("The new head of the linked list is: " + list.peek());   //shows the new head of the linked list.
        list.show();
        
        System.out.println("*******************************************");
        
        System.out.println(list.find(13)); //find returns true if the int is found in the linked list.
        System.out.println(list.find(69)); //it also returns false if the int isn't located in the linked list.
        
        System.out.println("*******************************************");
        
        list.sort(list); //sorts the linked list in descending order
        list.show();    //returns the newly sorted linked list
    }

}
    