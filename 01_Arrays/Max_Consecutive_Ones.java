// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

// Example 1:

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

// Platform : Leetcode
// Level : Medium
// Approach(Sliding Window) : Time complexity : O(n), Space Complexity : O(1)

public class Max_Consecutive_Ones {
    public static int longestOnes(int[] nums,int k){
        int left = 0, maxLen = 0, zeroCount = 0;

        for(int right = 0;right < nums.length;right++){
            if(nums[right] == 0){
                zeroCount++;
            }

            if(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen,right - left + 1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 3;

        System.out.println(longestOnes(nums, k));
    }
}
