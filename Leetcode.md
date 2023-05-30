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

