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
public class Structure {
    public static void main(String[] args){
        int[] nums = {1,2,4,5,6};

        Node x = new Node(nums[4]);
        System.out.println(x.data);
    }
}
