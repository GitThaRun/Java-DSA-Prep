// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

// Platform : Leetcode
// Level : Hard
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
public class ReverseNodeInKGroup {
    private static ListNode getKthNode(ListNode current,int k){
        while(current != null && k > 1){
            current = current.next;
            k--;
        }
        return current;
    }
    private static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;

        while(current != null){
            ListNode front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }
        return prev;
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1) return head;

        ListNode temp = head;
        ListNode prevLast = null;

        while(temp != null){
            ListNode kthNode = getKthNode(temp,k);

            if(kthNode == null){
                if(prevLast != null){
                    prevLast.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            reverseList(temp);

            if(temp == head){
                head = kthNode;
            }
            else{
                prevLast.next = kthNode;
            }

            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode result = reverseKGroup(head, k);

        while(result != null){
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
