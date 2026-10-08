import java.util.HashMap;

// A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

// Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

// Platform : Leetcode
// Level : Medium
// Approach 1 : HashMap
//     Time Complexity : O(n), Space Complexity : O(n)
// Approach 2 : Interweaving the original and copied nodes
//     Time Complexity : O(n), Space Complexity : O(1)
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {

    // Approach 1 : HashMap
    public static Node copyRandomList(Node head) {

        if(head == null) return null;

        HashMap<Node,Node> map = new HashMap<>();
        Node temp = head;

        while(temp != null){
            map.put(temp,new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null){

            Node copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);

            temp = temp.next;
        }
        return map.get(head);
    }

    // Approach 2 : Interweaving the original and copied nodes
    public static Node copyRandomList2(Node head) {
        if(head == null) return null;

        Node temp = head;

        while(temp != null){

            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;

            temp = copy.next;
        }

        temp = head;
        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        Node dummy = head.next;
        temp = head;

        while(temp != null){
            Node copy = temp.next;
            temp.next = copy.next;

            if(copy.next != null){
                copy.next = copy.next.next;
            }

            temp = temp.next;
        }
        return dummy;
    }
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);


        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next;       
        head.next.next.next.next.random = head;

        // Node copiedHead = copyRandomList(head);
        Node copiedHead = copyRandomList2(head);
        
        Node current = copiedHead;
        while (current != null) {
            System.out.print("Node value: " + current.val);
            if (current.random != null) {
                System.out.print(", Random points to: " + current.random.val);
            } else {
                System.out.print(", Random points to: null");
            }
            System.out.println();
            current = current.next;
        }
    }
}
