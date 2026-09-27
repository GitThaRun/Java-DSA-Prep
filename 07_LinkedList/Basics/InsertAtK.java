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
public class InsertAtK {
    public static ListNode insertAtKthPosition(ListNode head, int X, int K) {

        if(head == null){
            if(K == 1){
                return new ListNode(X);
            }
            else{
                return head;
            }
        }
        if(K == 1){
            return new ListNode(X,head);
        }

        int count = 0;
        ListNode temp = head;

        while(temp != null){
            count++;

            if(count == K - 1){
                ListNode newNode = new ListNode(X);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        int X = 5, K = 2;
        head = insertAtKthPosition(head, X, K);

        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
