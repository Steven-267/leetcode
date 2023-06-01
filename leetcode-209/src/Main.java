import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
    public int minSubArrayLen(int target, int[] nums) {
     int left = 0;
     int sum = 0;
     int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while(sum>=target){
                result = Math.min(result,right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE? 0 : result;
    }
  /*  public int minSubArrayLen(int target, int[] nums) {
        if(Arrays.stream(nums).sum()<target){
            return 0;
        }
        int k = nums.length;
        int slow = 0;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[slow];
            int fast;
            if(sum >= target){
              return 1;
            }else {
                for (fast = slow +1; fast< nums.length; fast++) {
                    sum += nums[fast];
                    if(sum >= target){
                        if((fast-slow+1)<count) {
                            count = fast - slow + 1;
                        }
                    }
                }
            }
            slow++;
        }
        return count;
    }*/
}
