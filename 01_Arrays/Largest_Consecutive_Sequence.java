// Problem : Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.
// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

// Platform : Leetcode
// Level : Medium 

// Approaches:
// 1)BruteForce : Time Complexity : O(N ^ 2), Space Complexity : O(1)
// 2)Better : Time Complexity : , Space Complexity : 
// 3)Optimmal : Time Complexity : , Space Complexity : 

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Largest_Consecutive_Sequence {
    
    // BruteForce 
     private static boolean linearSearch(int[] arr, int num){
        int N = arr.length;

        for(int i = 0;i < N;i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }
    public static int bruteConsecutiveSequence(int[] nums){
        
        int length = 1;
        
        if(nums.length == 0){
            return 0;
        }
        for(int i = 0;i < nums.length;i++){
            int x = nums[i];
            int count = 1;
            while(linearSearch(nums, x + 1) == true){
                x += 1;
                count += 1;
            }
            
            length = Math.max(length,count);
        }
        return length;
    }


    // Better 
    public static int betterConsecutiveSequence(int[] nums){
        int N = nums.length;

        int lastSmaller = Integer.MIN_VALUE;
        int count = 1;
        int longest = 1;

        if(N == 0){
            return 0;
        }
        Arrays.sort(nums);

        for(int i = 0;i < N;i++){
            if(nums[i] - 1 == lastSmaller){
                count += 1;

                lastSmaller = nums[i];
            }
            else if(nums[i] != lastSmaller){
                count = 1;

                lastSmaller = nums[i];
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }

    // Optimal

    public static int optimalConsecutiveSequence(int[] nums){

        HashSet<Integer> set = new HashSet<>();

        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;

        for(int i = 0;i < n;i++){
            set.add(nums[i]);
        }

        int length = 1;
        for(int it : set){
            if(!set.contains(it - 1)){
                int count = 1;
                int x = it;

                while(set.contains(x + 1)){
                    x += 1;
                    count += 1;
                }
                length = Math.max(length,count);
            }
        }
        return length;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }

        // System.out.println(bruteConsecutiveSequence(nums));
        // System.out.println(betterConsecutiveSequence(nums));
        System.out.println(optimalConsecutiveSequence(nums));
        sc.close();
    }
}
