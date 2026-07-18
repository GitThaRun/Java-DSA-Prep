// Problem Statement: You are given a sorted array arr of distinct values and a target value x. You need to search for the index of the target value in the array.

// Examples
// Example 1:
// Input Format: arr[] = {1,2,4,7}, x = 6
// Result: 3
// Explanation: 6 is not present in the array. So, if we will insert 6 in the 3rd index(0-based indexing), the array will still be sorted. {1,2,4,6,7}.

// Example 2:
// Input Format: arr[] = {1,2,4,7}, x = 2
// Result: 1
// Explanation: 2 is present in the array and so we will return its index i.e. 1.

// Platform : Leetcode
// Level : Easy

// Time Complexity : O(log N), Space Complexity : O(1)

import java.util.Scanner;

public class Search_Insert_Position {
    public static int searchPosition(int[] nums,int x){
        int low = 0, high = nums.length - 1;
        int ans = nums.length;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] >= x){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(searchPosition(arr, x));
        sc.close();
    }
}
