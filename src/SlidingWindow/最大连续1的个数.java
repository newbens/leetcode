package SlidingWindow;

public class 最大连续1的个数 {
    public static void main(String[] args){
        int[] a = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(new 最大连续1的个数().longestOnes(a, 2));
    }
    public int longestOnes(int[] A, int K) {
        int res = 0;
        int n = A.length;
        int ri = 0,le = 0,num = 0; //num代表0的个数
        while (ri < n) {
            if(A[ri] == 0) num++;
            while (num > K) { //窗口中0的个数大于k，说明要移动，移动到窗口中0的个数小于k
                if(A[le] == 0) num--;
                le++;
            }
            res = Math.max(res, ri - le + 1);
            ri++;
        }
        return res;
    }
}
