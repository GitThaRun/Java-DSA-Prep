// Given one meeting room and N meetings represented by two arrays, start and end, where start[i] represents the start time of the ith meeting and end[i] represents the end time of the ith meeting, determine the maximum number of meetings that can be accommodated in the meeting room if only one meeting can be held at a time. A meeting starting at the same time another meeting ends is considered overlapping.

// Example 1

// Input : Start = [1, 3, 0, 5, 8, 5] , End = [2, 4, 6, 7, 9, 9]
// Output : 4

// Platform : SDE Sheet
// Level : Medium
// Time Complexity : O(n) + O(n log n) + O(n) = O(n log n) ,Space Complexity : O(n)
// For Extended Approach : Time : O(n log n), Space : O(n) + O(n)= O(n)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NMeetingsInOneRoom {
    public static int maxMeetings(int[] start,int[] end){
        int n = start.length;
        List<int[]> meetings = new ArrayList<>();

        for(int i = 0;i < n;i++){
            meetings.add(new int[]{end[i],start[i],i+1});
        }
        meetings.sort(Comparator.comparingInt(a -> a[0]));

        int lastEnd = -1, count = 0;

        for(int[] m : meetings){
            if(m[1] > lastEnd){
                count++;
                lastEnd = m[0];
            }
        }
        return count;
    }

    // Extended version, Return meeting order
    public static List<Integer> maxMeetingsOrder(int[] start,int[] end){
        int n = start.length;
        List<int[]> meetings = new ArrayList<>();

        for(int i = 0;i < n;i++){
            meetings.add(new int[]{end[i],start[i],i+1});
        }
        meetings.sort(Comparator.comparingInt(a -> a[0]));

        int lastEnd = -1;
        List<Integer> order = new ArrayList<>();

        for(int[] m : meetings){
            if(m[1] > lastEnd){
                order.add(m[2]);
                lastEnd = m[0];
            }
        }
        return order;
    }
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,5,7,9,9};

        System.out.println(maxMeetings(start, end));
        System.out.println(maxMeetingsOrder(start, end));
    }
}
