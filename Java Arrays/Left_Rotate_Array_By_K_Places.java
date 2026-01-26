// problem : Given an integer array nums, rotate the array to the left by k steps, where k is non-negative.

// Example 1

// Input: nums = [1, 2, 3, 4, 5, 6], k = 2
// Output: nums = [3, 4, 5, 6, 1, 2]

// Explanation:
// rotate 1 step to the left: [2, 3, 4, 5, 6, 1]
// rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]

//Platform : Strivers SDE Sheet
//Difficulty : Medium
//Approaches : 
// 1) Brute Force -> Time : O(n*k), Space : O(1)
// 2)Optimal Approach -> Time : O(n), Space : O(1)

import java.util.Arrays;
import java.util.Scanner;

public class Left_Rotate_Array_By_K_Places {
    
    // Brute Force Appraoch
    public static void rotateArray(int[] nums,int k){

        int N = nums.length;
        k = k % N;
        for(int i = 0;i < k;i++){
            int temp = nums[0];
            for(int j = 0;j < N - 1;j++){
                nums[j] = nums[j+1];
            }
            nums[N - 1] = temp;
        }
    }

    // Optimal Approach
    public static void leftRotate(int[] nums,int k){
        int N = nums.length;
        k = k % N;
        reverse(nums,0,k-1);
        reverse(nums,k,N - 1);
        reverse(nums,0,N-1);
    }

    public static void reverse(int[] nums,int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter K : ");
        int K = sc.nextInt();

        int N = sc.nextInt();
        int[] nums = new int[N];
        System.out.println("Enter " + N + " Elements : ");
       for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
       } 
    //    rotateArray(nums, K);
    //    System.out.println("Brute Force Approach Result : " +Arrays.toString(nums));
       
       leftRotate(nums, K);
       System.out.println("Optimal Approach Result : " + Arrays.toString(nums));
       sc.close();
    }
}
