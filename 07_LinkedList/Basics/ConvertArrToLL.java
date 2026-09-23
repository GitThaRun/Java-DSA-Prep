class Node{
    int data;
    Node next;

    Node(int data1,Node next1){
        this.data = data1;
        this.next = next1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
};
public class ConvertArrToLL {

    private static Node convert2LL(int[] nums){
    Node head = new Node(nums[0]);
    Node mover = head;

    for(int i = 1;i < nums.length;i++){
        Node temp = new Node(nums[i]);
        mover.next = temp;
        mover = temp;
    }
    return head;
}
    public static void main(String[] args) {
        int[] nums = {2,4,6,8,10};

        Node head = convert2LL(nums);

        System.out.println(head.data);
    }
}
