// Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

// The first node is considered odd, and the second node is even, and so on.

// Note that the relative order inside both the even and odd groups should remain as it was in the input.

// Input: head = [1,2,3,4,5]
// Output: [1,3,5,2,4]

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
public class OddEvenLL {
     public static ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) return head;
        
        ListNode oddIdx = head;
        ListNode EvenIdx = head.next;
        ListNode EvenHead = head.next;

        while(EvenIdx != null && EvenIdx.next != null){

            oddIdx.next = oddIdx.next.next;
            EvenIdx.next = EvenIdx.next.next;

            oddIdx = oddIdx.next;
            EvenIdx = EvenIdx.next;
        }
        oddIdx.next = EvenHead;

        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next= new ListNode(5);

        head = oddEvenList(head);

        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
