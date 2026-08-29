// Time Complexity : O(2 ^ n),Space Complexity : O(n)

public class CountSubsequencesSumK {

     private static int generateSequence(int[] arr,int idx,int s,int sum){
        if(idx == arr.length){
            if(s == sum){
                return 1;
            }
            else return 0;
        }

        int left = generateSequence(arr, idx + 1,s + arr[idx],sum);
        
        int right = generateSequence(arr, idx + 1, s - arr[idx], sum);

        return left + right;
    }

     public static int printSequence(int[] nums,int sum){

        int count = generateSequence(nums, 0, 0,sum);
        return count;
}
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int sum = 2;

        System.out.println(printSequence(nums, sum));
    }
}
