// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
// Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n * 2^n), Space Complexity : O(n * 2^n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    private static void findCombinations(int idx,int[] arr,int sum,List<List<Integer>> ans,List<Integer> temp){
        if(sum == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = idx;i < arr.length;i++){
            if(i > idx && arr[i] == arr[i - 1]) continue;

            if(arr[i] > sum) break;

            temp.add(arr[i]);
            findCombinations(i + 1,arr,sum - arr[i],ans,temp);
            temp.remove(temp.size() - 1);
        }

    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        findCombinations(0,candidates,target,ans,new ArrayList<>());

        return ans; 
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2};
        int target = 4;

        List<List<Integer>> result = combinationSum2(arr, target);

        for(int i = 0;i < result.size();i++){
            System.out.print(result.get(i));

            if(i < result.size() - 1){
                System.out.print(",");
            }
        }
    }
}
