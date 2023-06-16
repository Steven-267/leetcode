import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //判断nums[i]是否合法
            //规则：nums[i]如果大于0 因为数组是排好序的 所以三数相加不可能等于零
            if(nums[i] >0){
                return result;
            }

            //对a进行去重
            if( i>0 && nums[i] == nums[i-1]){
                continue;
            }

            //以i为基础 对left和right 进行遍历
            int left = i+1;
            int right = nums.length-1;

            while(right>left){

                int sum = nums[i]+nums[left]+nums[right];
                //对sum进行判断
                if(sum >0){
                    right--;
                }else if(sum < 0 ){
                    left++;
                }else{
                    //添加结果集到返回值中
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //对b,c进行去重操作
                    while(right>left && nums[right] == nums[right-1]){
                        right--;
                    }
                    while(right > left && nums[left] == nums[left+1]){
                        left++;
                    }
                    right--;
                    left++;

                }


            }

        }
        return result;


    }
}
