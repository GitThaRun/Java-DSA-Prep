// Given the head of a doubly linked list, remove the node at the head of the linked list and return the head of the modified list.

// The head is the first node of the linked list.

// Platform : Striver SDE Sheet
// Level : Easy
// Time Complexity : O(1), Space Complexity : O(1)

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
public class RemoveHeadOfDLL {
    public static Node removeHead(Node head){
        if(head == null) return null;

        Node newNode = head.next;
        if(newNode != null){
            newNode.prev = null;
        }
        head.next = null;

        return newNode;
    }
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
    public static void main(String[] args) {
        int[] arr = {1,2,3};

        Node head = convertToDll(arr);
        head = removeHead(head);

        print(head);
    }
}
