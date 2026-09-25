// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]

// Platform : LeetCode
// Level : Medium
// Time Complexity : O(max(m,n)) where m and n are the lengths of the two linked lists.
// Space Complexity : O(max(m,n)) for the new linked list.

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
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int carry = 0;

        while(temp1 != null || temp2 != null){
            int sum = carry;

            if(temp1 != null){
                sum += temp1.data;
                temp1 = temp1.next;
            }

            if(temp2 != null){
                sum += temp2.data;
                temp2 = temp2.next;
            }
            
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;

            current.next = newNode;
            current = current.next;
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);

        while(result != null){
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
