// Problem : Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

// Example 1:

// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".

// Platform : LeetCode
// Level : Medium

// Approaches: 
// 1)BruteForce Approach : Time Complexity : O(N * K), Space Complexity : O(K)
// 2)Optimal Approach : Time Complexity : O(N), Space Complexity : O(1)
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Find_All_Anagrams {
//    BruteForce
    public static List<Integer> bruteAllAnagrams(String s,String p){
        ArrayList<Integer> result = new ArrayList<>();

        int k = p.length();

        for(int i = 0; i <= s.length() - k; i++){
          String sub = s.substring(i,i + k);
          
          if(isAnagram(p,sub)){
            result.add(i);
          }
        }
        return result;
    }
    private static boolean isAnagram(String s1,String s2){
        int[] freq = new int[26];

        for(char c : s1.toCharArray()){
            freq[c - 'a']++;
        }
        for(char c : s2.toCharArray()){
            freq[c - 'a']--;
        }
        for(int val : freq){
            if(val != 0){
                return false;
            }
        }
        return true;
    }

//    Optimal
    public static List<Integer> optimalAllAnagrams(String s,String p){

        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length()){
            return result;
        }
        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        for(char c : p.toCharArray()){
            pCount[c - 'a']++;
        }
        int k = p.length();
        for(int i = 0;i < k;i++){
            windowCount[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(pCount,windowCount)){
            result.add(0);
        }

        for(int i = k;i < s.length();i++){
            windowCount[s.charAt(i) - 'a']++;
            windowCount[s.charAt(i - k) - 'a']--;

            if(Arrays.equals(pCount,windowCount)){
                result.add(i - k + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String p = sc.next();

//        System.out.println(bruteAllAnagrams(s, p));
        System.out.println(optimalAllAnagrams(s, p));
        sc.close();
    }
}
