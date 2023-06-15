import java.util.HashMap;
import java.util.Map;

public class Main {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        //和两数之和思路有点像，先把一组数放到map里 再用一个target去map里找  降低时间复杂度
        for (int i :
                nums1) {
            int sum = 0;
            for (int j :
                    nums2) {
                sum = i + j ;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (int i :
                nums3) {
            for (int j :
                    nums4) {
                res += map.getOrDefault(0 - i - j, 0 );
            }
        }
        return res;


    }
}
