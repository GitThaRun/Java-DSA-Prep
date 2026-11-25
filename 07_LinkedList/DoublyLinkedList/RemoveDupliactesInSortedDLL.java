// Given the head of a doubly linked list with its values sorted in non-decreasing order. Remove all duplicate occurrences of any value in the list so that only distinct values are present in the list.

// Return the head of the modified linked list.

// Example 1:
// Input: head -> 1 <-> 1 <-> 3 <-> 3 <-> 4 <-> 5

// Output: head -> 1 <-> 3 <-> 4 <-> 5

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
public class RemoveDupliactesInSortedDLL {
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
    public static Node removeDuplicates(Node head){
        if(head == null) return null;
        Node temp = head;

        while(temp != null && temp.next != null){
            if(temp.data == temp.next.data){
                Node nxtNode = temp.next;

                temp.next = nxtNode.next;
                if(nxtNode.next != null){
                    nxtNode.next.prev = temp;
                }
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,3,3,4};

        Node head = convertToDll(arr);
        head = removeDuplicates(head);

        print(head);
    }
}
