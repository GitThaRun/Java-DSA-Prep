// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n * 2 ^ n), Space Complexity : O(n * 2 ^ n) including output

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    private static void generateSubsets(int idx,int[] arr,List<List<Integer>> res,List<Integer> temp){
        res.add(new ArrayList<>(temp));

        for(int i = idx;i < arr.length;i++){
            if(i > idx && arr[i] == arr[i - 1]) continue;

            temp.add(arr[i]);
            generateSubsets(i + 1,arr,res,temp);

            temp.remove(temp.size() - 1);
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        generateSubsets(0,nums,result,new ArrayList<>());

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};

        List<List<Integer>> ans = subsetsWithDup(nums);

        for(int i = 0;i < ans.size();i++){
            System.out.print(ans.get(i));

            if(i < ans.size() - 1){
                System.out.print(",");
            }
        }
    }
}
