// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]

// Platform : Leetcode
// Level : Easy
// Time Complexity(Recursion) : O(n + m), Space Complexity : O(n + m)
// Time Complexity(Iterative) : O(n + m), Space Complexity : O(1)
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
public class MergeTwoSortedLL {
    // public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     if (list1 == null) return list2;
    //     if (list2 == null) return list1;
    //     if (list1.data <= list2.data) {
    //         list1.next = mergeTwoLists(list1.next, list2);
    //         return list1;
    //     }
    //     list2.next = mergeTwoLists(list1, list2.next);
    //     return list2;
    // }
     public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;
        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                dummy.next = list1;
                list1 = list1.next;
                dummy = dummy.next;
            }
            else{
                dummy.next = list2;
                list2 = list2.next;
                dummy = dummy.next;
            }
        }
        dummy.next = (list1 != null)?list1 : list2;
        return ptr.next;
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // ListNode mergedList = mergeTwoLists(list1, list2);

        ListNode mergedList = mergeTwoLists(list1, list2);
        while (mergedList != null) {
            System.out.print(mergedList.data + " ");
            mergedList = mergedList.next;
        }
    }
}
