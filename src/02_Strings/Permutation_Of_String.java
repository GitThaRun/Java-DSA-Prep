//Problem : Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//In other words, return true if one of s1's permutations is the substring of s2.

//Example 1:
//
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").

//Platform : Leetcode
//Level : Medium
//Approaches :
//1)Brute Force Approach : Time Complexity : O(N * K), Space Complexity : O(1)
//2)Optimal Approach : Time Complexirty : O(N), Space Complexity : O(1)

import java.util.Scanner;
import java.util.Arrays;
public class Permutation_Of_String {
//    BruteForce
    public static boolean brutePermutation(String s1,String s2){
        if(s1.length() > s2.length()){
            return false;
        }

        int k = s1.length();
        int[] freq = new int[26];
        for(char c : s1.toCharArray()){
            freq[c - 'a']++;
        }

        for(int i = 0;i <= s2.length() - k;i++){
            int[] temp[] = new int[26];
            for(int j = i;j < i + k;j++){
                temp[s2.charAt(j) - 'a']++;
            }
            if(Arrays.equals(temp,freq)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(brutePermutation(s1,s2));
        sc.close();
    }
}