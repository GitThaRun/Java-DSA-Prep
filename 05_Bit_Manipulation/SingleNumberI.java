// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:

// Input: nums = [2,2,1]
// Output: 1

// Platform : Leetcode
// Level : Easy
// Time Complexity(BruteForce) : O(n), Space Complexity : O(n)
// Time Complexity(Optimal) : O(n), Space Complexity : O(1)

public class SingleNumberI {
    // Brute Force 
    // public static int bruteSingleNumber(int[] nums){
    //     int n = nums.length;
    //     Map<Integer,Integer> map = new HashMap<>();

    //     for(int i = 0;i < n;i++){
    //         map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
    //     }
        
    //     for(int i = 0;i < n;i++){
    //         if(map.get(nums[i]) == 1){
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }

    // Optimal Approach
    public static int optimalSingleNumber(int[] nums){
        int xor = 0;

        for(int i = 0;i < nums.length;i++){
            xor = xor ^ nums[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};

        // System.out.println(bruteSingleNumber(nums));
        System.out.println(optimalSingleNumber(nums));
    }
}
