

// Sort the given linked list and return the head of the modified list.

// Do it in-place by changing the links between the nodes without creating new nodes.

// Example 1:
// Input: linkedList = [1, 0, 2, 0 , 1]

// Output: [0, 0, 1, 1, 2]

// Platform : SDE Sheet
// Level : Medium
// Time Complexity : O(n),Space Complexity : O(1)

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
public class SortLLOf0s1s2s{
    public static ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) return head;

        ListNode ZeroNode = new ListNode(0);
        ListNode OneNode = new ListNode(0);
        ListNode TwoNode = new ListNode(0);

        ListNode ZeroTail = ZeroNode;
        ListNode OneTail = OneNode;
        ListNode TwoTail = TwoNode;

        ListNode curr = head;

        while(curr != null){
            ListNode NxtNode = curr.next;
            curr.next = null;

            if(curr.data == 0){
                ZeroTail.next = curr;
                ZeroTail = ZeroTail.next;
            }
            else if(curr.data == 1){
                OneTail.next = curr;
                OneTail = OneTail.next;
            }
            else{
                TwoTail.next = curr;
                TwoTail = TwoTail.next;
            }
            curr = NxtNode;
        }
        ZeroTail.next = (OneNode.next != null)?OneNode.next : TwoNode.next;
        OneTail.next = TwoNode.next;
        TwoTail.next = null;

        if(ZeroNode.next != null){
            return ZeroNode.next;
        }
        if(OneNode.next != null){
            return OneNode.next;
        }

        return TwoNode.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(1);

        head = sortList(head);
        ListNode temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}