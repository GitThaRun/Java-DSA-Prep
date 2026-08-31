// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(c(9,k) * k), where c(9,k) represent choosing k nums from 9
// Space Complexity : O(c(9,k) * k),including ouput| Excluding output : O(k)

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    private static void validCombos(int start,int k,int remaining,List<List<Integer>> result,List<Integer> temp){
        if(k == 0){
            if(remaining == 0){
                result.add(new ArrayList<>(temp));
            }
            return;
    }
    for(int i = start;i <= 9;i++){
                if(i > remaining) break;

                temp.add(i);

                validCombos(i + 1,k - 1,remaining - i,result,temp);

                temp.remove(temp.size() - 1);
            }
        }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        validCombos(1,k,n,result,current);

        return result;
    }

    public static void main(String[] args) {
        int k = 3, n = 9;
        List<List<Integer>> result = combinationSum3(k, n);

        for(int i = 0;i < result.size();i++){
            System.out.print(result.get(i));

            if(i < result.size() - 1){
                System.out.print(",");
            }
        }
    }
}
