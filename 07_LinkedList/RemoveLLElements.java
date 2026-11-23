// Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

// Input: head = [1,2,6,3,4,5,6], val = 6
// Output: [1,2,3,4,5]

// Platform : Leetcode
// Level : Easy

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
public class RemoveLLElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(0,head);
        ListNode dummy = start;

        while(dummy != null){
            while(dummy.next != null && dummy.next.data == val){
                dummy.next = dummy.next.next;
            }
            dummy = dummy.next;
        }
        return start.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        int val = 6;
        head = removeElements(head, val);

        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
