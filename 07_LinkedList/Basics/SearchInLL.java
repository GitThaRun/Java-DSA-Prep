// You are given the head of a singly linked list and an integer key.

// Return true if the key exists in the linked list, otherwise return false.

// Example 1:
// Input: head = [1, 2, 3, 4], key = 3

// Output: true

// Platform : SDE Sheet
// Level : Easy
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
public class SearchInLL {
    public static boolean searchKey(ListNode head,int key){
        ListNode temp = head;

        while(temp != null){
            if(temp.data == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        int key = 3;

        System.out.println(searchKey(head, key));
    }
}
