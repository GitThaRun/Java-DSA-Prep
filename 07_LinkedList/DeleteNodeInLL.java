// There is a singly-linked list head and we want to delete a node node in it.

// You are given the node to be deleted node. You will not be given access to the first node of head.

// All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.

// Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

// The value of the given node should not exist in the linked list.
// The number of nodes in the linked list should decrease by one.
// All the values before node should be in the same order.
// All the values after node should be in the same order.

// Input: head = [4,5,1,9], node = 5
// Output: [4,1,9]

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(1), Space Complexity : O(1)

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class DeleteNodeInLL {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;

        node.next = node.next.next;
    }
    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        ListNode nodeToDelete = head.next.next;

        deleteNode(nodeToDelete);
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
