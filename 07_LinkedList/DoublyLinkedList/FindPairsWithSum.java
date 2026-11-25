
import java.util.ArrayList;

// Given the head of a sorted doubly linked list of positive distinct integers, and a target integer, return a 2D array containing all unique pairs of nodes (a, b) such that a + b == target.

// Each pair should be returned as a 2-element array [a, b] with a < b. The list is sorted in ascending order. If there are no such pairs, return an empty list.

// Example 1:
// Input: head = [1, 2, 4, 5, 6, 8, 9], target = 7

// Output: [[1, 6], [2, 5]]

// Platform : Striver SDE Sheet
// Level : Medium
// Time Complexity : O(n), Space Complexity : O(1)
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
public class FindPairsWithSum {
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

    public static ArrayList<ArrayList<Integer>> findPairs(Node head,int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(head == null) return result;

        Node left = head;
        Node right = head;

        while(right.next != null){
            right = right.next;
        }
        while(left != right && right.next != left){
            int sum = left.data + right.data;

            if(sum == target){
                ArrayList<Integer> pairs = new ArrayList<>();
                pairs.add(left.data);
                pairs.add(right.data);
                result.add(pairs);

                left = left.next;
                right = right.prev;
            }

            else if(sum < target){
                left = left.next;
            }
            else{
                right = right.prev;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,8};
        int target = 7;

        Node head = convertToDll(arr);
        ArrayList<ArrayList<Integer>> result = findPairs(head,target);
        
        for(ArrayList<Integer> pair : result){
            System.out.println(pair);
        }
    }
}
