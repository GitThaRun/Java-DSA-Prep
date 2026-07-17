// Given an input string s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
// Return a string of the words in reverse order concatenated by a single space.
// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

// Example 1:
// Input: s = "the sky is blue"
// Output: "blue is sky the"

// Platform : LeetCode
// Level : Medium

// Approaches:
// 1)BruteForce Approach : Time Complexity : O(N), Space Complexity : O(N)
// 2)Optimal Approach : Time Complexity : O(N), Space Complexity : O(1)
import java.util.*;
public class Reverse_words {
    public static String bruteReverseWords(String s){
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for(int i = 0;i < s.length();i++){

            if(s.charAt(i) != ' '){
                word.append(s.charAt(i));
            }

            else if(word.length() > 0){
                words.add(word.toString());
                word.setLength(0);
            }
        }
        if(word.length() > 0){
                words.add(word.toString());
            }
        
        Collections.reverse(words);

        return String.join(" ",words);
    }

    public static String optimalReverseWords(String s){
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while(i >= 0){
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }

            if(i < 0){
                break;
            }

            int end = i;
            while(i >= 0 && s.charAt(i) != ' '){
                i--;
            }

            String word = s.substring(i + 1,end + 1);

            if(result.length() > 0){
                result.append(" ");
            }

            result.append(word);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String str = "Amazing Coding  SKills";
        // String res = bruteReverseWords(str);
        String res = optimalReverseWords(str);
        System.out.print(res);
    }
}
