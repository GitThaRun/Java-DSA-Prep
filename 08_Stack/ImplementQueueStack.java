
import java.util.Stack;

// Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

// Implement the MyQueue class:

// void push(int x) Pushes element x to the back of the queue.
// int pop() Removes the element from the front of the queue and returns it.
// int peek() Returns the element at the front of the queue.
// boolean empty() Returns true if the queue is empty, false otherwise.

// Input
// ["MyQueue", "push", "push", "peek", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 1, 1, false]

// Platform : Leetcode
// Level : Easy
// Time Complexity : O(1) for push, O(n) for pop and peek
// Space Complexity : O(n)
class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    private void shiftShacks(){
        if(!s2.isEmpty()) return;

        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        shiftShacks();

        if(s2.isEmpty()) return -1;

        int popVal = s2.peek();
        s2.pop();

        return popVal;
    }
    
    public int peek() {
        shiftShacks();

        if(s2.isEmpty()) return -1;

        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
public class ImplementQueueStack {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(10);
        obj.push(20);
        obj.push(30);

        System.out.println("Peek Element : " + obj.peek());
        System.out.println("Popped Element : "+obj.pop());
        System.out.println("Peek Element : " + obj.peek());
    }
}
