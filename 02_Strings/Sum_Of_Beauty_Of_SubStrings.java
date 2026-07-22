// The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

// For example, the beauty of "abaacc" is 3 - 1 = 2.
// Given a string s, return the sum of beauty of all of its substrings.

// Example 1:

// Input: s = "aabcb"
// Output: 5
// Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1
// Platform : Leetcode
// Level : Medium

// Approaches
// 1)Better : Time Complexity : O(n ^ 2 * k), Space Complexity : O(k)
// 2)Optimal : Time Complexity : O(n ^ 2), Space Complexity : O(1)

import java.util.HashMap;
import java.util.Scanner;

public class Sum_Of_Beauty_Of_SubStrings {
    public static int betterBeautySum(String s){
        int sum = 0;
        for(int i = 0;i < s.length();i++){
            HashMap<Character,Integer> freq = new HashMap<>();
            for(int j = i;j < s.length();j++){
                freq.put(s.charAt(j),freq.getOrDefault(s.charAt(j), 0) + 1);

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for(int val : freq.values()){
                    min = Math.min(min,val);
                    max = Math.max(max,val);
                }
                sum += (max - min);
            }
        }
        return sum;
    }

    public static int optimalBeautySum(String s){
        int n = s.length();
        int sum = 0;

        for(int i = 0;i < n;i++){
            int[] freq = new int[26];

            for(int j = i;j < n;j++){
                freq[s.charAt(j) - 'a']++;

                int min = Integer.MAX_VALUE;
                int max = 0;

                for(int val : freq){
                if(val > 0){
                    min = Math.min(min,val);
                    max = Math.max(max,val);
                }
            }
            sum += (max - min);
            }
        }
            return sum;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        // System.out.println(betterBeautySum(s));
        System.out.println(optimalBeautySum(s));
        sc.close();
    }
}
