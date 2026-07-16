// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 
// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

// Platform : Leetcode
// Level : Easy

// Approaches:
// 1.BruteForce Approach : Time Complexity : O(N ^ 2), Space Complexity : O(1)
// 2.Optimal(DP) : Time Complexity : O(N), Space Complexity : O(1)

public class Best_TIme_Buy_And_Sell_Stocks {
    public static int bruteMaxProfit(int[] prices){
        int max = 0;

        for(int i = 0;i < prices.length;i++){
            for(int j = i;j < prices.length;j++){
                int profit = prices[j] - prices[i];

                max = Math.max(max,profit);
            }
        }
        return max;
    }
    public static int OptimalMaxProfit(int[] prices){
        int max = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int price : prices){
            if(price < minPrice){
                minPrice = price;
            }

            else{
                max = Math.max(max,price - minPrice);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        
        int[] prices = {7,1,5,3,6};
        // int solution = bruteMaxProfit(prices);
        int solution = OptimalMaxProfit(prices);
        System.out.println(solution);
    }
}
