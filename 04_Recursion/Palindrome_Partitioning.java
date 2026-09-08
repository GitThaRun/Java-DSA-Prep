// Given a string s partition string s such that every substring of partition is palindrome. Return all possible palindrome partition of string s.

// Example 1

// Input : s = "aabaa"
// Output : [ [ "a", "a", "b", "a", "a"] , [ "a", "a", "b", "aa"] , [ "a", "aba", "a"] , [ "aa", "b", "a", "a"] , [ "aa", "b", "aa" ] , [ "aabaa" ] ]

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n * 2^n),Space Complexity : O(n), excluding output

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    private static void getPartition(int idx,String s,List<List<String>> result,List<String> temp){
        if(idx == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = idx;i < s.length();i++){
        if(isPalindrome(s,idx,i)){
            temp.add(s.substring(idx,i + 1));

            getPartition(i+1,s,result,temp);

            temp.remove(temp.size() - 1);
        
            }
        }
    }

    private static boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public static List<List<String>> partition(String s) {
        //your code goes here
        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        getPartition(0,s,result,ans);

        return result;
    }

    public static void main(String[] args) {
        String s = "aabaa";
        
        List<List<String>> res = partition(s);

        System.out.print("[");
        for(int i = 0;i < res.size();i++){
            System.out.print("[");
            for(int j = 0;j < res.get(i).size();j++){
                System.out.print("\"" + res.get(i).get(j) + "\"");
                if(j != res.get(i).size() - 1){
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if(i != res.size() - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
