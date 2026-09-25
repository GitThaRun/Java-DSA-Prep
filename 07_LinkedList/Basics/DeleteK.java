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

public class DeleteK {
    public static ListNode deleteKthNode(ListNode head, int k) {
        if(head == null) return head;

        if(k == 1){
            head = head.next;
            return head;
        }

        int count = 0;
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            count++;

            if(count == k){
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

        int k = 2;

        head = deleteKthNode(head, k);

        ListNode temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
