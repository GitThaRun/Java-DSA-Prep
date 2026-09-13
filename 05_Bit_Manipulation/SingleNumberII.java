// Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:

// Input: nums = [2,2,3,2]
// Output: 3

// Platform : Leetcode
// Level : Medium
// Approach 1:
// Time Complexity : O(n * 31), Space Complexity : O(1)

import java.util.Arrays;

public class SingleNumberII {
    // Approach 1
    // public static int singleNumber(int[] nums){
    //     int ans = 0;
    //     for(int bit = 0;bit < 31;bit++){
    //         int count = 0;
    //         for(int num = 0;num < nums.length;num++){
    //             if((nums[num] & (1 << bit)) != 0){
    //                 count++;
    //             }
    //         }
    //         if(count % 3 == 1){
    //                 ans = ans | (1 << bit);
    //             }
    //     }
    //     return ans;
    // }

    // Approach 2
    public static int singleNum(int[] nums){
        Arrays.sort(nums);
        for(int i = 1;i < nums.length;i += 3){
            if(nums[i] != nums[i - 1]){
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    // Approach 3
    public static int singleNumber(int[] nums){
        int ones = 0, twos = 0;

        for(int i = 0;i < nums.length;i++){
            ones ^= (nums[i] & ~twos);
            twos ^= (nums[i] & ~ones);
        }
        return ones;
    }
    public static void main(String[] args) {
        int[] nums = {5,5,5,6,4,4,4};

        // System.out.println(singleNumber(nums));
        // System.out.println(singleNum(nums));
        System.out.println(singleNumber(nums));
    }
}
