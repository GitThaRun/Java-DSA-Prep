// There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

// In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

// Your score is the sum of the points of the cards you have taken.

// Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

// Example 1:

// Input: cardPoints = [1,2,3,4,5,6,1], k = 3
// Output: 12
// Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

// Platform : Leetcode
// Level : Medium
// Approach(Sliding window) : Time Complexity : O(n), O(1)

public class Max_Points_From_Cards {
    public static int maxScore(int[] cardPoints,int k){
        int n = cardPoints.length;

        int total = 0;
        for(int i = 0;i < k;i++){
            total += cardPoints[i];
        }
        int maxScore = total;
        for(int i = 0;i < k;i++){
            total -= cardPoints[k - 1 - i];

            total += cardPoints[n - 1 - i];

            maxScore = Math.max(maxScore,total);
        }

        return maxScore;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,1};
        int k = 3;

        System.out.println(maxScore(nums, k));
    }
}
