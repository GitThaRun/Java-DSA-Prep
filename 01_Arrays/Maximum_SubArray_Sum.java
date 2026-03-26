// Given an integer array nums, find the subarray with the largest sum, and return its sum.

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

// Platform : Leetcode
// Level : Medium

// Approches: 
// 1)BruteForce Approach : Time Complexity : O(N ^ 2), Space Complexity : O(1)
// 2)Optimal Approach(Kadane's Algorithm) : Time Complexity : O(N), Space Complexity : O(1)

import java.util.Scanner;

public class Maximum_SubArray_Sum{

    // BruteForce Approach
    public static int bruteMaxSubArray(int[] arr){

        int N = arr.length;
        int max = Integer.MIN_VALUE;

        for(int i = 0;i < N;i++){
            int sum = 0;
            for(int j = i;j < N;j++){
                sum += arr[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }
    // Optimal Approach
    public static int optimalMaxSubarray(int[] arr){

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0;i < arr.length;i++){
            
            sum += arr[i];

            if(sum > max){
                max = sum;
            }

            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }

        // System.out.println(bruteMaxSubArray(nums));
        System.out.println(optimalMaxSubarray(nums));
        sc.close();
    }
}