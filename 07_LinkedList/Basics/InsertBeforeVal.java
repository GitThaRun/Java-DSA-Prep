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
public class InsertBeforeVal {
    public static ListNode insertBeforeX(ListNode head, int X, int val) {
        
        if(head == null) return null;

        if(head.data == X){
            return new ListNode(val,head);
        }

        ListNode temp = head;

        while(temp.next != null){
            if(temp.next.data == X){
                ListNode newNode = new ListNode(val,temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        int X = 2,val = 5;
        head = insertBeforeX(head, X, val);

        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
