// Given a string s and an integer k.Find the length of the longest substring with at most k distinct characters.

// Example 1
// Input : s = "aababbcaacc" , k = 2
// Output : 6
// Explanation : The longest substring with at most two distinct characters is "aababb".
// The length of the string 6.

// Platform : Striver SDE Sheet
// Level : Medium
// Time Complexity : O(n), Space Complexity : O(k)

import java.util.HashMap;

public class Longest_SubString_With_K_Distinct {
    public static int kDistinctChar(String s, int k) {
        int left = 0, ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for(int right = 0;right < s.length();right++){

            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0) + 1);

            while(map.size() > k){

                map.put(s.charAt(left),map.get(s.charAt(left)) - 1);

                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                 left++;
            }
            ans = Math.max(ans,right - left + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "aababbcaacc";
        int k = 2;
        System.out.println(kDistinctChar(s,k)); 
    }
}
