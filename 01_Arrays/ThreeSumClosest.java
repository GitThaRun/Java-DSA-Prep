// You are given an integer array nums of length n and an integer target.
// Find three integers at distinct indices in nums such that the sum is closest to target.
// Return the sum of the three integers.
// You may assume that each input would have exactly one solution.

// Example 1:

// Input: nums = [-1,2,1,-4], target = 1
// Output: 2

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n^2), Space Complexity : O(1)

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int sum = nums[0] + nums[1] + nums[2];

        for(int i = 0;i < nums.length;i++){
            int left = i + 1, right = nums.length - 1;

            while(left < right){
                int currSum = nums[i] + nums[left] + nums[right];

                if(Math.abs(currSum - target) < Math.abs(sum - target)){
                    sum = currSum;
                }

                if(currSum < target){
                    left++;
                }
                else if(currSum > target){
                    right--;
                }
                else{
                    return target;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;

        System.out.println(threeSumClosest(nums, target));
    }
}
