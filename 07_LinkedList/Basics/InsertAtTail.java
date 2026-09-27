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
public class InsertAtTail {
     public static ListNode insertAtTail(ListNode head, int X) {
        
        if(head == null){
            return new ListNode(X);
        }
        ListNode temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        ListNode newNode = new ListNode(X);

        temp.next = newNode;

        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        int X = 7;

        head = insertAtTail(head, X);
        ListNode temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
