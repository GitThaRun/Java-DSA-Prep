// Problem: Longest Subarray with Sum K

// Given an array of integers nums and an integer k, return the length of the 
// longest subarray whose sum is equal to k.

// A subarray is a contiguous part of an array.

// You may assume that all elements in the array are non-negative integers.

// Example 1:
// Input: nums = [10,5,2,7,1,9], k = 15
// Output: 4
// Explanation: The longest subarray with sum equal to 15 is [5,2,7,1].
// Length = 4.

// Difficulty : Easy
// Approaches : 
// 1) Brute Force : Time Complexity : O(N ^ 2), Space Complexity : O(1)
// 2)Optimal(Sliding Window) : Time Complexity : O(N), Space Complexity : O(1)
import java.util.Scanner;
public class MaxLenOf_Subarray {

    // Brute Force
    public static int bruteMaxLen(int arr[],int target){

        int N = arr.length;
        int maxlen = 0;
        for(int i = 0;i < N;i++){
            int sum = 0;
            for(int j = i;j < N;j++){
                sum += arr[j];

                if(sum == target){
                    maxlen = Math.max(maxlen, j - i + 1);
                }
            }
        }
        return maxlen;
    }
    
    // Optimal Approach
    public static int optimalMaxlen(int arr[],int target){
        int left = 0;
        int maxlen = 0;
        int sum = 0;

        for(int right = 0;right < arr.length;right++){
            sum += arr[right];

            while(sum > target){
                sum -= arr[left];
                left++;

            }

            if(sum == target){
                maxlen = Math.max(maxlen,right - left + 1);
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int nums[] = new int[N];

        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        // System.out.println(bruteMaxLen(nums, target));
        System.out.println(optimalMaxlen(nums, target));
        sc.close();
    }
}
