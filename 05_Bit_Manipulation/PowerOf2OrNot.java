// Given an integer n, return true if it is a power of two. Otherwise, return false.

// An integer n is a power of two, if there exists an integer x such that n == 2x.

// platform : Leetcode
// Level : Easy
// Time Complexity : O(1), Space Complexity : O(1)

public class PowerOf2OrNot {
    public static boolean isPowerOfTwo(int num){
        return num > 0 && (num & (num - 1)) == 0;
    }
    public static void main(String[] args) {
        int x = 32;
        System.out.println(isPowerOfTwo(x));
    }
}
