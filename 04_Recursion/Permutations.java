// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n * n!), Space Complexity : O(n)

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result,nums,new ArrayList<>());
        return result;
    }
    public static  void backtrack(List<List<Integer>> result, int[] nums,List<Integer> temp){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        else{
            for(int i = 0;i < nums.length;i++){
                if(temp.contains(nums[i])) continue;

                temp.add(nums[i]);

                backtrack(result,nums,temp);

                temp.remove(temp.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }
}
