
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    // Brute
    public static List<List<Integer>> bruteThreeSum(int[] nums){
        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0;i < nums.length;i++){
            Set<Integer> set = new HashSet<>();

            for(int j = i + 1;j < nums.length;j++){
                int third = -(nums[i] + nums[j]);

                if(set.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],third);
                    Collections.sort(temp);

                    result.add(temp);
                }

                set.add(nums[j]);
            }
        }
        return new ArrayList<>(result);
    }

    // Optimal
    public static List<List<Integer>> optimalThreeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        
        for(int i = 0;i < nums.length - 2;i++){
            if(nums[i] > 0) break;

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> ans = optimalThreeSum(nums);

        for(List<Integer> l : ans){
            for(int num : l){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
