// A bit flip of a number x is choosing a bit in the binary representation of x and flipping it from either 0 to 1 or 1 to 0.
// Given two integers start and goal, return the minimum number of bit flips to convert start to goal.

// Example 1:

// Input: start = 10, goal = 7
// Output: 3

// Platform : Leetcode
// Level : Easy
// Time Complexity : O(1), because we process a fixed 31 bits.
// Space Complexity : O(1)
public class MinBitFlips {
    public static int minBitFlips(int start,int goal){
        int num = start ^ goal;

        int count = 0;
        for(int i = 0;i < 32;i++){
            count += (num & 1);

            num = num >> 1;
        }
        return count;
    }
    public static void main(String[] args) {
        int start = 10, goal = 7;

        System.out.println(minBitFlips(start, goal));
    }
}
