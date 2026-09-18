// There are n children standing in a line.

// Each child is assigned a rating value given in the integer array ratings.

// You are giving candies to these children subjected to the following requirements:

// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// Return the minimum number of candies you need to have to distribute the candies to the children.


// Example 1:

// Input: ratings = [1,0,2]
// Output: 5

// Platform: LeetCode
// Level : Hard
// Approach 1 : Time Complexity: O(2n), Space Complexity: O(n)
// Approach 2 : Time Complexity : O(n) , Space Complexity : O(1) 
public class Candy {
    public static int bruteCandy(int[] ratings){
        int n = ratings.length;
        int[] candies = new int[n];

        for(int i = 0;i < n;i++){
            candies[i] = 1;
        }

        for(int i = 1;i < n;i++){
            if(ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        for(int i = n - 2;i >= 0;i--){
            if(ratings[i] > ratings[i + 1]){
                candies[i] = Math.max(candies[i],candies[i + 1]  + 1);
            }
        }
        int minCandies = 0;
        for(int num : candies){
            minCandies += num;
        }

        return minCandies;
    }
    
    public static int candy(int[] ratings){
        int n = ratings.length;

        int candies = n, i = 1;

        while(i < n){

        if(ratings[i] == ratings[i - 1]){
            i++;
            continue;
        }
        int peak = 0;

        while(i < n && ratings[i] > ratings[i - 1]){
            peak++;
            candies += peak;
            i++;
        }

        int down = 0;

        while(i < n && ratings[i] < ratings[i - 1]){
            down++;
            candies += down;
            i++;
        }

        candies -= Math.min(peak,down);
        }
        return candies;
    }
    public static void main(String[] args) {
        int[] ratings = {1,0,2};

        // System.out.println(bruteCandy(ratings));
        System.out.println(candy(ratings));
    }
}
