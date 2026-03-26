// Given an array nums consisting of only 0, 1, or 2. Sort the array in non-decreasing order.
// The sorting must be done in-place, without making a copy of the original array.

// Example 1

// Input: nums = [1, 0, 2, 1, 0]
// Output: [0, 0, 1, 1, 2]
// Explanation:
// The nums array in sorted order has 2 zeroes, 2 ones and 1 two

// Platform : Strivers SDE Sheet
// Level : Medium 
// Approaches:
// 1)Brute Force Approach : Time Complexity : O(n log n), Time Complexity : O(1)
// 2)Better Approach : Time Complexity : O(N), Time Complexity : O(1)
// 3)Optimal Approach(Dutch National FLag) : Time Complexity : O(N), Space Complexity : O(1)

import java.util.Arrays;
import java.util.Scanner;
public class Sort_Arrayof_0s1s2s {

    // BruteForce Approach
    public static void BruteSortArray(int[] arr){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Better Approach
    public static void BetterSortArray(int[] arr){
        int countZ = 0, countO = 0, countT = 0;

        for(int i : arr){
            if(i == 0){
                countZ++;
            }
            else if(i == 1){
                countO++;
            }
            else{
                countT++;
            }
        }

        for(int i = 0;i < countZ;i++){
            arr[i] = 0;
        }
        for(int i = countZ;i < countZ + countO;i++){
            arr[i] = 1;
        }
        for(int i = countZ + countO;i < arr.length;i++){
            arr[i] = 2;
        }
    }

    // Optimal Approach

    public static void OptimalSortArray(int[] arr){

        int low = 0, mid = 0, high = arr.length - 1;

        while(mid <= high){

            if(arr[mid] == 0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }

            else if(arr[mid] == 1){
                mid++;
            }
            else{
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }

        // BruteSortArray(nums);
        // BetterSortArray(nums);
        // System.out.println(Arrays.toString(nums));

        OptimalSortArray(nums);
        System.out.println(Arrays.toString(nums));
        sc.close();
    }

}
