import java.util.Arrays;

/**
 * @author Steven
 * @ClassName Solution.java
 * @Description
 * @createTime 2023-05-30 11:04
 **/
class Solution {
    public int removeElement(int[] nums, int val) {
        int count = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val){
                for (int j = i; j < count - 1; j++){
                    nums[j] = nums[j + 1];
                }
                count--;
            }
        }

        return count;

    }

}
