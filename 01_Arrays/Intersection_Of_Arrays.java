// Platform : Strivers SDE Sheet
// Level : Easy
// Approaches :
// 1)Brute Force Appraoch : Time Complexity : , Space Complexity : 
// 2)Optimal Approach : Time Complexity : , Space Complexity : 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Intersection_Of_Arrays {
    
    // Brute Approach
    public static int[] getIntersection(int[] nums1,int[] nums2){

        ArrayList<Integer> list = new ArrayList<>();

        boolean[] isVisited = new boolean[nums2.length];
        for(int i = 0;i < nums1.length;i++){
            for(int j = 0;j < nums2.length;j++){
                if(nums1[i] == nums2[j] && !isVisited[j]){
                    list.add(nums1[i]);
                    isVisited[j] = true;
                    break;
                }
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            result[i] = list.get(i);
        }

        return result;
    }

    // Optimal Approach
    public static int[] optimalIntersection(int[] nums1,int[] nums2){
        int N1 = nums1.length, N2 = nums2.length;
        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(i < N1 && j < N2){
            if(nums1[i] < nums2[j]){
                i++;
            }
            else if(nums2[j] < nums1[i]){
                j++;
            }
            else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[list.size()];
        for(int k = 0;k < list.size();k++){
            result[k] = list.get(k);
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N1 = sc.nextInt();

        int[] nums1 = new int[N1];
        for(int i = 0;i < N1;i++){
            nums1[i] = sc.nextInt();
        }

        int N2 = sc.nextInt();
        int[] nums2 = new int[N2];
        for(int i = 0;i < N2;i++){
            nums2[i] = sc.nextInt();
        }

        // System.out.println(Arrays.toString(getIntersection(nums1, nums2)));
        System.out.println(Arrays.toString(optimalIntersection(nums1, nums2)));
        sc.close();
    }
}