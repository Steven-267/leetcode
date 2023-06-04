public class Main {
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
}
