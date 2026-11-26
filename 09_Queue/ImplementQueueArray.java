// Design a queue data structure using a fixed-capacity array of size capacity. The queue must support push(x), pop(), peek(), empty(), and size().

// push(x) inserts x at the rear when the queue is not full.
// pop() removes and returns the front value.
// peek() returns the front value without removing it.
// empty() returns whether the queue contains no values.
// size() returns the current number of stored values.
// When the queue is full, push(x) performs no insertion. When the queue is empty, pop() and peek() return -1


class ArrayQueue {
    private int[] queue;
    private int capacity;
    private int currSize;
    private int start;
    private int end;

    public ArrayQueue(int cap) {
        capacity = cap;
        currSize = 0;
        start = -1;
        end = -1;
        queue = new int[capacity];
    }

    public void push(int val) {

        if (currSize == capacity) {
            return;
        }

        if (currSize == 0) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % capacity;
        }

        queue[end] = val;
        currSize++;
    }

    public int peek() {
        if (currSize == 0) {
            return -1;
        }

        return queue[start];
    }

    public int poll() {
        if (currSize == 0) {
            return -1;
        }

        int frontVal = queue[start];

        if (currSize == 1) {
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % capacity;
        }

        currSize--;
        return frontVal;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public int size() {
        return currSize;
    }
}

public class ImplementQueueArray {
    public static void main(String[] args) {

        ArrayQueue obj = new ArrayQueue(4);

        obj.push(1);
        obj.push(2);
        obj.push(3);

        System.out.println(obj.peek());
        System.out.println(obj.poll());
        System.out.println(obj.peek());
        System.out.println(obj.isEmpty());
    }
}
