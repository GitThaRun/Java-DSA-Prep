// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

// Platform : Leetcode
// Level : Medium
// Approaches:
// 1)Brute : Time Complexity : O(N ^ 2), Space Complexity : O(N)
// 2)Optimal : 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Overlapping_Intervals {
    public static int[][] bruteOverlap(int[][] nums){
        int n = nums.length;

        boolean[] merged = new boolean[n];
        List<int[]> result = new ArrayList<>();

        for(int i = 0;i < n;i++){
            if(merged[i]) continue;

            int start = nums[i][0];
            int end = nums[i][1];

            for(int j = i + 1;j < n;j++){
                if(merged[j]){
                    continue;
                }

                if(nums[j][0] <= end && nums[j][1] >= start){
                    start = Math.min(start,nums[j][0]);
                    end = Math.max(end,nums[j][1]);

                    merged[j] = true;
                }
            }
            result.add(new int[]{start,end});
        }
        return result.toArray(new int[result.size()][]);
    }

    // Optimal
    public static int[][] optimalOverlap(int[][] intervals){
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1;i < n;i++){

            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if(nextStart <= end){
                start = Math.min(start,nextStart);
                end = Math.max(end,nextEnd);
            }
            else{
                result.add(new int[]{start,end});

                start = nextStart;
                end = nextEnd;
            }
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        // int[][] ans = bruteOverlap(intervals);
        int[][] ans = optimalOverlap(intervals);

        for(int[] interval : ans){
            System.out.print(Arrays.toString(interval) + " ");
        }
    }
}
