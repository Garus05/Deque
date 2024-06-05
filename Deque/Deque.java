package Deque;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item>{
    private Node front, back;
    private int N;

    // Inner class to implement the nodes of the linked-list.
    private class Node {
        Item item;
        Node next;
        Node previous;
    }
    
    // Construct an empty deque.
    public Deque(){
        this.front = null;
        this.back = null;
        this.N = 0;
    }

    // Is the deque empty?
    public boolean isEmpty(){
        return N == 0;
    }

    // Return the number of items on the deque
    public int size(){
        return N;
    }

    // Add the item to the front
    public void addFirst(Item item){
        Node oldFront = front;
        front = new Node();
        front.item = item;
        front.next = oldFront;
        front.previous = null;

        if(isEmpty()) front = back;
        else oldFront.previous = front;

        N++;
    }

    // Add the item to the back
    public void addLast(Item item){
        Node oldBack = this.back;
        back = new Node();
        back.item = item;
        back.next = null;
        back.previous = oldBack;

        if(isEmpty()) back = front;
        else oldBack.next = back;

        N++;
    }

    // Remove and return the item from the front
    public Item removeFirst(){
        Item item = front.item;
        front = front.next;
        
        if(isEmpty()) back = null;
        else front.previous = null;

        N--;
        return item;
    }

    // Remove and return the item from the back
    public Item removeLast(){
        Item item = back.item;
        back = back.previous;

        if(isEmpty()) front = null;
        else back.next = null;
        
        N--;
        return item;
    }

    // Return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return null;
    }

    // Testing unit
    public static void main(String[] args){

    }
}