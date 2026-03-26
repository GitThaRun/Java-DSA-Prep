// Problem statement : An election is conducted in a town with N people.

// Each person casts a vote for a candidate, but only votes from people aged 18 years and above are considered valid.
// You are given:
// · An array vote[] where vote[i] represents the candidate number voted by the i-th person.
// · An array age[] where age[i] represents the age of the i-th voter.
// Your task is to determine which candidate wins after considering only valid votes (age ≥ 18).
// Winning Rules
// · The candidate with the maximum number of valid votes wins.
// · If no valid votes exist, or
// · If there is a tie between two or more candidates,
// print -1.

// Output Format

// · Print the candidate number who received the maximum votes from voters aged 18 and above.
// · Print -1 if there is a tie or no valid votes.

// Approaches:
// Brute Force Approach : Time Complexity: O(N^2), Space Complexity: O(1)
// Optimal Appraoch : Time Complexity : O(N), Space Complexity : O(N)

import java.util.HashMap;
import java.util.Scanner;

public class Valid_votes {
    
    // Brute Approach
    public static int bruteFindWinner(int[] votes, int[] age){
     
        int N = votes.length;
        int Maxvotes = 0;
        int Winner = -1;
        boolean tie = false;

        for(int i = 0;i < N;i++){

            if(age[i] < 18) continue;

            int count = 0;
            for(int j = 0;j < N;j++){
                if(age[j] >= 18 && votes[j] == votes[i]){
                    count++;
                }
            }
            if(count > Maxvotes){
                Maxvotes = count;
                Winner = votes[i];
                tie = false;
            }
            else if(count == Maxvotes && Winner != votes[i]){
                tie = true;
            }
        }
        if(Maxvotes == 0 || tie) return -1;

        return Winner;
    }

    //Optimal Approach
    public static int OptimalFindWinner(int[] votes,int[] age){

        HashMap<Integer,Integer> map = new HashMap<>();
        int N = votes.length;

        for(int i = 0;i < N;i++){
            if(age[i] >= 18){
                map.put(votes[i],map.getOrDefault(votes[i],0)+1);
            }
        }
        if(map.isEmpty()) return -1;
            int maxCount = 0;
            int winner = -1;
            boolean tie = false;

            for(int candidate : map.keySet()){
                int count = map.get(candidate);
                if(count > maxCount){
                    maxCount = count;
                    winner = candidate;
                    tie = false;
                }
                else if(count == maxCount) {
                    tie = true;
                }
            }
            return tie?-1 : winner;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] VotesArray = new int[N];
        for(int i = 0;i < N;i++){
            VotesArray[i] = sc.nextInt();
        }

        int[] AgeArray = new int[N];
        for(int i = 0;i < N;i++){
            AgeArray[i] = sc.nextInt();
        }

        // System.out.println("Brute Force Approach : " +bruteFindWinner(VotesArray, AgeArray));
        System.out.println("Optimal Approach : " +OptimalFindWinner(VotesArray, AgeArray));

        sc.close();
    }
}
