// Problem statement : Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]
 
// Approaches : 
// 1) Brute Force Approach : O(N), Space Complexity : O(N)
// 2) Optimal Approach : Time Complexity : O(N), Space Complexity : O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Move_Zeros_To_End{

    // Brute Force Appraoch
    public static void BruteMoveZeroes(int[] arr){

        ArrayList<Integer> list = new ArrayList<>();
        for(int x : arr){
            if(x != 0){
                list.add(x);
            }
        }
        int idx = 0;
        for(int x : list){
            arr[idx++] = x;
        }
        while(idx < arr.length){
            arr[idx++] = 0;
        }
    }

    // Optimal Appraoch
    public static void MoveZeroes(int[] arr){

        int pos = 0;
        int N = arr.length;
        int i = 0;
        while(i < N){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
                pos++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }
        // BruteMoveZeroes(nums);
        MoveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        sc.close();
    }
}