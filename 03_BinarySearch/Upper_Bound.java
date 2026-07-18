// The upper bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than the given key i.e. x.

// The upper bound is the smallest index, ind, where arr[ind] > x.

// Examples
// Example 1:
// Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
// Result: 3
// Explanation: Index 3 is the smallest index such that arr[3] > x.

// Example 2:
// Input Format: N = 6, arr[] = {3,5,8,9,15,19}, x = 9
// Result: 4
// Explanation: Index 4 is the smallest index such that arr[4] > x.

// Platform : Striver's sheet
// Level : Easy

// Approches
// 1)BruteForce Approach : Time Complexity : O(N), Space Complexity : O(1)
// 2)Optimal Approach : Time Complexity : O(log N), Space Complexity : O(1)

import java.util.Scanner;

public class Upper_Bound {
    public static int bruteUpperBound(int[] nums, int x){
        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(nums[i] > x){
                return i;
            }
        }
        return n;
    }
    
    public static int optimalUpperBound(int[] nums,int x){
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] > x){
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
        // System.out.println(bruteUpperBound(arr, x));
        System.out.println(optimalUpperBound(arr, x));
        sc.close();
    }
}
