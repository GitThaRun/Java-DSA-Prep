// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

// Input: head = [1,2,2,1]
// Output: true

// Platform : Leetcode
// Level : Easy
// Time Complexity : O(2n), Space Complexity : O(1)

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
public class PalindromeLL {
    private static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
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
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverseList(slow.next);

        ListNode first = head;
        ListNode second = newHead;

        while(second != null){
            if(first.data != second.data){
                reverseList(newHead);

                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseList(newHead);
        return true;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }
}
