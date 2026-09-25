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
public class DeleteWithVal {
    public static ListNode deleteNodeWithValueX(ListNode head, int X) {

        if(head == null) return head;

        if(head.data == X){
            head = head.next;
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            if(temp.data == X){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);

        int X = 3;

        head = deleteNodeWithValueX(head, X);

        ListNode temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
