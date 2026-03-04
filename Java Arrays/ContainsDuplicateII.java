// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

// Example 1:

// Input: nums = [1,2,3,1], k = 3
// Output: true

// Platform : LeetCode
// Difficulty : Easy
// Approaches : 
// 1) Brute Force : Time Complexity : O(N ^ k), Space Complexity : O(1)
// 2) Optimal Approach(Sliding Window): Time Complexity : O(N), Space Complexity : O(N)

import java.util.HashSet;
import java.util.Scanner;

// Brute Force
public class ContainsDuplicateII {
    public static boolean bruteContainsDuplicate(int arr[],int k){

        int N = arr.length;
        for(int i = 0;i < N;i++){
            for(int j = i + 1;j < N && j <= i + k;j++){

                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    // Optimal Approach
    public static boolean optimalContainsDuplicate(int arr[],int k){
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0;i < arr.length;i++){
            if(set.contains(arr[i])){
                return true;
            }
            else{
                set.add(arr[i]);
            }

            if(i >= k){
                set.remove(arr[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int nums[] = new int[N];
        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        // System.out.println(bruteContainsDuplicate(nums, k));
        System.out.println(optimalContainsDuplicate(nums, k));
        sc.close();
    }
}
