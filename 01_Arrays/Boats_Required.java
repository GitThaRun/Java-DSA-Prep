// Problem statement : You are given an integer array people where people[i] represents the weight of the i-th person, and an integer limit representing the maximum weight a boat can carry.

// Each boat can carry at most two people at the same time, provided that the sum of their weights is less than or equal to limit.
// Your task is to determine the minimum number of boats required to carry all people safely.

// Input Format

// 1. The first line contains an integer N — the number of people.

// 2. The second line contains N space-separated integers representing the array people.

// 3. The third line contains an integer limit — the maximum weight capacity of a boat.

// Output Format
// · Print a single integer representing the minimum number of boats required.

// Time Complexity(Optimal) : O(N log N) 
// Space Complexity(Optimal) : O(1)

import java.util.Arrays;
import java.util.Scanner;

public class Boats_Required {
    public static int minBoats(int[] people,int limit){

        Arrays.sort(people);
        int i = 0,j = people.length - 1;
        int boats = 0;
        while(i <= j){
            
            if(people[i] + people[j] <= limit){
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] weights = new int[N];
        for(int i = 0;i < N;i++){
            weights[i] = sc.nextInt();
        }
        int limit = sc.nextInt();
        System.out.println(minBoats(weights,limit));

        sc.close();
    }
}
