// Given an array nums of n integers. Return array of sum of all subsets of the array nums.
// Output can be returned in any order.

// Example 1
// Input : nums = [2, 3]
// Output : [0, 2, 3, 5]

// Platform : Striver SDE Sheet
// Level : Medium
// Time Complexity : O(n * 2^n), Space Complexity : O(n * 2^n) including output

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumOfSubSequences {
    private static void generateSequence(int idx, int[] arr,int sum,List<Integer> sumSubset){
        if(idx == arr.length){
            sumSubset.add(sum);
            return;
        }

        generateSequence(idx + 1,arr,sum + arr[idx],sumSubset);

        generateSequence(idx + 1,arr,sum,sumSubset);
    }
    public static List<Integer> subsetSums(int[] nums) {
        ArrayList<Integer> sumSubset = new ArrayList<>();
        generateSequence(0,nums,0,sumSubset);

        Collections.sort(sumSubset);

        return sumSubset;
    }

    public static void main(String[] args) {
        int[] nums = {2,3};
        List<Integer> result = subsetSums(nums);

        for(int l : result){
            System.out.print(l + " ");
        }
    }
}
