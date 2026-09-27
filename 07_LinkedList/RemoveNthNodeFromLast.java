// Given the head of a linked list, remove the nth node from the end of the list and return its head.

// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

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
public class RemoveNthNodeFromLast {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode fast = head;
       ListNode slow = head;

       for(int i = 0;i < n;i++){
        fast = fast.next;
       }

       if(fast == null){
        return head.next;
       }

       while(fast.next != null){
        slow = slow.next;
        fast = fast.next;
       }
       ListNode delNode = slow.next;
       slow.next = slow.next.next;

       return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        head = removeNthFromEnd(head, k);

        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
