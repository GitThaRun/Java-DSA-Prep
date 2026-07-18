// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"

// Platform : Leetcode
// Level : Easy

// Approach
// 1.Optimal Approach: Time complexity : O(n * log n + m), Space Complexity : O(m)
import java.util.*;
public class Longest_Common_prefix {
    public static String longestCommonPrefix(String[] str){
        StringBuilder res = new StringBuilder();

        Arrays.sort(str);
        String start = str[0];
        String end = str[str.length - 1];

        for(int i = 0;i < Math.min(start.length(),end.length());i++){
            if(start.charAt(i) != end.charAt(i)){
                return res.toString();
            }

            res.append(start.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] str = {"flower","flight","flow"};
        String result = longestCommonPrefix(str);

        System.out.println(result);
    }
}
