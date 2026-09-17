// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

// Two intervals are considered overlapping if they share at least one point.

// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Return intervals after the insertion.
// Note that you don't need to modify intervals in-place. You can make a new array and return it.

// Example 1:

// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]

// Platform: LeetCode
// Level: Medium
// Time Complexity: O(n), Space Complexity: O(n)

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newIntervals){
        int i = 0;
        int n = intervals.length;

        List<int[]> result = new ArrayList<>();

        while(i < n && intervals[i][1] < newIntervals[0]){
            result.add(intervals[i]);
            i++;
        }
        while(i < n && intervals[i][0] <= newIntervals[1]){
            newIntervals[0] = Math.min(newIntervals[0],intervals[i][0]);

            newIntervals[1] = Math.max(newIntervals[1], intervals[i][1]);

            i++;
        }
        result.add(newIntervals);

        while(i < n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    } 
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newIntervals = {2,5};

        int[][] result = insert(intervals,newIntervals);
        for (int[] result1 : result) {
            System.out.print("[" + result1[0] + "," + result1[1] + "] ");
        }
    }
}
