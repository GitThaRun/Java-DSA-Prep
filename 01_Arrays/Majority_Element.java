// Given an integer array nums of size n, return the majority element of the array.
// The majority element of an array is an element that appears more than n/2 times in the array. The array is guaranteed to have a majority element.

// Example 1
// Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]
// Output: 7

// Explanation:
// The number 7 appears 5 times in the 9 sized array

// Platform : Striver SDE Sheet
// Level : Medium
// Approaches : 
// 1)BruteForce Approach : Time COmpleixty : O(N ^ 2), Space Complexity : O(1)
// 2)Optimal Approach(Moore's Voting Algorithm) : Time Complexity : O(N), Space Complexity : O(1)

import java.util.Scanner;

public class Majority_Element {
    
    // BruteForce Approach
    public static int BruteMajority(int[] nums){

        int N = nums.length;
        for(int i = 0;i < N;i++){
            int count = 0;

            for(int j = 0;j < N;j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count > N / 2){
                return nums[i];
            }
        }

        return -1;
    }

    // Optimal Approach
    public static int OptimalMajority(int[] nums){
        int count = 0;
        int element = 0;
        int N = nums.length;
        for(int i = 0;i < N;i++){

            if(count == 0){
                count = 1;
                element = nums[i];
            }
            else if(nums[i] == element){
                count++;
            }
            else{
                count--;
            }
        }

        int track = 0;
        for(int i : nums){
            if(i == element){
                track++;
            }
        }

        if(track > (N / 2)){
            return element;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0;i < N;i++){
            arr[i] = sc.nextInt();
        }

        // System.out.println(BruteMajority(arr));
        System.out.println(OptimalMajority(arr));
        sc.close();
    }
}
