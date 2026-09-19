// A software engineer is tasked with using the shortest job first (SJF) policy to calculate the average waiting time for each process. The shortest job first also known as shortest job next (SJN) scheduling policy selects the waiting process with the least execution time to run next.

// You are given an array of integers bt of size n representing the burst times (execution times) of n processes.

// Your task is to calculate the average waiting time for all processes when scheduled using the SJF policy. The waiting time of a process is the total time a process has to wait before its execution starts, which is the sum of burst times of all previously executed processes.

// Return the floor of the average waiting time, i.e., the largest whole number less than or equal to the actual average.

// Example 1

// Input : bt = [4, 1, 3, 7, 2]
// Output : 4

// Platform : SDE Sheet
// Level : Medium
// Time Complexity : O(n log n), Space Complexity : O(1)

import java.util.Arrays;

public class ShortestJobFirst {
    public static long solve(int[] bt) {
       
        int n = bt.length;
        Arrays.sort(bt);

        int time = 0, waitingTime = 0;

        for(int i = 0;i < n;i++){

            waitingTime += time;
            time += bt[i];

        }
        return waitingTime / n;
    }
    public static void main(String[] args) {
        int[] bt = {4,1,3,7,2};

        System.out.println("Average Waiting Time : " + solve(bt));
    }
}
