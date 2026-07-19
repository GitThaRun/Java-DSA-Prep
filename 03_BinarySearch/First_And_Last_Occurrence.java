// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Platform : Leetcode
// Level : Medium

// Approaches:
// 1)BruteForce Approach : Time Complexity : O(n), Space Complexity : O(1)
// 2)Optimal Approach : Time Complexoty : O(log n), Space Complexity : O(1)

import java.util.Scanner;

public class First_And_Last_Occurrence {
    public static int[] bruteSearchChange(int[] nums,int target){
        
        int first = -1, last = -1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == target){
                if(first == -1){
                    first = i;
                }

                last = i;
            }
        }
        return new int[] {first,last};
    }

    public static int[] optimalSearchRange(int[] nums,int target){
        return new int[] {findFirstOccurrence(nums,target),findLastOccurrence(nums,target)};
    }

    public static int findFirstOccurrence(int[] nums,int target){
        int ans = -1;
        int low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                ans = mid;
            }

            if(nums[mid] >= target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int findLastOccurrence(int[] nums,int target){
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                ans = mid;
            }
            if(nums[mid] <= target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        
        // int[] result = bruteSearchChange(arr, target);
        // System.out.println(result[0] + " " + result[1]);

        int[] result = optimalSearchRange(arr, target);
        System.out.println(result[0] + " " + result[1]);
        
        sc.close();
    }
}
