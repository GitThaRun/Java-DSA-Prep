// Given the head of a linked list, rotate the list to the right by k places.

// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n), Space Complexity : O(1)

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

public class RotateLLByK {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int len = 1;
        ListNode tail = head;

        while(tail.next != null){
            len++;
            tail = tail.next;
        }

        if(k % len == 0) return head;
        k %= len;

        ListNode newTail = head;

        for(int i = 1;i < len - k;i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        tail.next = head;
        newTail.next = null;

        return newHead;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode temp = rotateRight(head, k);

        while(temp != null){
            System.out.print(temp.data + " ");

            temp = temp.next;
        }
    }
}
