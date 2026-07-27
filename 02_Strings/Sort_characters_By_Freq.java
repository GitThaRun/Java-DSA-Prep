// Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

// Return the sorted string. If there are multiple answers, return any of them.

 

// Example 1:

// Input: s = "tree"
// Output: "eert"
// Explanation: 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n), Space Complexity : O(n)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sort_characters_By_Freq {
    public static String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        List<Character>[] bucket = new ArrayList[s.length() + 1];

        for(char ch : map.keySet()){
            int freq = map.get(ch);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(ch);
        }

        StringBuilder ans = new StringBuilder();

        for(int i = bucket.length - 1;i >= 0;i--){
            if(bucket[i] != null){
                for(char ch : bucket[i]){
                    for(int j = 0;j < i;j++){
                        ans.append(ch);
                    }
                }
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}
