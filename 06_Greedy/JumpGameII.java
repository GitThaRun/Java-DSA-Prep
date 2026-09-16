// You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

// Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:

// 0 <= j <= nums[i] and
// i + j < n
// Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.

// Platform: LeetCode
// Level: Medium
// Time Complexity: O(n), Space Complexity: O(1)

public class JumpGameII {
    public static int jump(int[] nums) {
        int jumps = 0, curr_idx = 0, farthest = 0;

        for(int i = 0;i < nums.length - 1;i++){
            farthest = Math.max(i + nums[i],farthest);

            if(i == curr_idx){
                jumps++;

                curr_idx = farthest;
            }
        }
        return jumps;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        System.out.println(jump(nums));
    }
}
