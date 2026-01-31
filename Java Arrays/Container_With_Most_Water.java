// Problem statement : You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.

// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

// Platform : Leetcode
// Level : Medium
// Approaches : 
// 1.Brute Force : Time Complexity : O(N^2), Space Complexity : O(1)
// 2.Optimal Approach(Two Pointers) : Time Complexity : O(N),Space Complexity : O(1)

import java.util.Scanner;
public class Container_With_Most_Water {
     // Brute Approach
    public static int bruteMaxArea(int[] height){

        int N = height.length;
        int maxStorage = Integer.MIN_VALUE;

        for(int left = 0;left < N;left++){
            for(int right = left + 1;right < N;right++){
                int small = Math.min(height[left],height[right]);

                int currentStorage = small * (right - left);
                maxStorage = Math.max(maxStorage,currentStorage);
            }
        }
        return maxStorage;
    }
    // Optimal Appraoch
    public static int getMaxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxStorage = Integer.MIN_VALUE;

        while(start < end){
            int minWall = Math.min(height[start],height[end]);
            int currentStorage = minWall * (end - start);
            maxStorage = Math.max(maxStorage,currentStorage);

            if(height[start] < height[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return maxStorage;
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] height = new int[N];
        for(int i = 0;i < N;i++){
            height[i] = sc.nextInt();
        }
        // System.out.println(bruteMaxArea(height));
        System.out.println(getMaxArea(height));
        sc.close();
    }
}
