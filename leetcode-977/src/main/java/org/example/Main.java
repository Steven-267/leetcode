package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
    //暴力解法
 /*   public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i],2);
        }
       Arrays.sort(nums);
        return nums;
    }*/

    //双指针
  /*  public int[] sortedSquares(int[] nums) {
        int k = nums.length-1;
        int i = 0;
        int j = nums.length-1;
        int[] res = new int[nums.length];
        while (i <= j){
            if(nums[i] *nums[i]> nums[j]*nums[j]){
                res[k--] = nums[i] *nums[i];
                i++;
            }else{
                res[k--] = nums[j]*nums[j];
                    j--;
            }
        }
        return res;
    }*/
    public int[] sortedSquares(int[] nums) {
        int k = nums.length - 1;
        int[] res =new int[nums.length];
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (Math.pow(nums[i], 2) > Math.pow(nums[j], 2)) {
                res[k--] = (int) Math.pow(nums[i], 2);
                i++;
            } else {
                res[k--] = (int) Math.pow(nums[j], 2);
                j--;
            }

        }
        return res;
    }

}