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
public class InsertBeforeHead {
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
    public static Node insertHead(Node head,int val){
        Node newHead = new Node(val,head,null);

        head.prev = newHead;

        return newHead;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6};
        int val = 1;

        Node head = convertToDll(arr);
        head = insertHead(head, val);

        print(head);
    }
}
