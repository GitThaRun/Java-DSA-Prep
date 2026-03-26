// Problem Statement:Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
// There may be duplicates in the original array.
// Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.

// Example 1:

// Input: nums = [3,4,5,1,2]
// Output: true
// Explanation: [1,2,3,4,5] is the original sorted array.
// You can rotate the array by x = 2 positions to begin on the element of value 3: [3,4,5,1,2].

// Platform : Leetcode
// Difficulty : Easy
// Time complexity : O(n) space complexity : O(1)

import java.util.Scanner;

public class Sorted_Array_Or_Not {
    public static boolean check(int[] nums) {
        int N = nums.length;
        int breaks = 0;
        for(int i = 0;i < N;i++){
            int next = (i + 1) % N;
            if(nums[i] > nums[next]){
                breaks++;
            }
            if(breaks > 1) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println("Enter " + N + " elements : ");
        int[] nums = new int[N];

        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(check(nums));
        sc.close();
    }
}
