// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
// Return the number of nice sub-arrays.

// Example 1:

// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n), Space Complexity : O(1)

public class Count_Nice_SubArrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k - 1);
    }
    
    private static int atMost(int[] nums,int goal){
        int left = 0, res = 0;

        for(int right = 0;right < nums.length;right++){
            if(nums[right] % 2 != 0){
                goal--;
            }
            while(goal < 0){
                if(nums[left] % 2 != 0){
                    goal++;
                }
                left++;
            }
            res += (right - left) + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums,k));
    }
}
