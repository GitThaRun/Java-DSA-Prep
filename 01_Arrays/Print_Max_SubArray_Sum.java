//Follow-up of kadane's Algorithm problem
public class Print_Max_SubArray_Sum {
    
    public static int printMaxSubarraySum(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;

        int start = 0;
        int ansStart = -1, ansEnd = -1;

        for(int i = 0;i < nums.length;i++){

            if(sum == 0){
                start = i;
            }
            sum += nums[i];
            if(sum > max){
                max = sum;
                ansStart = start;
                ansEnd = i;
            }


            if(sum < 0){
                sum = 0;
            }
        }

        System.out.print("The Subarray is : [");
        for(int i = ansStart;i <= ansEnd;i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

        return (int) max;
    }

    public static void main(String[] args){
        int[] arr = {2,1,-3,4,-1,2,1,-5,4};

        int maxSum = printMaxSubarraySum(arr);
        System.out.println("The Maximum Subarray Sum is : "+maxSum);
    }
}
