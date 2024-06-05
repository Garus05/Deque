package Deque;

public class Deque<Item> implements Iterable<Item>{
    Node front, back;
    int N;

    private class Node {
        Item item;
        Node next;
    }
    
    public Deque(){
        this.front = null;
        this.back = null;
        this.N = 0;
    }

    public boolean isEmpty(){
        return this.front == null;
    }

    public int size(){
        return this.N;
    }

    public void addFirst(Item item){
        Node oldFront = this.front;
        this.front = new Node();
        front.item = item;
        front.next = oldFront;
    }

    public void addLast(Item item){
        Node oldlast = last;
    }

    public Item removeFirst(){
        return null;
    }

    public Item removeLast(){
        return null;
    }

    public Iterator<Item> iterator(){
        return null;
    }

    public static void main(String[] args){

    }
}