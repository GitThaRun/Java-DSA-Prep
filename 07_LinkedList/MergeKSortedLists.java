import java.util.PriorityQueue; 

// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted linked list:
// 1->1->2->3->4->4->5->6

// Platform : Leetcode
// Level : Hard
// Time Complexity(Recursive) : O(nlogk), Space Complexity(Recursive) : O(logk)
// Time Complexity : O(nlogk), Space Complexity : O(1)

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

public class MergeKSortedLists {

    // Recursive Approach
    // private static ListNode mergeRange(ListNode[] lists,int left,int right){
    //     if(left == right){
    //         return lists[left];
    //     }
    //     int mid = left + (right - left) / 2;
        
    //     ListNode list1 = mergeRange(lists,left,mid);
    //     ListNode list2 = mergeRange(lists,mid + 1, right);

    //     return merge(list1,list2);
    // }

    // public static ListNode merge(ListNode l1,ListNode l2){
    //     ListNode dummy = new ListNode(0);
    //     ListNode current = dummy;

    //     while(l1 != null && l2 != null){
    //         if(l1.data < l2.data){
    //             current.next = l1;
    //             l1 = l1.next;
    //         }
    //         else{
    //             current.next = l2;
    //             l2 = l2.next;
    //         }
    //         current = current.next;
    //     }
    //     if(l1 != null){
    //         current.next = l1;
    //     }
    //     if(l2 != null){
    //         current.next = l2;
    //     }
    //     return dummy.next;
    // }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> heap =
            new PriorityQueue<>((first, second) -> Integer.compare(first.data, second.data));

        for(ListNode head : lists){
            if(head != null){
                heap.offer(head);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(!heap.isEmpty()){

            ListNode min = heap.poll();

            curr.next = min;
            curr = curr.next;

            if(min.next != null){
                heap.offer(min.next);
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        // ListNode mergedList = mergeKLists(lists);
        ListNode mergedList = mergeKLists(lists);
        
        while (mergedList != null) {
            System.out.print(mergedList.data + " ");
            mergedList = mergedList.next;
        }
    }
}
