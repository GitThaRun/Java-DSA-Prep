// Problem statement : Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Platform : Leetcode
// Approaches : 
// 1) Optimal Approach : Time Complexity : O(N), Space Complexity : O(N)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> list = new HashMap<>();

        for(int i = 0;i < nums.length;i++){
            int complement = target - nums[i];

            if(list.containsKey(complement)){
                return new int[]{
                    list.get(complement),i
                };
            }
            list.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int target = sc.nextInt();

        int[] nums = new int[N];
        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(twoSum(nums,target)));
        sc.close();
    }
}
