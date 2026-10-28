// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(N), Space Complexity : O(1)
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
public class ReverseLLII {
     public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode b = dummy;
        for(int i = 1; i < left;i++){
            b = b.next;
        }
        ListNode prev = null;
        ListNode curr = b.next;

        for(int i = left;i <= right;i++){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        ListNode start = b.next;
        b.next = prev;
        start.next = curr;

        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2, right = 4;
        head = reverseBetween(head, left, right);
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
