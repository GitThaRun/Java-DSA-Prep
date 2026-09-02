// Problem Statement: Given an integer n, return all binary strings of length n that do not contain consecutive 1s. Return the result in lexicographically increasing order.
// A binary string is a string consisting only of characters '0' and '1'.

// Examples
// Example 1:
// Input:
//  n = 3  
// Output:
//  ["000", "001", "010", "100", "101"]  

//  Platform : Striver SDE Sheet
//  Level : Medium
//  Time Complexity : O(n * 2^n), where n is the length of the binary string
//  Space Complexity : O(n * 2^n), in the worst case, we can have 2^n binary strings of length n, and each string can take up to O(n) space to store. Therefore, the overall space complexity is O(n * 2^n).

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryStrings {

    private static void generateStrings(int n,StringBuilder curr,List<String> result){
        if(curr.length() == n){
            result.add(curr.toString());
            return;
        }
        curr.append(0);
        generateStrings(n, curr, result);
        curr.deleteCharAt(curr.length() - 1);

        if(curr.length() == 0 || curr.charAt(curr.length() - 1) != '1'){
            curr.append(1);
            generateStrings(n, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public static List<String> binaryStrings(int n){
        List<String> result = new ArrayList<>();
        
        generateStrings(n,new StringBuilder(),result);

        return result;
    }
    public static void main(String[] args) {
        int n = 3;
        List<String> result = binaryStrings(n);
        System.out.println(result);
    }
}
