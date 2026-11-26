import java.util.ArrayList;
import java.util.List;

// Design a stack data structure by using an array. A stack follows the Last In, First Out (LIFO) property, so the newest inserted value must be removed before older values.

// The stack must support push, pop, peek, isEmpty, and size operations. A fixed capacity is given during stack creation. Push operations must report overflow when the array has no free cell. Pop and peek operations must report underflow or empty-stack behavior when no value is present.

// The full-capacity check belongs to the array implementation only. isFull() is not a default stack operation, but the same check is useful inside push to prevent writing outside the array.

class ArrayStack {
    private int[] stack;
    private int capacity;
    private int top;

    public ArrayStack(int cap){
        stack = new int[cap];
        capacity = cap;
        top = -1;
    }

    public void push(int val,List<String> output){
        if(top == capacity - 1){
            output.add("Stack OverFlow");
            return;
        }
        top = top + 1;
        stack[top] = val;
        output.add("Pushed " + val);
    }
    public void pop(List<String> output){
        if(top == -1){
            output.add("Stack UnderFlow");
            return;
        }
        int removedVal = stack[top];
        top = top - 1;
        output.add("Popped " + removedVal);
    }
    public void peek(List<String> output){
        if(top == -1){
            output.add("Stack Is Empty");
            return;
        }
        output.add("Top = " + stack[top]);
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public int size(){
        return top + 1;
    }
}
class solution{
    public static List<String> runStackOperations(){
        List<String> output = new ArrayList<>();

        ArrayStack stack = new ArrayStack(4);

        stack.push(1,output);
        stack.push(2,output);
        stack.push(3,output);
        stack.peek(output);

        output.add("Size is : " + stack.size());
        stack.pop(output);
        stack.peek(output);
        output.add("Size is : " + stack.size());
        output.add("Is Empty : " + stack.isEmpty());

        return output;
    }
}
public class ImplementStackArray {
    public static void main(String[] args) {

        List<String> result = solution.runStackOperations();
        for(String str : result){
            System.out.println(str);
        }
    }
}
