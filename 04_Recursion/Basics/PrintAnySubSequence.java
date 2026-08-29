// Print any one subsequence whose sum is equal to 'sum'
// Time Complexity : O(2 ^ n), Space Complexity : O(n)
import java.util.ArrayList;
import java.util.List;

public class PrintAnySubSequence {

    private static boolean generateSequence(int[] arr,int idx,int s,int sum,List<Integer> cur){
        if(idx == arr.length){
            return s == sum;
        }

        cur.add(arr[idx]);

        if(generateSequence(arr, idx + 1,s + arr[idx],sum,cur)){
            return true;
        }

        cur.remove(cur.size() - 1);
        return generateSequence(arr, idx + 1,s,sum,cur);
    }
    public static List<Integer> printSequence(int[] nums,int sum){
        List<Integer> current= new ArrayList<>();

        if(generateSequence(nums, 0, 0,sum,current)) return current;
        return new ArrayList<>();
}
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int sum = 2;
        List<Integer> result = printSequence(nums,sum);

        System.out.println(result);
    }
}