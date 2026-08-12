// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
// Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

// Example 1:

// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

// Platform : Leetcode
// Level : Hard
// Time Complexity : O(n log(sum(nums))) , Space Complexity : O(1)

public class Split_Array_Larget_Sum {
    private static boolean partitionCount(int[] nums,int maxsum,int k){
        int partition = 1;
        long subarraySum = 0;

        for(int num : nums){
            subarraySum += num;

            if(subarraySum > maxsum){
                partition++;
                subarraySum = num;
            }
        }
        return partition <= k;
    }
    public static int splitArray(int[] nums, int k) {
        int low = 0;
        int sum = 0;

        for(int n : nums){
            low = Math.max(low,n);
            sum += n;
        }

        int high = sum;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(partitionCount(nums,mid,k)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(nums,k));
    }
}
