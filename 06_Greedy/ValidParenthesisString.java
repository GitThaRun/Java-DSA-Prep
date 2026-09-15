// Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

// The following rules define a valid string:

// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

// Example 1:
// Input: s = "()"
// Output: true

// Approach - 1 (Recursion):
// Time Complexity : O(3 ^ n), Space Complexity : O(n)

// Approach - 2(Greedy)
// Time Complexity : O(n), Space Complexity : O(1)

public class ValidParenthesisString {

    // Brute Force
    // private static boolean  checkValid(String s,int idx,int count){
    //     if(count < 0) return false;

    //     if(idx == s.length()){
    //         return (count == 0);
    //     }

    //     char c = s.charAt(idx);

    //     if(c == '('){
    //         return checkValid(s, idx + 1, count + 1);
    //     }
    //     if(c == ')'){
    //         return checkValid(s, idx + 1, count - 1);
    //     }
    //     else{
    //         return checkValid(s, idx + 1, count) || 
    //                checkValid(s, idx + 1, count + 1) ||
    //                checkValid(s, idx + 1, count - 1);
    //     }
    // }
    public static boolean checkValidString(String s) {
       int minR = 0, maxR = 0;

       for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                minR += 1;
                maxR += 1;
            }
            else if(s.charAt(i) == ')'){
                minR -= 1;
                maxR -= 1;
            }
            else{
                minR -= 1;
                maxR += 1;
            }
            if(minR < 0) minR = 0;

            if(maxR < 0) return false;
       }
       return (minR == 0);
    }

    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(checkValidString(s));
    }
}
