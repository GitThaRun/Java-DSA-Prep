// Given the head of a singly Linked List. Traverse the entire Linked List and return its elements in an array in the order of their appearance.

// Example 1:

// Input: linkedList = [5, 4, 3, 1, 0]
// Output: [5, 4, 3, 1, 0]

// Platform : SDE Sheet
// Level : Easy
// Time Complexity: O(n), where n is the number of nodes in the linked list.
// Space Complexity: O(1), excluding output

import java.util.ArrayList;
import java.util.List;

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
}

public class TraversalInLL {
    public static List<Integer> LLTraversal(ListNode head){
        List<Integer> result = new ArrayList<>();

        ListNode temp = head;
        while(temp != null){
            result.add(temp.data);

            temp = temp.next;
        }
        return result;
    }
     public static void main(String[] args) {

        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);

        List<Integer> result = LLTraversal(head);

        System.out.println(result);
    }
}
