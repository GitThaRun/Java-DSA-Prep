// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Example 1
// Input : s = "anagram" , t = "nagaram"
// Output : true

// Platform : Leetcode
// Level : Easy

// Approches:
// 1)BruteForce : Time complexity : O(N log N), Space Complexity : O(1)
// 2)Optimal : Time Complexity : O(N), Space Complexity : O(1)
import java.util.*;
public class Check_Anagram_Or_Not {
    public static boolean bruteValidAnagram(String s1,String s2){

        if(s1.length() != s2.length()){
            return false;
        }

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        for(int i = 0;i < s1.length();i++){
            if(charArray1[i] != charArray2[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean OptimalValidAnagram(String s1,String s2){

        if(s1.length() != s2.length()){
            return false;
        }

        int[] freq = new int[26];

        for(int i = 0;i < s1.length();i++){
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for(int f : freq){
            if(f != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "cat";
        String s2 = "tac";

        // System.out.println(bruteValidAnagram(s1, s2));
        System.out.println(OptimalValidAnagram(s1, s2));
    }
}
