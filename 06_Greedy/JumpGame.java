// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

// Return true if you can reach the last index, or false otherwise.

// Example 1:

// Input: nums = [2,3,1,1,4]
// Output: true

// Platform: LeetCode
// Level: Medium
// Time Complexity: O(n), Space Complexity: O(1)

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int maxIdx = 0;

        for(int i = 0;i < nums.length;i++){
            if(i > maxIdx) return false;

            maxIdx = Math.max(maxIdx,i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        System.out.println(canJump(nums));
    }
}
