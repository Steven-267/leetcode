# Leetcode

## 数组

### 704（二分查找

<img src="C:/Users/Steven/AppData/Roaming/Typora/typora-user-images/image-20230530125326365.png" alt="image-20230530125326365" style="zoom: 80%;" />

#### 代码实现

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

#### 代码思路分析

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

### 27（双指针

![image-20230531121805272](C:/Users/Steven/AppData/Roaming/Typora/typora-user-images/image-20230531121805272.png)

#### 代码实现

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

#### 代码思路

##### 暴力

遍历每一个数，如果这个数和val一样的话就 就以这个数为开始后面每一位向前**覆盖**

![img](https://code-thinking.cdn.bcebos.com/gifs/27.%E7%A7%BB%E9%99%A4%E5%85%83%E7%B4%A0-%E5%8F%8C%E6%8C%87%E9%92%88%E6%B3%95.gif)

再定义一个计数器，每次覆盖就 - - 这样就可以获得新的数组长度

##### 双指针

规定一个**快指针**和一个**慢指针** 

❗❗❗❗❗❗❗❗慢指针 用来重新给数组进行赋值 **==快指针用来进行筛选==**❗❗❗❗❗❗❗❗❗

### 977（双指针

![image-20230601105206140](C:/Users/Steven/AppData/Roaming/Typora/typora-user-images/image-20230601105206140.png)

#### 代码实现

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

#### 代码思路

因为题目要求是平方数  所以一个集合的最大值只能是在头或者尾（负数），所以通过每次比较头尾两个数的平方 把大的值存放到一个新的数组 接着在原数组里舍弃掉这个最大值（i++或者j++）

其他也没什么要点!

### 209(双指针-==**滑动窗口法**==⭐⭐

![image-20230604222128061](C:/Users/Steven/AppData/Roaming/Typora/typora-user-images/image-20230604222128061.png)

#### 代码实现

##### 1.暴力：ac 15 没有用stream.add

```java
public int minSubArrayLen(int target, int[] nums) {
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
                    if(sum >= target && (fast-slow+1)<count){
                        count=fast-slow + 1;
                    }

                }if(slow ==0 && fast == nums.length &&count == Integer.MAX_VALUE){
                    return 0;
                }

            }
            slow++;
        }
        return count;
    }
```

##### 2.暴力优化：ac十八个 通过暴力加两层for加stream流的add方法

```java
   public int minSubArrayLen(int target, int[] nums) {
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
    }
```

##### 3.==**写不出来的双指针滑动窗口法  真的很牛！！！**==

```java
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
```

#### 代码思路

很难解释建议看视频https://www.bilibili.com/video/BV1tZ4y1q7XE/?spm_id_from=333.788&vd_source=0d2278f149b8b496ca34d34b8a956c02

![209.长度最小的子数组](https://code-thinking.cdn.bcebos.com/gifs/209.%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84.gif)

**不要以为for里放一个while就以为是O(n^2)啊， 主要是看每一个元素被操作的次数，每个元素在滑动窗后进来操作一次，出去操作一次，每个元素都是被操作两次，所以时间复杂度是 2 × n 也就是O(n)。**

### 59（边界处理问题

![image-20230605093557989](C:/Users/Steven/AppData/Roaming/Typora/typora-user-images/image-20230605093557989.png)

#### 代码实现

```java
 public static int[][] generateMatrix(int n) {
        int loop = 0;
        int start = 0;
        int count = 1;
        int i,j;
        int[][] res = new int[n][n];
        while(loop++ < n / 2){
            //从左到右
            for (j = start; j <n - loop ; j++) {
                res[start][j] = count++;
            }
            //从上到下
            for (i = start;i <  n - loop; i++){
                res[i][j] = count++;
            }
            //从右到左
            for (;j > start;j--){
                res[i][j] = count++;
            }
            //从下到上
            for (;i>start;i--){
                res[i][j] = count++;
            }
            start++;
        }if(n % 2 == 1){
            res[start][start] = count;
        }
        return res;
    }
```

#### 代码思路

![img](https://code-thinking-1253855093.file.myqcloud.com/pics/20220922102236.png)

通过分类 

首先

- 确定==**循环不变量原则**==❗❗❗ 每一行都通过 **左闭右开** 的的**规则**

- 第一个循环用来确定有几圈
  - 用n/2表示 但是奇数会有中间的一个单独存在
- 在第一个循环里包含四个循环
- 分别代表四条边的遍历
- 每一圈都遍历四条边

### 数组总结

![img](https://code-thinking-1253855093.file.myqcloud.com/pics/%E6%95%B0%E7%BB%84%E6%80%BB%E7%BB%93.png)

## 链表

### 203（

<img src="C:/Users/Steven/AppData/Roaming/Typora/typora-user-images/image-20230606100649483.png" alt="image-20230606100649483" style="zoom: 67%;" />

#### 代码实现

/**
 * 不添加虚拟节点方式
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 */

```java

    public ListNode removeElements1(ListNode head, int val) {
        //首先要判断并且定义头节点的值，判断是不是为是不是为val 并且头节点不能为空 如果头节点为空的话就直接返回null
        //找到一个不为空且值不等于val的节点做头节点
        while(head != null && head.val == val){
            head = head.next;
        }


        //（已经遍历过头节点前的值）如果头节点为null则直接返回head就可以-->其中没有符合val的值
        if(head == null){
            return head;
        }
        //如果成功走到这一步说明确定 head.val != val且 head ！= null -->可以开始遍历链表
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;//去除元素
            }else{
                pre = cur;//判断下一组
            }
            cur = cur.next;//判断下一组

        }
            return head;
    }
```



*/**
\* *** *添加虚节点方式
\* *** *时间复杂度* *O(n)
\* *** *空间复杂度* *O(1)
\* *** **@param** *head
\* *** **@param** *val
\* *** **@return
** **/*

```java
 public ListNode removeElements2(ListNode head, int val) {
        //第一步和方法一不一样 不需要判断head是否等于val
        if(head == null){
            return head;
        }
        //定义一个虚拟头节点
        ListNode dummy = new ListNode(-1,head);
        //主体遍历代码和方式一差不多
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
//        返回真正的头节点
        return dummy.next;
    }

```



//添加虚拟头节点并且省去pre

```java
public ListNode removeElements3(ListNode head, int val) {
        //第一步和方法一不一样 不需要判断head是否等于val
        if(head == null){
            return head;
        }
        //定义一个虚拟头节点
        ListNode dummy = new ListNode(-1,head);
        //主体遍历代码和方式一差不多
        ListNode cur = dummy;
        while(cur != null){
            if(cur.val == val){
                cur.next = cur.next.next;
            }else {
                cur.next = cur;
            }
            cur = cur.next;
        }
//        返回真正的头节点
        return dummy.next;
    }
```



#### 代码思路
