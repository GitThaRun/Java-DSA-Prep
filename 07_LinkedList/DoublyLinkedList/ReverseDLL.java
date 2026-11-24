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
public class ReverseDLL {
    public static Node reverse(Node head){

        if(head == null || head.next == null){
            return head;
        }

        Node last = null;
        Node current = head;

        while(current != null){
            last = current.prev;
            current.prev = current.next;
            current.next = last;

            current = current.prev;
        }
        return last.prev;
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
        int[] arr = {1,2,3,4,5};
        Node head = convertToDll(arr);

        head = reverse(head);
        print(head);
    }
}
