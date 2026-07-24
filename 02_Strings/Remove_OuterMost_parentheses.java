// A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
// For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
// A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

// Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

// Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

// Example 1:

// Input: s = "(()())(())"
// Output: "()()()"
// Explanation: 
// The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
// After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

// Platform : Leetcode
// Level : Easy
// Approach : Time Complexity : O(n), Space Complexity : O(1)

import java.util.Scanner;

public class Remove_OuterMost_parentheses {
    public static String removeParentheses(String s){
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(depth > 0) result.append(ch);
                depth++;
            }
            else if(ch == ')'){
                depth--;
                if(depth > 0) result.append(ch);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(removeParentheses(s));
        sc.close();
    }
}
