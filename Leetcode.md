# Leetcode

## 704（二分查找

<img src="C:/Users/Steven/AppData/Roaming/Typora/typora-user-images/image-20230530125326365.png" alt="image-20230530125326365" style="zoom: 80%;" />

### 代码实现

```java
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
```

### 代码思路分析

- 首先要确定二分中左右区间的开闭情况  

  - 左闭右闭

  - 左闭右开
  - 左开一般少见

- 存在疑问的点

  - right的定义值究竟是**leng**还是**leng - 1**
  - 循环结束条件究竟是==**right > left**==还是==**right >= left**==
  - 更新right时究竟是 ==**i**==  还是  **==i - 1==**
  - 更新left究竟是 ==**i**== 还是 ==**i+1**==
  - <img src="C:/Users/Steven/AppData/Roaming/Typora/typora-user-images/image-20230530130140077.png" alt="image-20230530130140077" style="zoom:67%;" />

- 左闭右闭

  - 当选择左闭右闭时候 right是可以合法的 所以**right = leng - 1**
  - 因为right是合法的 所以left是可以和right相等的 所以循环的结束条件就是 left <= right
  - 因为nums[i] > target 而且右区间是合法的 所以不需要再判断 i 了 所以就直接使right = i - 1
  - 同理，left是闭区间 所以left = i + 1

- 左闭右开

  - 当选择左闭右闭时候 right是可以不合法的 所以**right = leng **  这样才可以判断到下标为leng - 1 的数如果right = leng - 1，则只能判断到leng - 2 的数 这样显然是不合理的
  - 因为right是不合法的 所以left是不可以和right相等的 所以循环的结束条件就是 left < right
  - 因为nums[i] > target 所以也是不需要再次判断 i 了 **但是右区间是不合法的**  所以就直接使right = i  这样才可以判断到i - 1 的数 如果使right = leng - 1 的话 就访问不到 leng - 1的值了 只能访问到leng - 2 的值 这样显然也是不合理的
  - 同理，left是闭区间 所以left = i + 1

## 27（双指针

![image-20230531121805272](C:/Users/Steven/AppData/Roaming/Typora/typora-user-images/image-20230531121805272.png)

### 代码实现

```java
//暴力解法
    public static int removeElement(int[] nums, int val) {
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

    }
```

```java
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
```

### 代码思路

#### 暴力

遍历每一个数，如果这个数和val一样的话就 就以这个数为开始后面每一位向前**覆盖**

![img](https://code-thinking.cdn.bcebos.com/gifs/27.%E7%A7%BB%E9%99%A4%E5%85%83%E7%B4%A0-%E5%8F%8C%E6%8C%87%E9%92%88%E6%B3%95.gif)

再定义一个计数器，每次覆盖就 - - 这样就可以获得新的数组长度

#### 双指针

规定一个**快指针**和一个**慢指针** 

❗❗❗❗❗❗❗❗慢指针 用来重新给数组进行赋值 **==快指针用来进行筛选==**❗❗❗❗❗❗❗❗❗

# 977（双指针

![image-20230601105206140](C:/Users/Steven/AppData/Roaming/Typora/typora-user-images/image-20230601105206140.png)

### 代码实现

```java
public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i],2);
        }
       Arrays.sort(nums);
        return nums;
    }
```

```java
  public int[] sortedSquares(int[] nums) {
        int k = nums.length - 1;
        int[] res =new int[nums.length];//易错点！！！
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
```

### 代码思路

因为题目要求是平方数  所以一个集合的最大值只能是在头或者尾（负数），所以通过每次比较头尾两个数的平方 把大的值存放到一个新的数组 接着在原数组里舍弃掉这个最大值（i++或者j++）

其他也没什么要点!
