// Implement a First-In-First-Out (FIFO) queue using a singly linked list. The implemented queue should support the following operations: push, pop, peek, and isEmpty.

// Implement the LinkedListQueue class:

// void push(int x): Adds element x to the end of the queue.
// int pop(): Removes and returns the front element of the queue.
// int peek(): Returns the front element of the queue without removing it.
// boolean isEmpty(): Returns true if the queue is empty, false otherwise.
class Node{
    int data;
    Node next;

    Node(int val){
        data = val;
        next = null;
    }
}
class LLQueue{
    private Node start;
    private Node end;
    int size;

    public LLQueue() {
        start = null;
        end = null;
        size = 0;
    }
    public void push(int val){
        Node newNode = new Node(val);

        if(start == null){
            start = newNode;
            end = newNode;
        }
        else{
            end.next = newNode;
            end = newNode;
        }
        size++;
    }
    public int poll(){
        if(start == null){
            return -1;
        }
        
        int removedVal = start.data;
        start = start.next;

        if(start == null){
            end = null;
        }
        size--;

        return removedVal;
    }
    public int peek(){
        if(start == null) return -1;

        return start.data;
    }
    public boolean isEmpty(){
        return start == null;
    }
    public int getSize(){
        return size;
    }
}
public class ImplementQueueLL {
    public static void main(String[] args) {
        LLQueue obj = new LLQueue();

        obj.push(7);
        obj.push(2);
        obj.push(3);
        obj.push(5);

        System.out.println(obj.peek());
        System.out.println(obj.poll());
        System.out.println(obj.poll());
        System.out.println(obj.peek());
        System.out.println(obj.isEmpty());
        System.out.println(obj.getSize());
    }
}
