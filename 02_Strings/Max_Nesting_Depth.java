// Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

// Example 1:
// Input: s = "(1+(2*3)+((8)/4))+1"
// Output: 3
// Explanation:
// Digit 8 is inside of 3 nested parentheses in the string.

// Platform : Leetcode
// Level : Easy
// Time Complexity : O(n), O(1)

public class Max_Nesting_Depth {
    public static int maxDepth(String s){
        int depth = 0, maxDepth = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                depth++;
                maxDepth = Math.max(depth,maxDepth);
            }
            if(ch == ')'){
                depth--;
            }
        }
        return maxDepth;
    }
    public static void main(String[] args) {
        String s = "(1 + (2 * 3) + ((8) / 4) + 1";

        System.out.println(maxDepth(s));
    }
}
