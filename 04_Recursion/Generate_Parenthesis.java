// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

// Platfrom : Leetcode
// Level : Medium
// Time Complexity : O(4^n / sqrt(n)), where n is the number of pairs of parentheses
// Space Complexity : O(n), where n is the number of pairs of parentheses

import java.util.ArrayList;
import java.util.List;

public class Generate_Parenthesis {
    private static void findCombinations(int open,int close,int n,List<String> result,StringBuilder current){
        if(current.length() == 2 * n){
            result.add(current.toString());
            return;
        }

        if(open < n){
            current.append('(');

            findCombinations(open + 1,close,n,result,current);

            current.deleteCharAt(current.length() - 1);
        }

        if(close < open){
            current.append(')');

            findCombinations(open,close + 1,n,result,current);

            current.deleteCharAt(current.length() - 1);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        findCombinations(0,0,n,result,current);

        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> combinations = generateParenthesis(n);

        System.out.print("[");
        for(int i = 0;i < combinations.size();i++){
            System.out.print(combinations.get(i));

            if(i < combinations.size() - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
