// Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
// A subarray is a contiguous part of the array.

// Example 1:

// Input: nums = [1,0,1,0,1], goal = 2
// Output: 4
// Explanation: The 4 subarrays are bolded and underlined below:
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n), Space Complexity : O(1)

public class Binary_SubArray_With_Sum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums,goal) - atMost(nums,goal - 1);
    }

    private static int atMost(int[] nums,int k){
        if(k < 0) return 0;

        int left = 0, sum = 0, count = 0;

        for(int right = 0;right < nums.length;right++){
            sum += nums[right];

            while(sum > k){
                sum -= nums[left];
                left++;
            }

            count += (right - left) + 1;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums,goal));
    }
}
