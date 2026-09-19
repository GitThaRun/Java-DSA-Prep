// Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

// Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

// Example 1:
// Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
// Output: 1

// Platform : LeetCode
// Level : Medium
// Time Complexity : O(n log n) , Space Complexity : O(1)

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
       Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));

        int count = 1;
        int lastEnd = intervals[0][1];

        for(int i = 1;i < intervals.length;i++){
            if(intervals[i][0] >= lastEnd){
                count++;

                lastEnd = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
