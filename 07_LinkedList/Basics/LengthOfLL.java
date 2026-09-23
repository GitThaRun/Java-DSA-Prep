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

public class LengthOfLL {
    public static int count(ListNode head){
        ListNode temp = head;
        int count = 0;

        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);

        System.out.println(count(head));
    }
}
