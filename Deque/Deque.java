package Deque;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;

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
        validateItem(item);

        Node oldFront = front;
        front = new Node();
        front.item = item;
        front.next = oldFront;
        front.previous = null;

        if(isEmpty()) back = front;
        else oldFront.previous = front;

        N++;
    }

    // Add the item to the back
    public void addLast(Item item){
        validateItem(item);

        Node oldBack = this.back;
        back = new Node();
        back.item = item;
        back.next = null;
        back.previous = oldBack;

        if(isEmpty()) front = back;
        else oldBack.next = back;

        N++;
    }

    // Remove and return the item from the front
    public Item removeFirst(){
        removeNull();

        Item item = front.item;
        front = front.next;
        N--;
        
        if(isEmpty()) back = null;
        else front.previous = null;

        return item;
    }

    // Remove and return the item from the back
    public Item removeLast(){
        removeNull();

        Item item = back.item;
        back = back.previous;
        N--;

        if(isEmpty()) front = null;
        else back.next = null;
        
        return item;
    }

    // Return an iterator over items in order from front to back
    public Iterator<Item> iterator() { return new DequeIterator(); }

    private class DequeIterator implements Iterator<Item>{
        private Node current = front;

        public boolean hasNext() { return current != null; }

        public Item next(){
            if(!hasNext()) throw new java.util.NoSuchElementException("There are no more elements in the deque to be iterated.");
            
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove(){
            throw new UnsupportedOperationException("Operation not supported.");
        }
    }


    private void validateItem(Item item){
        if (item == null) throw new IllegalArgumentException("The item cannot be null, please provide a valid item.");
    }

    private void removeNull(){
        if(isEmpty()) throw new java.util.NoSuchElementException("There are no elements to be removed in the deque.");
    }

    // Testing unit
    public static void main(String[] args){
        System.out.println("Welcome to the unit test!");
        System.out.println("\nCreating new deque of strings...");
        Deque<String> deck = new Deque<String>();

        System.out.println("\nIs the deque empty?: " + deck.isEmpty());
        System.out.println("Let's populate it, shall we?");

        for(int i = 0; i <= 5; i++){
            System.out.println("\nIngress string to be added at the front of the deque: ");
            deck.addFirst(StdIn.readString());
            System.out.println("\nElement successfully added!!!");
            System.out.println("\nDeque size: " + deck.size());
        }

        System.out.println("\nCurrent state of the deque: ");
        
        for(String s: deck){
            System.out.print(s + ", ");
        }

        for(int i = 0; i <= 5; i++){
            System.out.println("\nIngress string to be added at the back of the deque: ");
            deck.addLast(StdIn.readString());
            System.out.println("\nElement successfully added!!!");
            System.out.println("\nDeque size: " + deck.size());
        }

        System.out.println("\nCurrent state of the deque: ");
        
        for(String s: deck){
            System.out.print(s + ", ");
        }

        System.out.println("\nStarting to remove items from the back of the deque...");

        for(int i=0; i <=5; i++){
            System.out.println("\nRemoving item from the back...");
            deck.removeLast();
            System.out.println("Current size: " + deck.size());
        }

        System.out.println("\nCurrent state of the deque: ");
        
        for(String s: deck){
            System.out.print(s + ", ");
        }

        System.out.println("\nStarting to remove items from the front of the deque...");

        for(int i=0; i <=5; i++){
            System.out.println("\nRemoving item from the front...");
            deck.removeFirst();
            System.out.println("Current size: " + deck.size());
        }

        System.out.println("\nIs the deque empty?: " + deck.isEmpty());
    }
}