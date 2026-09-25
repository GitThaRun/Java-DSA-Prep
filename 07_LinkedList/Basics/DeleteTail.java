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
public class DeleteTail {
    public static ListNode removeTail(ListNode head){
        if (head == null || head.next == null) {
            return null;
        }
        ListNode temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        head = removeTail(head);

        ListNode temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
