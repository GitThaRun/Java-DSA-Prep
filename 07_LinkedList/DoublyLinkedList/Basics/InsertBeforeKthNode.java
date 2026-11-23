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
public class InsertBeforeKthNode {
    private static Node insertHead(Node head,int val){
        Node newHead = new Node(val,head,null);

        head.prev = newHead;

        return newHead;
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
    public static Node insertBeforekth(Node head,int k,int val){
        if(k == 1){
            return insertHead(head, val);
        }
        Node temp = head;
        int count = 0;

        while(temp.next != null){
            count++;

            if(count == k) break;

            temp = temp.next;
        }

        Node prev = temp.prev;
        Node newNode = new Node(val,temp,prev);

        prev.next = newNode;
        temp.prev = newNode;

        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6};
        int k = 5;
        int val = 5;

        Node head = convertToDll(arr);
        head = insertBeforekth(head, k, val);

        print(head);
    }
}
