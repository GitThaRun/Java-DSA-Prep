// You are given an integer array bloomDay, an integer m and an integer k.
// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
// Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

// Example 1:

// Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
// Output: 3
// Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
// We need 3 bouquets each should contain 1 flower.
// After day 1: [x, _, _, _, _]   // we can only make one bouquet.
// After day 2: [x, _, _, _, x]   // we can only make two bouquets.
// After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.

// Platform: LeetCode
// Level: Medium
// Approach: Binary Search
// Time Complexity: O(n log m), where n is the length of the array and m is the maximum value in the array.
// Space Complexity: O(1)

public class Min_Num_Days_To_Make_Boquets {
    private boolean isPossible(int[] nums,int day,int m,int k){
        int count = 0, boquets = 0;

        for(int i : nums){
            if(i <= day){
                count++;

                if(count == k){
                    boquets++;
                    count = 0;
                }
            }
            else{
                count = 0;
            }
        }
        return boquets >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {

        // long required = (long) m * k;
        if((long)m * k > bloomDay.length) return -1;
         
         int min = Integer.MAX_VALUE;
         int max = Integer.MIN_VALUE;

         for(int num : bloomDay){
            min = Math.min(min,num);
            max = Math.max(max,num);
         }

        int low = min, high = max, result = -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(isPossible(bloomDay,mid,m,k)){
                result = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Min_Num_Days_To_Make_Boquets obj = new Min_Num_Days_To_Make_Boquets();
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(obj.minDays(bloomDay, m, k));
    }
}
