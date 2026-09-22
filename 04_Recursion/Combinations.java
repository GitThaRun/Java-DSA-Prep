// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

// You may return the answer in any order.

// Example 1:

// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

// Platform : Leetcode
// Level : Medium
// Time Complexity :  O(k × C(n,k)), Space Complexity : O(k) excluding output space

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(1,n,k,result,new ArrayList<>());

        return result;
    }

    private static void backtrack(int start,int end,int k,List<List<Integer>> result,List<Integer> temp){
        if(temp.size() == k){
            result.add(new ArrayList<>(temp));

            return;
        }

        for(int i = start;i <= end;i++){
            temp.add(i);

            backtrack(i + 1,end,k,result,temp);

            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        System.out.println(combine(n, k));
    }
}
