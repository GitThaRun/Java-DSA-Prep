// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(4^n), where n is the length of the input digits
// Space Complexity : O(n), where n is the length of the input digits

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    private static void findCombo(int idx,String digits,StringBuilder temp,List<String> result,String[] map){
        if(idx == digits.length()){
            result.add(temp.toString());

            return;
        }

        String letter = map[digits.charAt(idx) - '0'];

        for(int i = 0;i < letter.length();i++){
            char ch = letter.charAt(i);

            temp.append(ch);

            findCombo(idx + 1,digits,temp,result,map);

            temp.deleteCharAt(temp.length() - 1);
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0) return result;
        String[] map = {
            "","","abc","def",
            "ghi","jkl","mno",
            "pqrs","tuv","wxyz"
        };

        StringBuilder current = new StringBuilder();

        findCombo(0,digits,current,result,map);

        return result;
    }

    public static void main(String[] args) {
        String digits = "23";

        List<String> result = letterCombinations(digits);
        System.out.print("[");
        for(int i = 0;i < result.size();i++){
            System.out.print(result.get(i));

            if(i < result.size() - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
