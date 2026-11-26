// A stack data structure must be implemented with a singly linked list. Stack follows the Last-In-First-Out property, also called LIFO, where the last inserted value is removed first.

// The stack must support insertion at the top, deletion from the top, reading the top value, checking emptiness, and reporting the current size. Each linked list node stores one integer value and a pointer to the next node. A pointer named top must always refer to the current top node of the stack. An empty stack has top = null.
class Node{
    int data;
    Node next;
    
    Node(int value){
        data = value;
        next = null;
    }
}
class LLStack{
    private Node topNode;
    private int size;

    public LLStack(){
        topNode = null;
        size = 0;
    }

    public void push(int val){
        Node newNode = new Node(val);
        newNode.next = topNode;

        topNode = newNode;
        size++;
    }
    public int pop(){
        if(topNode == null) return -1;

        Node removeNode = topNode;
        int removedVal = removeNode.data;

        topNode = topNode.next;
        size--;

        return removedVal;
    }
    public int peek(){
        if(topNode == null){
            return -1;
        }
        return topNode.data;
    }
    public boolean isEmpty(){
        return topNode == null;
    }
    public int getSize(){
        return size;
    }
}
public class ImplementStackLL {
    public static void main(String[] args) {
        LLStack obj = new LLStack();

        obj.push(10);
        obj.push(20);
        obj.push(30);

        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.isEmpty());
        System.out.println(obj.getSize());
    }
}
