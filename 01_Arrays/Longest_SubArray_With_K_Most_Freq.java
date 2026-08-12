// You are given an integer array nums and an integer k.
// The frequency of an element x is the number of times it occurs in an array.
// An array is called good if the frequency of each element in this array is less than or equal to k.
// Return the length of the longest good subarray of nums.
// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:

// Input: nums = [1,2,3,1,2,3,1,2], k = 2
// Output: 6
// Explanation: The longest possible good subarray is [1,2,3,1,2,3] since the values 1, 2, and 3 occur at most twice in this subarray. Note that the subarrays [2,3,1,2,3,1] and [3,1,2,3,1,2] are also good.
// It can be shown that there are no good subarrays with length more than 6.

// Platform : Leetcode
// Level : Medium
// Approach : Sliding Window + HashMap
// Time Complexity : O(n) , Space Complexity : O(n)

import java.util.HashMap;

public class Longest_SubArray_With_K_Most_Freq {
     public int maxSubarrayLength(int[] nums, int k) {
        int left = 0, maxlen = 0;

        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int right = 0;right < nums.length;right++){

            freq.put(nums[right],freq.getOrDefault(nums[right],0) + 1);

            while(freq.get(nums[right]) > k){
                freq.put(nums[left],freq.get(nums[left]) - 1);

                left++;
            }
            maxlen = Math.max(maxlen,right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        Longest_SubArray_With_K_Most_Freq obj = new Longest_SubArray_With_K_Most_Freq();
        int[] nums = {1,2,3,1,2,3,1,2};
        int k = 2;
        System.out.println(obj.maxSubarrayLength(nums,k));
    }
}
