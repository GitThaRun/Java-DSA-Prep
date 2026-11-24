// Given the head of a singly linked list representing a non-negative integer, add one to the number and return the updated linked list. The head node stores the most significant digit, and each node stores one digit.

// Example 1
// Input: head = [2, 3, 4]

// Output: [2, 3, 5]

// Platform : Striver SDE Sheet
// Level : Medium
// Time Complexity(Recursion) : O(n), Space Complexity : O(n)
// Time Complexity(Optimal) : O(n), Space Complexity : O(1)

class ListNode {
    public int data;
    public ListNode next;

    ListNode() {
        data = 0;
        next = null;
    }

    ListNode(int x) {
        data = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        data = x;
        this.next = next;
    }
};
public class AddOneToNumber {
    // private static int addCarry(ListNode head){
    //     if(head == null) return 1;

    //     int carry = addCarry(head.next);
    //     int sum = head.data + carry;

    //     head.data = sum % 10;

    //     return sum / 10;
    // }
    // public static ListNode bruteAddOne(ListNode head){
    //     int carry = addCarry(head);

    //     if(carry > 0){
    //         ListNode newHead = new ListNode(carry);
    //         newHead.next = head;
    //         return newHead;
    //     }
    //     return head;
    // }

    // Optimal 
    private static ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
     }
    public static ListNode addOne(ListNode head){
        head = reverseList(head);

        int carry = 1;

        ListNode current = head;
        ListNode prev = null;

        while(current != null && carry > 0){
            int sum = current.data + carry;

            current.data = sum % 10;

            carry = sum / 10;

            prev = current;
            current = current.next;
        }
        if(carry > 0){
            prev.next = new ListNode(carry);
        }
        head = reverseList(head);

        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);

        // head = bruteAddOne(head);
        head = addOne(head);
        
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
