
import java.util.Stack;

// You are given a string s.

// Your task is to remove all digits by doing this operation repeatedly:

// Delete the first digit and the closest non-digit character to its left.
// Return the resulting string after removing all digits.

// Note that the operation cannot be performed on a digit that does not have any non-digit character to its left.

// Platform : Leetcode
// Level : Easy
// Time Complexity : O(n), Space Complexity : O(n)

public class ClearDigits {
    public static String clearDigits(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(char ch : st){
            ans.append(ch);
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String s = "cb34";

        String res = clearDigits(s);

        System.out.println(res);
    }
}
