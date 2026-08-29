// Print subsequences whose sum is equal to 'K'
// Time Complexity : O(n * 2 ^ n), Space Complexity : O(n * 2 ^ n)
import java.util.ArrayList;
import java.util.List;

public class SubsequenceSumK {
    private static void generateSequence(int[] arr,int idx,int s,int sum,List<Integer> cur,List<List<Integer>> ans){
        if(idx == arr.length){
            if(s == sum){
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        cur.add(arr[idx]);
        s += arr[idx];
        generateSequence(arr, idx + 1,s,sum,cur, ans);
        s -= arr[idx];

        cur.remove(cur.size() - 1);
        generateSequence(arr, idx + 1,s,sum,cur, ans);
    }
     public static List<List<Integer>> printSequence(int[] nums,int sum){
        List<Integer> current= new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        generateSequence(nums, 0, 0,sum,current,result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2};
        int sum = 3;
        List<List<Integer>> result = printSequence(nums,sum);

        for(int i = 0;i < result.size();i++){
            System.out.print(result.get(i));

            if(i < result.size() - 1){
                System.out.print(" , ");
            }
        }
    }
}
