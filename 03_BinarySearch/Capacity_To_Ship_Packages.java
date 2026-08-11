// A conveyor belt has packages that must be shipped from one port to another within days days.
// The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
// Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

// Example 1:

// Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
// Output: 15
// Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
// 1st day: 1, 2, 3, 4, 5
// 2nd day: 6, 7
// 3rd day: 8
// 4th day: 9
// 5th day: 10

// Platform : Leetcode
// Level : Medium
// Approach : Time Complexity : O(n log(sum(weights))) , Space Complexity : O(1)

public class Capacity_To_Ship_Packages {
    private static boolean isPossible(int[] weights,int capacity,int limit){
        int days = 1, load = 0;

        for(int w : weights){
            load += w;

            if(load > capacity){
                days++;
                load = w;
            }
        }
        if(days <= limit){
            return true;
        }
        return false;
    }
    public static int shipWithinDays(int[] weights, int days) {
        
        int low = 0;
        int sum = 0;

        for(int w : weights){
            low = Math.max(low,w);
            sum += w;
        }

        int high = sum;
        int result = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(isPossible(weights,mid,days)){
                high = mid - 1;
                result = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
}
