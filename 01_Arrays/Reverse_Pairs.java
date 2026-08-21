// Given an integer array nums, return the number of reverse pairs in the array.
// A reverse pair is a pair (i, j) where:

// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].
 
// Example 1:

// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1

// Platform : Leetcode
// Level : Hard
// Time Complexity : O(NlogN), Space Complexity : O(N)
public class Reverse_Pairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length - 1);
    }
    private int mergeSort(int[] nums,int low, int high){
        if(low >= high) return 0;

        int mid = low + (high - low) / 2;

        int count = 0;

        count += mergeSort(nums,low,mid);
        count += mergeSort(nums,mid + 1,high);

        int j = mid + 1;

        for(int i = low;i <= mid;i++){
            while(j <= high && (long)nums[i] > 2L * nums[j]){
            j++;
        }
        count += j - (mid + 1);
        }

        merge(nums,low,mid,high);

        return count;
    }

    private void merge(int[] nums,int low,int mid,int high){
        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= high){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }
            else{
                temp[k++] = nums[j++];
            }
        }

        while(i <= mid){
            temp[k++] = nums[i++];
        }
        while(j <= high){
            temp[k++] = nums[j++];
        }

        for(int x = 0;x < temp.length;x++){
            nums[low + x] = temp[x];
        }
    }

    public static void main(String[] args) {
        Reverse_Pairs obj = new Reverse_Pairs();
        int[] nums = {1,3,2,3,1};
        System.out.println(obj.reversePairs(nums));
    }
}
