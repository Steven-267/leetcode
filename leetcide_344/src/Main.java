public class Main {
    public void reverseString(char[] s) {
        int right = s.length-1;
        int left = 0;
        char c;
        while(left < right){
            c = s[right];
            s[right] = s[left];
            s[left] = c;
            right--;
            left++;
        }
    }
}
