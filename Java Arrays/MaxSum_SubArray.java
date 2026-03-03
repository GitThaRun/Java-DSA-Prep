// Problem Statement : Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.

// Note: A subarray is a contiguous part of any given array.

// Examples:

// Input: arr[] = [100, 200, 300, 400], k = 2
// Output: 700
// Explanation: arr2 + arr3 = 700, which is maximum.

// Platform : Geeks For Geeks
// Level : Easy
// Approaches:
// 1)Brute Force : Time Complexity : O(n x k) , Space Complexity : O(1)
// 2)Optimal(Sliding Window) : Time Complexity : O(N), Space Complexity : O(1)

import java.util.Scanner;
public class MaxSum_SubArray{
    
    public static int bruteMaxSum(int arr[],int k){

        int MaxSum = Integer.MIN_VALUE;
        int N = arr.length;
        for(int i = 0;i <= N - k;i++){
             int sum = 0;
            for(int j = i;j < i + k;j++){
                sum += arr[j];
            } 
            MaxSum = Math.max(MaxSum,sum);
        }
        return MaxSum;
    }

    public static int optimalMaxSum(int arr[],int k){
        int N = arr.length;

        int windowSum = 0;
        int maxSum = 0;
        for(int i = 0;i < k;i++){
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for(int i = k;i < N;i++){
            windowSum += arr[i];
            windowSum -= arr[i - k];

            maxSum = Math.max(windowSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int nums[] = new int[N];
        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }
        int K = sc.nextInt();

        // System.out.println(bruteMaxSum(nums, K));
        System.out.println(optimalMaxSum(nums, K));
        sc.close();
    }
}