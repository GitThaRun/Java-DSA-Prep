// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

// Return the integer as the final result.

// Example 1:

// Input: s = "42"
// Output: 42

// Explanation:
// The underlined characters are what is read in and the caret is the current reader position.
// Step 1: "42" (no characters read because there is no leading whitespace)
//          ^
// Step 2: "42" (no characters read because there is neither a '-' nor '+')
//          ^
// Step 3: "42" ("42" is read in)

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n), Space Complexity : O(1)

public class String_To_Int {
    public static int myAtoi(String s){
        int i = 0;
        int n = s.length();
        int sign = 1;
        long num = 0;

        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i) == '-')?-1 : 1;
            i++;
        }

        while(i < n && s.charAt(i) == '0'){
            i++;
        }

        while(i < n && Character.isDigit(s.charAt(i))){

            int digit = s.charAt(i) - '0';

            if(num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 &&
            digit > (sign == 1 ? 7 : 8))){

                return (sign == 1)?Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return (int)(sign * num);
    }
    public static void main(String[] args) {
        String s = "words and 987";
        System.out.println(myAtoi(s));
    }
}
