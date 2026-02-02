// Problem Statement : Given a binary array nums, return the maximum number of consecutive 1s in the array.
// A binary array is an array that contains only 0s and 1s.

// Example 1
// Input: nums = [1, 1, 0, 0, 1, 1, 1, 0]
// Output: 3

// Explanation:
// The maximum consecutive 1s are present from index 4 to index 6, amounting to 3 1s

// Platform : Stiver
// Level : Easy
// Time Complexity : O(N), Space COmplexity : O(1)

import java.util.Scanner;

public class Consecutive_Ones{
    public static int countOnes(int[] nums){

        int maxCount = 0;
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 1) {
              count++;
              maxCount = Math.max(maxCount,count);
            }
            else{
                count = 0;
            }
        }
        return maxCount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }

        System.out.println(countOnes(nums));
        sc.close();
    }
}