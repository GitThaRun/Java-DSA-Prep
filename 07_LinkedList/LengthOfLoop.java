

// A loop exists in a linked list if some node in the list can be reached again by continuously following the next pointer. Internally, pos is used to denote the index (0-based) of the node from where the loop starts.

// Note that pos is not passed as a parameter.

// Input: head -> 1 -> 2 -> 3 -> 4 -> 5, pos = 1

// Output: 4

// Platform : Striver SDE Sheet
// Level : Medium
// Time Complexity(Brute) : O(n + k), Space Complexity : O(n + k)
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
public class LengthOfLoop {
    // public static int bruteFindLength(ListNode head){
    //     HashSet<ListNode> visited = new HashSet();

    //     ListNode curr = head;
    //     while(curr != null){

    //         if(visited.contains(curr)){
    //             ListNode start = curr;

    //             int length = 1;

    //             curr = curr.next;

    //             while(curr != start){
    //                 length++;
    //                 curr = curr.next;
    //             }
    //             return length;
    //         }
    //         visited.add(curr);
    //         curr = curr.next;
    //     }
    //     return 0;
    // }

    // Optimal Approach
    private static int countLoopLength(ListNode meet){
        int length = 1;

        ListNode curr = meet.next;

        while(curr != meet){
            length++;
            curr = curr.next;
        }
        return length;
    }
    public static int findLength(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return countLoopLength(slow);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next;

        // int len = bruteFindLength(head);
        int len = findLength(head);
        System.out.println("Length of loop: " + len);
    }
}
