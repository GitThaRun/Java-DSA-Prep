// Problem Statement : 

// Given a string s, find the length of the longest substring without duplicate characters.

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

// Platform : Leetcode
// Level : Medium
// Approaches : 
// 1)Brute Force Approach : Time Complexity : O(N ^ 2), Space Complexity : O(min(n),charset)
// 2)Optimal(Sliding Window) : Time Complexity : O(N), Space Complexity : 

import java.util.HashSet;
import java.util.Scanner;
public class SubString_Without_Repeating{

    // BruteForce Approach
    public static int bruteSubstring(String s){

        int N = s.length();
        int maxlen = 0;
        for(int i = 0;i < N;i++){
            HashSet<Character> set = new HashSet<>();

            for(int j = 0;j < N;j++){
                char c = s.charAt(j);

                if(set.contains(c)){
                    break;
                }
                set.add(c);
                maxlen = Math.max(maxlen,j - i + 1);
            }
        }
        return maxlen;
    }

    // Optimal Approach
    public static int OptimalSubstring(String S){
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxlen = 0;

        for(int right = 0;right < S.length();right++)
        {
            char c = S.charAt(right);

            while(set.contains(c)){
                set.remove(S.charAt(left));
                left++;
            }
            set.add(c);
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        // System.out.println(bruteSubstring(s));
        System.out.println(OptimalSubstring(s));
        sc.close();
    }
}