
import java.util.LinkedList;
import java.util.Queue;

// Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

// Implement the MyStack class:

// void push(int x) Pushes element x to the top of the stack.
// int pop() Removes the element on the top of the stack and returns it.
// int top() Returns the element on the top of the stack.
// boolean empty() Returns true if the stack is empty, false otherwise.

// Platform : Leetcode
// Level : Easy
// Time Complexity : O(n) for push, O(1) for pop and top
// Space Complexity : O(n)
class MyStack{
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q2.offer(x);

        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
public class ImplementStackQueue {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(10);
        obj.push(20);
        obj.push(30);

        System.out.println("Top Element : " + obj.top());
        System.out.println("Popped Element : "+obj.pop());
        System.out.println("Top Element : " + obj.top());

        System.out.println("Is Stack Empty : " + obj.empty());
        System.out.println("Popped Element : "+obj.pop());
        System.out.println("Popped Element : "+obj.pop());

        System.out.println("Is Stack Empty : " + obj.empty());
    }
}
