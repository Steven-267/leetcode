import java.util.HashMap;
import java.util.Map;

public class leetcode_1 {
    public int[] twoSum(int[] nums, int target) {
        //创建一个数组来存储返回的两个索引
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];

            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);

        }

        return res;


    }
}
