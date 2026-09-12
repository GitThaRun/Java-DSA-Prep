// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n * 2^n), Space Complexity : O(n * 2^n)

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int subsets = 1 << n;

        for(int i = 0;i < subsets;i++){
            List<Integer> temp = new ArrayList<>();

            for(int j = 0;j < n;j++){
                if((i & (1 << j)) != 0){
                    temp.add(nums[j]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        System.out.println(subsets(nums));
    }
}
