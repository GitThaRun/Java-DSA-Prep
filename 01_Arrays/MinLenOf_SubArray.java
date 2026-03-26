// Problem: Minimum Size Subarray Sum

// Given an array of positive integers nums and a positive integer target,
// return the minimal length of a subarray whose sum is greater than or equal
// to the target.

// If there is no such subarray, return 0 instead.

// Example 1:
// Input:
// target = 7
// nums = [2,3,1,2,4,3]

// Output:
// 2

// Explanation:
// The subarray [4,3] has the minimal length under the problem constraint.

// -----------------------------------------------------

// Example 2:
// Input:
// target = 4
// nums = [1,4,4]

// Output:
// 1

// Difficulty: Medium
// Approaches : 
// 1)Brute Force : Time Complexity : O(n^2) , Space Complexity : O(1)
// 2)Optimal(Sliding Window) : Time Complexity : O(N), Space Complexity : O(1)

import java.util.Scanner;
public class MinLenOf_SubArray {
    
    // Brute Force
    public static int bruteMinLen(int arr[],int target){

        int N = arr.length;
        int minLen = Integer.MAX_VALUE;
        for(int i = 0;i < N;i++){
            int sum = 0;
            for(int j = i;j < N;j++){

                sum += arr[j];
                if(sum >= target){
                minLen = Math.min(minLen,j - i + 1);
                break;
                }
            }  
        }
        return minLen == Integer.MAX_VALUE?0 : minLen;
    }

    // Optimal
    public static int optimalMinLen(int arr[],int target){
        int N = arr.length;
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right = 0;right < N;right++){
            sum += arr[right];

            while(sum >= target){
                sum -= arr[left];
                minLen = Math.min(minLen,right - left + 1);
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE?0 : minLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int nums[] = new int[N];
        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        // System.out.println(bruteMinLen(nums, target));
        System.out.println(optimalMinLen(nums, target));
        sc.close();
    }
}
