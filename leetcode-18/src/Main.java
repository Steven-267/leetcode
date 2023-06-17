import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>target && nums[i]>0){
            return result;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            for (int j  = i+1; j <nums.length ; j++) {
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while(right>left){
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum < target){
                        left++;
                    }else if(sum > target){
                        right--;
                    }else{
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(right>left && nums[right] == nums[right-1]){
                            right--;
                        }
                        while(right >left && nums[left] == nums[left+1]){
                            left++;
                        }
                        right--;
                        left++;
                    }

                }

            }

        }
        return result;
    }
}
