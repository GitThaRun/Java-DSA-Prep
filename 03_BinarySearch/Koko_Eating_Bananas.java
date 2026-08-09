// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.

// Example 1:

// Input: piles = [3,6,7,11], h = 8
// Output: 4

// Approach : Binary Search On Answers
// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n log2(max(piles))), Space Complexity : O(1)

import java.util.Arrays;

public class Koko_Eating_Bananas {
    private static long CalculateTotalHours(int[] piles,long curr_speed){
            long totalHours = 0;
            for(int b : piles){
                totalHours += (b + (long) curr_speed - 1) / curr_speed;
            }
            return totalHours;
        }

    public static int minEatingSpeed(int[] piles, int h) {
        
        int max = Arrays.stream(piles).max().getAsInt();

        int low = 1,high = max;
        int ans = max;

        while(low <= high){
            int mid = low + (high - low) / 2;
            long totalH = CalculateTotalHours(piles,mid);

            if(totalH <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] piles = {7,15,6,3};
        int h = 8;
        System.out.println(minEatingSpeed(piles,h));
    }
}
