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
public class DeleteHead {
    public static Node deleteHeadNode(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node prev = head;
        head = head.next;

        head.prev = null;
        prev.next = null;

        return head;
    }
    private static void print(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head = deleteHeadNode(head);

        print(head);
    }
}
