// Time Complexity : O(n * 2^n) , Space Complexity : O(n * 2^n)
import java.util.ArrayList;
import java.util.List;

public class PrintSubsequences {
    private static void generateSequence(int[] arr,int idx,List<Integer> cur,List<List<Integer>> ans){
        if(idx == arr.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(arr[idx]);
        generateSequence(arr, idx + 1, cur, ans);
        cur.remove(cur.size() - 1);
        generateSequence(arr, idx + 1, cur, ans);
    }
    public static List<List<Integer>> printSequence(int[] nums){
        List<Integer> current= new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        generateSequence(nums, 0, current,result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2};

        List<List<Integer>> result = printSequence(nums);

        for(int i = 0;i < result.size();i++){
            System.out.print(result.get(i));

            if(i < result.size() - 1){
                System.out.print(" , ");
            }
        }
    }
}
