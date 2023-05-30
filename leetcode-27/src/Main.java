import com.sun.deploy.panel.JreTableModel;

/**
 * @author Steven
 * @ClassName Main.java
 * @Description
 * @createTime 2023-05-30 12:22
 **/
public class Main {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    //使用双指针
    public static int removeElement(int[] nums, int val) {
        int slow = 0 ;
        for (int fast = 0; fast < nums.length ; fast++) {
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++ ;
            }
        }
        return slow;
    }



    //暴力解法
  /*  public static int removeElement(int[] nums, int val) {
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            if(nums[i] == val){
                for (int j = i + 1; j < count; j++){
                    nums[j - 1] = nums[j];
                }
                i-- ;
                count--;
            }
        }

        return count;

    }*/
}
