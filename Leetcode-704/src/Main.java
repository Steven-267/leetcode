/**
 * @author Steven
 * @ClassName Main.java
 * @Description 给定一个 n 个元素有序的（升序）整型数组 nums
 * 和一个目标值 target  ，写一个函数搜索 nums 中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/binary-search 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @createTime 2023-05-29 19:29
 **/
public class Main {
    public static void main(String[] args) {
        //主要算法：二分查找法
        int[] nums = {0,1,2,3,4,5,7,8,9};
        int target = 6;
       int i =  searchzbyb(nums,target);
        if(i == -1){
            System.out.println("nothing");
        }else{
            System.out.println(nums[i]);
        }
    }

    /**
     * 在做这道题的时候首先要确定区间的选择
     * 是选择哪一种区间  对方法中的条件判断语句都存在不同
     * 1.左闭右闭
     * 对于right的值是length - 1因为是闭区间
     * 其中因为left等于right是合法的
     * 所以在while中可以写 left<=right
     * 而在对mid进行赋值时候
     * 因为右区间闭的 相当于已经判断过right这个索引的值
     * 所以就直接跳过right  直接让mid = right - 1；
     * 对于left也是同理 因为是左闭所以直接
     * mid = left + 1；
     * 2.左闭右开
     * right的值是length 因为是开区间
     * 因为left == right是不合法的
     * 所以不能取到right
     *
     * 而在right中对mid定义时候
     * 因为是开区间 所以直接使 mid = right即可
     */
    public static int searchzbyb(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int i = 0;

        while(right >= left){
            i = (right + left) / 2 ;
            if(target < nums[i]){
                right = i -1 ;
            }else if(target > nums[i]){
                left = i +1 ;
            }else {
                return i ;
            }
        }
       return -1;
    }
    public static int searchzbyk(int[] nums, int target) {
        int right = nums.length;
        int left = 0;
        int i = 0;

        while(right > left){
            i = (right + left) / 2 ;
            if(target < nums[i]){
                right = i  ;
            }else if(target > nums[i]){
                left = i +1 ;
            }else {
                return i ;
            }
        }
        return -1;
    }
}
