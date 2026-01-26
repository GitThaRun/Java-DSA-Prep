// Problem Statement : You are given an integer array arr of size N and an integer S representing a search element.
// First, remove all duplicate elements from the array without changing the original order of elements.

// After removing duplicates:
// · Find the index (0-based) of the search element S in the modified array.
// · If the search element is not present, print -1.

// Input Format

// 1. The first line contains an integer N — the size of the array.

// 2. The second line contains N space-separated integers representing the array arr.

// 3. The third line contains an integer S — the search element.

// Output Format

//  Print a single integer:
// The 0-based index of the search element after removing duplicates.
// Print -1 if the element is not found.

// Brute Force Approach: Time Complexity: O(N^2), Space Complexity: O(N)
// Optimal Approach: Time Complexity: O(N), Space Complexity: O(N)

import java.util.HashSet;
import java.util.Scanner;

public class SearchAfterRemovingDuplicates {
    
    // Brute Force Approach
    public static int bruteSearchAndRemove(int[] arr,int s){
        int[] unique = new int[arr.length];

        int size = 0;
        for(int i = 0;i < arr.length;i++){
            boolean isFound = false;

            for(int j = 0;j < size;j++){
                if(arr[i] == unique[j]){
                    isFound = true;
                    break;
                }
                if(!isFound){
                    unique[size] = arr[i];
                    size++;
                }
            }
        }
        for(int i = 0;i < size;i++){
                if(unique[i] == s){
                    return i;
                }
            }
        return -1;
    }

    // Optimal Approach
    public static int optimalSearchAndRemove(int[] arr,int s){

        HashSet<Integer> set = new HashSet<>();
        int idx = 0;

        for(int i = 0;i < arr.length;i++){
            if(!set.contains(arr[i])){
                if(arr[i] == s) return idx;
                set.add(arr[i]);
                idx++;
        }
    }
        return -1;}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println("Enter " + N + " elements : ");

        int[] arr = new int[N];
        for(int i = 0;i < N;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the search element : ");
        int s = sc.nextInt();
        // System.out.println("Brute Force Approach : "+optimalSearchAndRemove(arr, s));
        System.out.println("Optimal Approach : "+optimalSearchAndRemove(arr, s));
        sc.close();
    }
}