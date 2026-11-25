// Given the head of a doubly linked list and an integer target. Delete all nodes in the linked list with the value target and return the head of the modified linked list.

// Example 1:
// Input: head -> 1 <-> 2 <-> 3 <-> 1 <-> 4, target = 1

// Output: head -> 2 <-> 3 <-> 4

// Platform : Striver SDE Sheet
// Level : Medium
// Time Complexity : O(n), Space Complexity : O(1)
class Node{
    int data;
    Node next;
    Node prev;

    Node(int data1,Node next1,Node prev1){
        this.data = data1;
        this.next = next1;
        this.prev = prev1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
        this.prev = null;
    }
}
public class DeleteOccurrences {
    private static Node convertToDll(int[] nums){
        Node head = new Node(nums[0]);
        Node prev = head;
        for(int i = 1;i < nums.length;i++){
            Node temp = new Node(nums[i],null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    private static void print(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public static Node deleteOccurrences(Node head,int k){
        if(head == null) return null;

        Node temp = head;
        while(temp != null){

            if(temp.data == k){

                Node nextNode = temp.next;
                Node prevNode = temp.prev;

                if(temp == head){
                    head = nextNode;
                }

                if(nextNode != null){
                    nextNode.prev = prevNode;
                }
                if(prevNode != null){
                    prevNode.next = nextNode;
                }
                temp = nextNode;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,4};
        int target = 1;

        Node head = convertToDll(arr);
        head = deleteOccurrences(head, target);

        print(head);
    }
}
