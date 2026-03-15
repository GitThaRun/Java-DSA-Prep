// Given an array arr[] of positive integers and an integer k. You have to find the maximum value for each contiguous subarray of size k. Return an array of maximum values corresponding to each contiguous subarray.

// Examples:

// Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
// Output: [3, 3, 4, 5, 5, 5, 6]
// Explanation: 
// 1st contiguous subarray [1, 2, 3], max = 3
// 2nd contiguous subarray [2, 3, 1], max = 3
// 3rd contiguous subarray [3, 1, 4], max = 4
// 4th contiguous subarray [1, 4, 5], max = 5
// 5th contiguous subarray [4, 5, 2], max = 5
// 6th contiguous subarray [5, 2, 3], max = 5
// 7th contiguous subarray [2, 3, 6], max = 6

// Platform : Geeks For Geeks
// Level : Medium

// Approaches :
// 1)Brute Force Approach : Time Complexity : O(N * K), Space Complexity : O(1)
// 2)Optimal Approach : Time Complexity : O(N), Space Complexity : O(K)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class K_Sized_SubArray_Max {
    
    // Brute Force

    public static ArrayList<Integer> bruteMaxOfSubArray(int[] arr,int k){
         
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i <= arr.length - k;i++){
            int max = Integer.MIN_VALUE;
            for(int j = i;j < i + k;j++){
                if(arr[j] > max){
                    max = arr[j];
                }
            }
            result.add(max);
        }
        return result;
    }

    // Optimal Approach
    public static ArrayList<Integer> optimalMaxOfSubarray(int[] arr,int k){
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deq = new ArrayDeque<>();
        
        int N = arr.length;
        
        for(int i = 0;i < N;i++){
            
            if(!deq.isEmpty() && deq.peekFirst() <= i - k){
                deq.pollFirst();
            }
            
            while(!deq.isEmpty() && arr[deq.peekLast()] < arr[i]){
                deq.pollLast();
            }
            
            deq.offerLast(i);
            
            if(i >= k - 1){
                result.add(arr[deq.peekFirst()]);
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
        int K = sc.nextInt();

        // System.out.println(bruteMaxOfSubArray(nums, K));
        System.out.println(optimalMaxOfSubarray(nums, K));
        sc.close();
    }
}
