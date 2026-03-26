// Given an integer array nums, find a subarray that has the largest product, and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer.

// Note that the product of an array with a single element is the value of that element.

// Example 1:

// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Platform : Leetcode
// Level : Medium
// Approaches : 
// 1)BruteForce Approach : Time Complexity : O(N ^ 2), Space Complexity : O(1)
// 2)Optimal Approach : TIme Complexity : O(N), Space Complexity : O(1)

import java.util.Scanner;

public class Maximum_Product_SubArray {
    
    // BruteForce Approach
    public static int bruteMaxProduct(int[] arr){

        int result = arr[0];

        for(int i = 0;i < arr.length;i++){
            int product = 1;
            for(int j = i;j < arr.length;j++){
                product *= arr[j];

                result = Math.max(result,product);
            }
        }
        return result;
    }

    // Optimal Approach
    public static int optimalMaxProduct(int[] arr){

        int max = arr[0];
        int min = arr[0];
        int result = arr[0];

        for(int i = 1;i < arr.length;i++){
            int curr = arr[i];

            if(curr < 0){
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(curr,curr * max);
            min = Math.min(curr,curr * min);

            result = Math.max(result,max);
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

        // System.out.println(bruteMaxProduct(nums));
        System.out.println(optimalMaxProduct(nums));
        sc.close();
    }
}
