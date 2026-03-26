// Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

// Examples:

// Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
// Output: [3, 4, 4, 3]
// Explanation:
// First window is [1, 2, 1, 3], count of distinct numbers is 3.
// Second window is [2, 1, 3, 4] count of distinct numbers is 4.
// Third window is [1, 3, 4, 2] count of distinct numbers is 4.
// Fourth window is [3, 4, 2, 3] count of distinct numbers is 3.

// Platform : Geeks For Geeks
// Difficulty : Medium
// Approaches :
// 1) Brute Force -> Time : O(n*k), Space : O(k)
// 2) Optimal(Sliding Window + Hashing) -> Time : O(n), Space : O(k)

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// Brute Force

public class Count_Distinct_Elements {
    
    public static ArrayList<Integer> bruteCountElements(int[] arr,int k){
        
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i <= arr.length - k;i++){
            HashSet<Integer> set = new HashSet<>();

            for(int j = i;j < i + k;j++){

                set.add(arr[j]);
            }
            result.add(set.size());
        }
        return result;
    }

    // Optimal Approach

    public static ArrayList<Integer> optimalCountElements(int[] arr,int k){

        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < k;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        
        for(int i = k;i< arr.length;i++){
            result.add(map.size());
            
            int firstElement = arr[i - k];
            
            int newFreq = map.get(firstElement) - 1;
            
            if(newFreq == 0){
                map.remove(firstElement);
            }else{
                map.put(firstElement,newFreq);
            }
            
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        result.add(map.size());
        
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int nums[] = new int[N];
        for(int i = 0;i < N;i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        // System.out.println(bruteCountElements(nums, k));
        System.out.println(optimalCountElements(nums, k));
        sc.close();
    }
}
