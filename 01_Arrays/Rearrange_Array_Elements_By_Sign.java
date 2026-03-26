// Problem Statement : You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

// You should return the array of nums such that the array follows the given conditions:
// Every consecutive pair of integers have opposite signs.
// For all integers with the same sign, the order in which they were present in nums is preserved.
// The rearranged array begins with a positive integer.
// Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

// Input: nums = [3,1,-2,-5,2,-4]
// Output: [3,-2,1,-5,2,-4]

// Platform : LeetCode
// Level : Medium
// Approaches : 
// 1)BruteForce Approach : Time Complexity : O(N), Space Complexity : O(N)
// 2)Optimal Approach : Time Complexity : O(N), Space Complexity : O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Rearrange_Array_Elements_By_Sign {
    
    // BruteForce 
    public static int[] bruteRearrange(int[] arr){

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int N = arr.length;

        for(int i : arr){
            if(i > 0){
                pos.add(i);
            }
            else{
                neg.add(i);
            }
        }

        for(int i = 0;i < N / 2;i++){
            arr[2 * i] = pos.get(i);
            arr[2 * i + 1] = neg.get(i);
        }
        return arr;
    }

    public static int[] optimalRearrange(int[] arr){

        int pos = 0, neg = 1;
        int[] result = new int[arr.length];

        for(int i : arr){
            if(i > 0){
                result[pos] = i;
                pos += 2;

            }
            else{
                result[neg] = i;
                neg += 2;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }

        // System.out.println(Arrays.toString(bruteRearrange(nums)));
        System.out.println(Arrays.toString(optimalRearrange(nums)));
        sc.close();
    }
}
