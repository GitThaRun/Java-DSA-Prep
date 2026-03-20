// Problem : Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:

// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:

// Input: nums = [1,2,3], k = 3
// Output: 2

// Platform : Leetcode
// Level : Medium
// Approaches : 
// 1)BruteForce : Time Complexity : O(N ^ 2), Space Complexity : O(1)
// 2)Optimal(Prefix Sum) : Time Complexity : , Space Complexity : 

import java.util.HashMap;
import java.util.Scanner;

public class SubArray_Sum_Equals_K {
    
    // BruteForce
    public static int bruteSubArraySum(int[] arr,int k){
        int N = arr.length;
        int count = 0;

        for(int i = 0;i < N;i++){
            int sum = 0;
            for(int j = i;j < N;j++){
                sum += arr[j];

                if(sum == k){
                count += 1;
            }
            }
        }
        return count;
    }

    // Optimal(Prefix Sum)
    public static int optimalSubArraySum(int[] arr, int k) {

        int n = arr.length;
     HashMap<Integer,Integer> map = new HashMap<>();

     int prefixSum = 0;
     int count = 0;

     map.put(0,1);

     for(int i = 0;i < n;i++){

        prefixSum += arr[i];
        int remove = prefixSum - k;

        if(map.containsKey(remove)){
            count += map.get(remove);
        }

        map.put(prefixSum,map.getOrDefault(prefixSum,0) + 1);
     }   
     return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }
        int K = sc.nextInt();

        // System.out.println(bruteSubArraySum(nums, K));
        System.out.println(optimalSubArraySum(nums, K));
        sc.close();
    }
}
