// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

// Example 1:

// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
// Example 2:

// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]

//Platform : Leetcode
//Difficulty : Medium
//Approaches : 
// 1) Brute Force -> Time : O(n*k), Space : O(1)
// 2)Optimal Approach -> Time : O(n), Space : O(1)

import java.util.Arrays;
import java.util.Scanner;

public class Right_Rotate_Array {

    // Brute Force Approach
    public static void bruteRotate(int[] nums,int k){
        int N = nums.length;
        k = k % N;
        for(int i = 0;i < k;i++){
            int temp = nums[N - 1];
            for(int j = N -1;j > 0;j--){
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
    //Optimal Approach
    public static void rightRotate(int[] nums, int k) {
        int N = nums.length;
        k = k % N;
        reverse(nums,0,N - k - 1);
        reverse(nums,N - k,N - 1);
        reverse(nums,0,N - 1);
    }
    public static void reverse(int nums[],int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter K : ");
        int k = sc.nextInt();

        int N = sc.nextInt();
        System.out.println("Enter " + N + " Elements : ");

        int[] nums = new int[N];
        for(int i = 0; i < N;i++){
            nums[i] = sc.nextInt();
        }

        // bruteRotate(nums, k);
        // System.out.println("Brute Force Approach Result : "+ Arrays.toString(nums));


        rightRotate(nums, k);
        System.out.println("Optimal Approach Result : " + Arrays.toString(nums));

        sc.close();
    }
}
