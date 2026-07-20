// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
// A shift on s consists of moving the leftmost character of s to the rightmost position.
// For example, if s = "abcde", then it will be "bcdea" after one shift.

// Platform : Leetcode
// Level : Easy

// Approaches
// 1.BruteForce : Time Complexity : O(n ^ 2), Space Complexity : O(1)
// 2.Optimal : Time Complexity : O(n), Space Complexity : O(1)

import java.util.Scanner;

public class Check_Rotate_String {
    public static boolean bruteRotate(String s,String goal){
        if(s.length() != goal.length())
            return false;

        for(int i = 0;i < s.length();i++){
            String rotated = s.substring(i) + s.substring(0,i);

            if(rotated.equals(goal)){
                return true;
            }
        }
        return false;
    }

    public static boolean optimalRotate(String s ,String goal){
        if(s.length() != goal.length())
            return false;

        String doubled = s + s;
        return doubled.contains(goal);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "rotation";
        String goal = "tionrota";

        // System.out.println(bruteRotate(s,goal));
        System.out.println(optimalRotate(s, goal));

        sc.close();
    }
}
