
import java.util.Arrays;
import java.util.Stack;

// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

// Example 1:

// Input: nums = [1,2,1]
// Output: [2,-1,2]

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n), Space Complexity : O(n)

public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        Arrays.fill(nge,-1);
        for(int i = 2 * n - 1;i >= 0;i--){

            int idx = i % n;

            while(!st.isEmpty() && nums[st.peek()] <= nums[idx]){
                st.pop();
            }
            if(i < n && !st.isEmpty()){
                nge[idx] = nums[st.peek()];
            }
            st.push(idx);
        }
        return nge;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] result = nextGreaterElements(nums);
        System.out.println(Arrays.toString(result));
    }
}
