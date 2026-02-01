// Problem statement : Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.
// The union of two arrays can be defined as the common and distinct elements in the two arrays.
// NOTE: Elements in the union should be in ascending order.

// Input:n = 5,m = 5 arr1[] = {1,2,3,4,5}  arr2[] = {2,3,4,4,5}
// Output: {1,2,3,4,5}

// Input:n = 10,m = 7,arr1[] = {1,2,3,4,5,6,7,8,9,10}arr2[] = {2,3,4,4,5,11,12}
// Output: {1,2,3,4,5,6,7,8,9,10,11,12}

// Platform : Strivers Sheet
// Level : Easy
// Approaches : 
// 1)Brute Force Approach : Time Complexity : O((n + m) log (n + m)), Space Complexity : O(n + m)
// 2)Optimal Approach : Time Complexity : O(n + m), Space Complexity : O(n + m)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Union_Of_Sorted_Arrays {
    
    // Brute Approach
    public static int[] bruteSortedArray(int[] nums1,int[] nums2){
        TreeSet<Integer> set = new TreeSet<>();

        for(int e1 : nums1){
            set.add(e1);
        }
        for(int e2 : nums2){
            set.add(e2);
        }

        int[] union = new int[set.size()];
        int idx = 0;
        for(int i : set){
            union[idx++] = i;
        }

        return union;
    }
    
    // Optimal Appraoch
    public static int[] unionArray(int[] nums1,int[] nums2){

        int n1 = nums1.length,n2 = nums2.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (i < n1 && j < n2) {

            if (nums1[i] < nums2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
            }
            else if (nums1[i] > nums2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != nums2[j]) {
                    list.add(nums2[j]);
                }
                j++;
            }
            else { 
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        while (i < n1) {
            if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                list.add(nums1[i]);
            }
            i++;
        }

        while (j < n2) {
            if (list.isEmpty() || list.get(list.size() - 1) != nums2[j]) {
                list.add(nums2[j]);
            }
            j++;
        }

        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        for(int i = 0;i < n1;i++){
            nums1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] nums2 = new int[n2];
        for(int i = 0;i<n2;i++){
            nums2[i] = sc.nextInt();
        }
        // System.out.println(Arrays.toString(bruteSortedArray(nums1, nums2)));
        System.out.println(Arrays.toString(unionArray(nums1,nums2)));
        sc.close();
    }
}
