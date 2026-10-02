// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

// For example, the following two linked lists begin to intersect at node c1:

// Custom Judge:

// The inputs to the judge are given as follows (your program is not given these inputs):

// intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
// listA - The first linked list.
// listB - The second linked list.
// skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
// skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
// The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.

// intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
// Output: Intersected at '8'

// Platform : Leetcode
// Level : Easy
// Time Complexity : O(n1 + n2), Space Complexity : O(1)
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
public class FindIntersection {
     public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;

            if(tempA == tempB) return tempA;

            if(tempA == null) tempA = headB;
            if(tempB == null) tempB = headA;

        }
        return tempA;
    }
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);   
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next; // Intersection at node with value 8
        
        ListNode intersection = getIntersectionNode(headA, headB);
        if(intersection != null) {
            System.out.println("Intersected at '" + intersection.data + "'");
        } else {
            System.out.println("No intersection found.");
        }
    }
}
