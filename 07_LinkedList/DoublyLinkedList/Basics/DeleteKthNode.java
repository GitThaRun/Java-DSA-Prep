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

public class DeleteKthNode {
    private static Node deleteHeadNode(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node prev = head;
        head = head.next;

        head.prev = null;
        prev.next = null;

        return head;
    }
    private static Node deleteTailNode(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        Node prev = tail.prev;
        prev.next = null;
        tail.prev = null;

        return head;
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
    public static Node deleteElement(Node head,int k){
        if(head == null){
            return null;
        }

        int count = 0;
        Node kNode = head;
        while(kNode != null){
            count++;
            if(count == k){
                break;
            }
            kNode = kNode.next;
        }
        if(kNode == null){
            return head;
        }
        
        Node prev = kNode.prev;
        Node front = kNode.next;

        if(prev == null && front == null){
            return null;
        }
        else if(prev == null){
            return deleteHeadNode(head);
        }
        else if(front == null){
            return deleteTailNode(head);
        }
        prev.next = front;
        front.prev = prev;

        kNode.next = null;
        kNode.prev = null;

        return head;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6};
        int k = 4;
        Node head = convertToDll(nums);

        head = deleteElement(head, k);
        print(head);
    }
}
