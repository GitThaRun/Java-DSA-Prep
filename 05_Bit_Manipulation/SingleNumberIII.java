// Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

// You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

// Example 1:

// Input: nums = [1,2,1,3,2,5]
// Output: [3,5]
// Explanation:  [5, 3] is also a valid answer.

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n), Space Complexity : O(1)

public class SingleNumberIII {
    public static int[] singleNumber(int[] nums) {
        long xor = 0;
        for(Integer num : nums){
            xor ^= num;
        }
        int rightmost =(int) (xor & (xor - 1)) ^ (int) xor;

        int b1 = 0, b2 = 0;
        for(int i = 0;i < nums.length;i++){
            if((nums[i] & rightmost) != 0){
                b1 ^= nums[i];
            }
            else{
                b2 ^= nums[i];
            }
        }

        return new int[]{b1,b2};
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] ans = singleNumber(nums);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
